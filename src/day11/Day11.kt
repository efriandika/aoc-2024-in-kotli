package day11

import readInput

fun main() {
    val inputLines = readInput("day11/input")
    val inputLinesSample = readInput("day11/input-sample")

    val initialStones = inputLines[0].split(' ').map { it.toLong() }
    val initialStonesSample = inputLinesSample[0].split(' ').map { it.toLong() }

    println("Part #1 (Sample):" + part1(initialStonesSample))
    println("Part #1:" + part1(initialStones))
    println("Part #2 (Sample):" + part2(initialStonesSample))
    println("Part #2:" + part2(initialStones))
}

fun part1(inputLines: List<Long>): Long {
    return countStonesTransform(inputLines, 25);
}

fun part2(inputLines: List<Long>): Long {
    return countStonesTransform(inputLines, 75);
}

fun countStonesTransform(initialStones: List<Long>, blinks: Int): Long {
    val memo = mutableMapOf<Long, List<Long>>()
    var stoneCounts = mutableMapOf<Long, Long>()

    // Initialize the freq map with the initial stone
    initialStones.forEach { stoneCounts[it] = stoneCounts.getOrDefault(it, 0) + 1 }

    for (i in 0..<blinks) {
        val newStoneCounts = mutableMapOf<Long, Long>()

        for ((stone, count) in stoneCounts) {
            var transformed: List<Long>

            if (memo.containsKey(stone)) {
                transformed = memo[stone]!!
            } else {
                if (stone == 0L) {
                    transformed = listOf(1)
                } else if (stone.toString().length % 2 == 0) {
                    val str = stone.toString()
                    val mid = str.length / 2
                    val left = str.slice(0..<mid).toLong()
                    val right = str.slice(mid..<str.length).toLong()

                    transformed = listOf(left, right)
                } else {
                    transformed = listOf(stone * 2024)
                }

                memo[stone] = transformed
            }

            for (newStone in transformed) {
                newStoneCounts[newStone] = newStoneCounts.getOrDefault(newStone, 0) + count
            }
        }

        stoneCounts = newStoneCounts
    }

    // Calculate the total number of the stone
    return stoneCounts.values.sum();
}


