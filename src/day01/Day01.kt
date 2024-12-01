package day01

import readInput
import kotlin.math.abs

fun main() {
    val inputLines = readInput("day01/input")

    println("Part #1:" + part1(inputLines))
    println("Part #2:" + part2(inputLines))
}

fun part1(inputLines: List<String>): Int {
    val leftList = ArrayList<Int>();
    val rightList = ArrayList<Int>();

    inputLines
        .map { inputLine -> inputLine.split("   ") }
        .forEach { input ->
            leftList.add(input[0].toInt())
            rightList.add(input[1].toInt())
    }

    val sortedLeftList = leftList.sorted();
    val sortedRightList = rightList.sorted();

    return sortedLeftList.foldIndexed(0) { index, acc, item -> acc + abs(item - sortedRightList[index]) }
}

fun part2(inputLines: List<String>): Number {
    val leftList = ArrayList<Int>();
    val rightMap = mutableMapOf<Int, Int>();

    inputLines
        .map { inputLine -> inputLine.split("   ") }
        .forEach { input ->
            val x = input[0].toInt();
            val y = input[1].toInt();

            leftList.add(x)
            rightMap[y] = rightMap[y]?.plus(1) ?: 1
        }

    return leftList.fold(0) { acc, item -> acc + (rightMap[item]?.times(item) ?: 0) }
}


