package day02

import readInput

fun main() {
    val inputLines = readInput("day02/input")

    println("Part #1: ${part1(inputLines)}")
    println("Part #2: ${part2(inputLines)}")
}

fun part1(inputLines: List<String>): Int {
    return inputLines.count { !isUnsafe(it.split(' ')) }
}

fun part2(inputLines: List<String>): Int {
    return inputLines.count { isSafeWithDampener(it.split(' ')) }
}

fun isSafeWithDampener(values: List<String>): Boolean {
    if (!isUnsafe(values)) {
        return true
    }

    for (i in values.indices) {
        val modifiedValues = values.toMutableList().apply { removeAt(i) }

        if (!isUnsafe(modifiedValues)) {
            return true
        }
    }

    return false
}

fun isUnsafe (values: List<String>): Boolean {
    var prevValue = values[0].toInt()
    var lastDiff = 0

    for (i in 1..<values.size) {
        val diff = values[i].toInt() - prevValue

        if ((diff == 0 || diff > 3 || diff < -3) || ((lastDiff < 0 && diff > 0) || (lastDiff > 0 && diff < 0))) {
            return true;
        }

        prevValue = values[i].toInt();
        lastDiff = diff
    }

    return false;
}

