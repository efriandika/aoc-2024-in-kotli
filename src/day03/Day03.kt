package day03

import readInput

fun main() {
    val inputLines = readInput("day03/input")

    println("Part #1:" + part1(inputLines))
    println("Part #2:" + part2(inputLines))
}

fun part1(inputLines: List<String>): Int {
    val regex = Regex("mul\\((\\d+),(\\d+)\\)")
    var result = 0;

    inputLines.forEach { input ->
        val matches = regex.findAll(input)

        for (match in matches) {
            val x = match.groupValues[1].toInt();
            val y = match.groupValues[2].toInt();

            result += x * y;
        }
    }

    return result;
}

fun part2(inputLines: List<String>): Int {
    val regex = Regex("(mul|don't|do)\\((\\d*),?(\\d*)\\)")
    var enabled = true;
    var result = 0;

    inputLines.forEach { input ->
        val matches = regex.findAll(input)

        for (match in matches) {
            val operator = match.groupValues[1]

            when (operator) {
                "do" -> enabled = true
                "don't" -> enabled = false
                else -> { // Note the block
                    if (enabled) {
                        val x = match.groupValues[2].toInt()
                        val y = match.groupValues[3].toInt()

                        result += x * y;
                    }
                }
            }
        }
    }

    return result;
}


