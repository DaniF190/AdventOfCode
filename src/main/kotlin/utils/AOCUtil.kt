package org.example.utils

import org.example.years.DayI
import kotlin.time.measureTimedValue

object AOCUtils {
    fun getFileContent(yearNumber: Int, dayNumber: Int): String? {
        return this::class.java.classLoader.getResource("$yearNumber/day$dayNumber.txt")?.readText()
    }
    fun timeMeasureAndPrint(day: DayI, src: String) {
        println("Part 1")
        val (value, timeTaken) = measureTimedValue {
            day.part1(src)
        }
        println(value)
        println(timeTaken)

        println("Part 2")
        val (value2, timeTaken2) = measureTimedValue {
            day.part2(src)
        }
        println(value2)
        println(timeTaken2)
    }
}