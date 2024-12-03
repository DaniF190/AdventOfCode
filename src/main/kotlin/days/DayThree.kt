package org.example.days

object DayThree {
    fun part1(input: String): Int {
        return "mul\\([0-9]+,[0-9]+\\)".toRegex()
            .findAll(input).map { "[0-9]+".toRegex().findAll(it.value).map { value -> value.value.toInt() }.toList() }.toList().sumOf { it[0] * it[1] }
    }

    fun part2(input: String): Int {
        return part1(input.replace("\n", "").replace("(don't.*?do\\(\\))|(don't.+)".toRegex(), ""))
    }
}