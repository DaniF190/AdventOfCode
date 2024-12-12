package org.example.years.year2024

import org.example.years.DayI
import kotlin.math.abs

object DayOne : DayI {
    override fun part1(input: String): Long {
        return input.trimIndent().lines().map { line ->
           val (first, second) = line.trim().split(Regex("\\s+")).map { it.toInt() }
            first to second
        }.unzip().let { (first, second) ->
            first.sorted().zip(second.sorted()).sumOf { (first, second) -> abs(second - first) }
        }.toLong()
    }

    override fun part2(input: String): Long {
        return input.trimIndent().lines().map { line ->
            val (first, second) = line.trim().split(Regex("\\s+")).map { it.toInt() }
            first to second
        }.unzip().let { (first, second) ->
            first.sumOf {el -> second.count { it == el } * el }
        }.toLong()
    }
}