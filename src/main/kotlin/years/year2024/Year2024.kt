package org.example.years.year2024

import org.example.utils.AOCUtils
import org.example.years.DayI
import org.example.years.YearI

class Year2024 (
    private val dayList: List<DayI> = listOf(DayOne, DayTwo, DayThree, Day4, Day5),
) : YearI {
    override fun runYear() {
        dayList.forEach { day ->
            println("********************************")
            println("*             Day " + (dayList.indexOf(day) + 1) + "            *" )
            println("********************************")
            val src = AOCUtils.getFileContent(2024, dayList.indexOf(day) + 1)
            AOCUtils.timeMeasureAndPrint(day, src!!)
        }
    }
}