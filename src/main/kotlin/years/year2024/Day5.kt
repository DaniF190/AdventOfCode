package org.example.years.year2024

import org.example.years.DayI

object Day5 : DayI {
    override fun part1(input: String): Long{

        val ruleList = input.lines().subList(0, input.lines().indexOf("") - 1).map { rule ->
            val (first, second) = rule.split("|").map { it.toInt() }
            first to second
        }

        return input.lines().subList(input.lines().indexOf("") + 1, input.lines().size - 1).map { line ->
            line.split(",").map { it.toInt() }
        }.sumOf { line ->
            var isValid = true
            ruleList.forEach { rule ->
                if (rule.first in line && rule.second in line && line.indexOf(rule.second) < line.indexOf(rule.first)) isValid = false
            }
            if (isValid) line[line.size / 2] else 0
        }.toLong()
    }

    override fun part2(input: String): Long {

        val ruleList = input.lines().subList(0, input.lines().indexOf("") - 1).map { rule ->
            val (first, second) = rule.split("|").map { it.toInt() }
            first to second
        }

        return input.lines().subList(input.lines().indexOf("") + 1, input.lines().size).map { line ->
            line.split(",").map { it.toInt() }
        }.sumOf { line ->
            var isValid = true
            var sumValue = 0
            ruleList.forEach { rule ->
                if (rule.first in line && rule.second in line && line.indexOf(rule.second) < line.indexOf(rule.first)) isValid = false
            }
            if (!isValid) {
                val sortedList = line.toMutableList()
                var i = 0
                while (i < sortedList.size ) {
                    var j = 0
                    var bolValue = false
                    while (j < sortedList.size) {
                        if (i != j && i < j && Pair(sortedList[j], sortedList[i]) in ruleList) {
                            val num = sortedList[i]
                            sortedList[i] = sortedList[j]
                            sortedList[j] = num
                            bolValue = true
                            break
                        }
                        j++
                    }
                    if (!bolValue) {
                        i++
                    }
                }
                sumValue = sortedList[sortedList.size / 2]
            }
            sumValue
        }.toLong()
    }
}