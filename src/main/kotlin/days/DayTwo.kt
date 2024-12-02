package org.example.days

import kotlin.math.abs

object DayTwo {
    fun part1(input: String): Int {
        return input.trimIndent().lines().count { line ->
            val numbersArray = line.trim().split(Regex("\\s+")).map { it.toInt() }
            safeDecisionHelper(numbersArray)
        }
    }

    fun part2(input: String): Int {
        return input.trimIndent().lines().count { line ->
            val numbersArray = line.trim().split(Regex("\\s+")).map { it.toInt() }
            safeDecisionHelper(numbersArray) || numbersArray.indices.map { safeDecisionHelper(numbersArray.filterIndexed { index, _ -> index != it }) }.count { it -> it } > 0
        }
    }

    private fun safeDecisionHelper(numbersArray: List<Int>): Boolean {
       return (0..numbersArray.size-2).map { abs(numbersArray[it] - numbersArray[it + 1]) }.count { value -> value > 3 || value <= 0 } == 0
                && (numbersArray == numbersArray.sorted() || numbersArray == numbersArray.sortedDescending())
    }
}