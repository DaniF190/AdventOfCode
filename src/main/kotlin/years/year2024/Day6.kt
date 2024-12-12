package org.example.years.year2024

import org.example.years.DayI

object Day6 : DayI {
    override fun part1(input: String): Long {

        return getRoad(input).keys.count().toLong()
    }

    override fun part2(input: String): Long {

        val goodPath = getRoad(input)

        val array = input.trim().lines()
        val curPos = (input.indexOf("^") / array[0].length).let { Pair(it, array[it].indexOf("^")) }

        var sum = 0

        goodPath.forEach { place ->
            val mutableList = array.toMutableList()
            if (place.key != curPos) {
                val row = StringBuilder(mutableList[place.key.first])
                row.setCharAt(place.key.second, '#')
                mutableList[place.key.first] = row.toString()
                if (part1(mutableList.joinToString("\n")) == 0L) {
                    sum++
                }
            }
        }

        return sum.toLong()
    }

    private fun getRoad (input: String):  MutableMap<Pair<Int, Int>, Int> {

        val directionMap = mapOf(1 to Pair(-1, 0), 2 to Pair(0, 1), 3 to Pair(1, 0), 4 to Pair(0, -1))
        var directNum = 1

        val array = input.trim().lines()
        var curPos = (input.indexOf("^") / array[0].length).let { Pair(it, array[it].indexOf("^")) }
        val visitedPairs = mutableMapOf<Pair<Int, Int>, Int>()

        while (array.getOrNull(curPos.first + directionMap[directNum]!!.first)?.getOrNull(curPos.second + directionMap[directNum]!!.second) != null) {

            val nextStep = array[curPos.first + directionMap[directNum]!!.first][curPos.second + directionMap[directNum]!!.second]
            //Check if the movement is in loop
            if (nextStep != '#' && curPos in visitedPairs.keys && visitedPairs[curPos]!! > 2) {
                return mutableMapOf()
            }
            //current step
            if (curPos !in visitedPairs.keys) {
                visitedPairs[curPos] = 0
            } else {
                visitedPairs[curPos] = visitedPairs[curPos]!! + 1
            }

            if (nextStep != '#') {
                curPos = Pair(curPos.first + directionMap[directNum]!!.first, curPos.second + directionMap[directNum]!!.second)
            } else {
                directNum++
                if (directNum == 5) directNum = 1
            }

            if (array.getOrNull(curPos.first + directionMap[directNum]!!.first)?.getOrNull(curPos.second + directionMap[directNum]!!.second) == null) {
                if (curPos !in visitedPairs.keys) {
                    visitedPairs[curPos] = 0
                } else {
                    visitedPairs[curPos] = visitedPairs[curPos]!! + 1
                }
            }
        }

        return visitedPairs
    }
}