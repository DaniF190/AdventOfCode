package org.example.years.year2024

import org.example.years.DayI
import kotlin.math.abs

object DayTwo : DayI {
    override fun part1(input: String): Long {
        return input.trimIndent().lines().count { line ->
            val numbersArray = line.trim().split(Regex("\\s+")).map { it.toInt() }
            safeDecisionHelper(numbersArray)
        }.toLong()
    }

    override fun part2(input: String): Long {
        return input.trimIndent().lines().count { line ->
            val numbersArray = line.trim().split(Regex("\\s+")).map { it.toInt() }
            safeDecisionHelper(numbersArray) || numbersArray.indices.map { safeDecisionHelper(numbersArray.filterIndexed { index, _ -> index != it }) }.count { it -> it } > 0
        }.toLong()
    }

    private fun safeDecisionHelper(numbersArray: List<Int>): Boolean {
       return (0..numbersArray.size-2).map { abs(numbersArray[it] - numbersArray[it + 1]) }.count { value -> value > 3 || value <= 0 } == 0
                && (numbersArray == numbersArray.sorted() || numbersArray == numbersArray.sortedDescending())
    }
}