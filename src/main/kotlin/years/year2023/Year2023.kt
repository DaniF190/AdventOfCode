package org.example.years.year2023

import org.example.utils.AOCUtils
import org.example.years.DayI
import org.example.years.YearI
class Year2023 (
    private val dayList: List<DayI> = listOf(DayOne),
) : YearI {
    override fun runYear() {
        dayList.forEach { day ->
            println("********************************")
            println("*             Day " + (dayList.indexOf(day) + 1) + "            *" )
            println("********************************")
            val src = AOCUtils.getFileContent(2023, dayList.indexOf(day) + 1)
            AOCUtils.timeMeasureAndPrint(day, src!!)
        }
    }
}