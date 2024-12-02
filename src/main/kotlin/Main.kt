package org.example

import org.example.days.DayOne
import org.example.days.DayTwo
import org.example.utils.AOCUtils

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    //Day one
    //val src = AOCUtils.getFileContent(1)
    //println(DayOne.part1(src!!))
    //println(DayOne.part2(src))

    //Day Two
    val src = AOCUtils.getFileContent(2)
    println(DayTwo.part1(src!!))
    println(DayTwo.part2(src))
}