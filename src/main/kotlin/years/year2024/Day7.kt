package org.example.years.year2024

import org.example.years.DayI

object Day7 : DayI {

    override fun part1(input: String): Long {

        return input.trim().lines().sumOf {
            val (sum, numbers) = it.split(": ")[0].toLong() to it.split(": ")[1].split(" ").map (String::toLong)
            if (recursiveCalc(sum, numbers.toMutableList()) != 0) sum else 0
        }
    }

    override fun part2(input: String): Long {

        return input.trim().lines().sumOf {
            val (sum, numbers) = it.split(": ")[0].toLong() to it.split(": ")[1].split(" ").map (String::toLong)
            if (recursiveCalcWithConc(sum, numbers.toMutableList()) != 0) sum else 0
        }
    }

    private fun recursiveCalc (sum: Long, numbers: MutableList<Long>): Int{

        if (sum < numbers[0]) return 0
        if (numbers.size < 2) { return if (sum == numbers[0]) 1 else 0 }

        return recursiveCalc(sum, numbers.drop(2).toMutableList().also { it.addFirst(numbers[0] + numbers[1]) }) +
                recursiveCalc(sum, numbers.drop(2).toMutableList().also { it.addFirst(numbers[0] * numbers[1]) })
    }

    private fun recursiveCalcWithConc (sum: Long, numbers: MutableList<Long>): Int{

        if (sum < numbers[0]) return 0
        if (numbers.size < 2) { return if (sum == numbers[0]) 1 else 0 }

        println((numbers[0].toString() + numbers[1].toString()))

        return recursiveCalc(sum, numbers.drop(2).toMutableList().also { it.addFirst(numbers[0] + numbers[1]) }) +
                recursiveCalc(sum, numbers.drop(2).toMutableList().also { it.addFirst(numbers[0] * numbers[1]) }) +
                recursiveCalc(sum, numbers.drop(2).toMutableList().also { it.addFirst((numbers[0].toString() + numbers[1].toString()).toLong()) })
    }
}