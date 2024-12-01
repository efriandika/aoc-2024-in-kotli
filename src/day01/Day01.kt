package day01

import readInput
import kotlin.math.abs

fun main() {
    val inputLines = readInput("day01/input")

    println("Part #1:" + part1(inputLines))
    println("Part #2:" + part2(inputLines))
}

fun part1(inputLines: List<String>): Number {
    val leftList = ArrayList<Int>();
    val rightList = ArrayList<Int>();

    for (inputLine in inputLines) {
        val input = inputLine.split("   ")

        leftList.add(input[0].toInt())
        rightList.add(input[1].toInt())
    }

    val sortedLeftList = leftList.sorted();
    val sortedRightList = rightList.sorted();
    var result = 0;

    for ((index, left) in sortedLeftList.withIndex()) {
        result += abs(left - sortedRightList[index])
    }

    return result
}

fun part2(inputLines: List<String>): Number {
    val leftList = ArrayList<Int>();
    val rightMap = mutableMapOf<Int, Int>();
    var result = 0;

    for (inputLine in inputLines) {
        val input = inputLine.split("   ")
        val x = input[0].toInt();
        val y = input[1].toInt();

        leftList.add(x)
        rightMap[y] = rightMap[y]?.plus(1) ?: 1
    }

    for (left in leftList) {
        result += rightMap[left]?.times(left) ?: 0
    }

    return result
}


