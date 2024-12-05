package org.example.years.year2023

import org.example.years.DayI

object DayOne : DayI{
    override fun part1(input: String): Int {
        return input.trimIndent().lines().sumOf { line -> (line.find { it.isDigit() }.toString() + line.findLast { it.isDigit() }).toInt()  }
    }

    override fun part2(input: String): Int {
        var mutableInput = input
        val dictMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
        dictMap.forEach {entry -> mutableInput = mutableInput.replace(entry.key.toRegex()) { match -> dictMap[match.value].toString() + match.value } }
        println(mutableInput)
        return part1(mutableInput)
    }
}