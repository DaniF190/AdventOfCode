package org.example.years.year2024

import org.example.years.DayI

object DayThree : DayI {
    override fun part1(input: String): Long {
        return "mul\\([0-9]+,[0-9]+\\)".toRegex()
            .findAll(input).map { "[0-9]+".toRegex().findAll(it.value).map { value -> value.value.toInt() }.toList() }.toList().sumOf { it[0] * it[1] }.toLong()
    }

    override fun part2(input: String): Long {
        return part1(input.replace("\n", "").replace("(don't.*?do\\(\\))|(don't.+)".toRegex(), ""))
    }
}