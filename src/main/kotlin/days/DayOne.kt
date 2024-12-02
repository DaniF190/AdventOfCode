package org.example.days

import kotlin.math.abs

object DayOne {
    fun part1(input: String): Int {
        return input.trimIndent().lines().map { line ->
           val (first, second) = line.trim().split(Regex("\\s+")).map { it.toInt() }
            first to second
        }.unzip().let { (first, second) ->
            first.sorted().zip(second.sorted()).sumOf { (first, second) -> abs(second - first) }
        }
    }

    fun part2(input: String): Int {
        return input.trimIndent().lines().map { line ->
            val (first, second) = line.trim().split(Regex("\\s+")).map { it.toInt() }
            first to second
        }.unzip().let { (first, second) ->
            first.sumOf {el -> second.count { it == el } * el }
        }
    }
}