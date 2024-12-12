package org.example.years.year2024

import org.example.years.DayI

object Day4 : DayI {
    override fun part1(input: String): Long {
        var sumOfWord = 0
        val trimmedInput = input.lines()
        /*sumOfWord += "XMAS|SAMX".toRegex().findAll(input.replace("\n", "")).count()
        sumOfWord += trimmedInput[0].indices.map { i -> (trimmedInput.indices).map { j -> trimmedInput[j][i] }.joinToString("") }
            .map { it }.sumOf { "XMAS|SAMX".toRegex().findAll(it).count() }
        val diagonals = getDiagonals(trimmedInput)
        sumOfWord += diagonals.sumOf { "XMAS|SAMX".toRegex().findAll(it).count() }*/

        trimmedInput.indices.forEach { i ->
            (0..<trimmedInput[i].length).forEach { j ->
                if (trimmedInput[i][j] == 'X') {
                    listOf(
                        Pair(-1,  -1), Pair(-1, 0), Pair(-1, 1),
                        Pair( 0,  -1),              Pair( 0, 1),
                        Pair( 1,  -1), Pair( 1, 0), Pair( 1, 1)).forEach{
                            sumOfWord += recursiveSearch(trimmedInput, Pair(i,j), it, "XMAS")
                        }
                }
            }
        }

        return sumOfWord.toLong()
    }

    override fun part2(input: String): Long {
        var sumOfWord = 0
        val trimmedInput = input.lines()

        trimmedInput.indices.forEach { i ->
            (0..<trimmedInput[i].length).forEach { j ->
                if (trimmedInput[i][j] == 'A') {
                    var boolNum = 0
                    trimmedInput.getOrNull(i + -1)?.getOrNull(j+ -1)?.also {
                        trimmedInput.getOrNull(i + 1)?.getOrNull(j + 1)?.also {secondIndex ->
                            if ((it + "A" + secondIndex) in listOf("MAS", "SAM")) boolNum++
                        }
                    }
                    trimmedInput.getOrNull(i + 1)?.getOrNull(j+ -1)?.also {
                        trimmedInput.getOrNull(i + -1)?.getOrNull(j + 1)?.also {secondIndex ->
                            if ((it + "A" + secondIndex) in listOf("MAS", "SAM")) boolNum++
                        }
                    }
                    if (boolNum == 2) sumOfWord++
                }
            }
        }

        return sumOfWord.toLong()
    }

    private fun recursiveSearch(input: List<String>, currentIndex: Pair<Int, Int>, directIndex: Pair<Int, Int>, remainingWord: String) : Int {
        if (remainingWord == "") {
            return 1
        }
        input.getOrNull(currentIndex.first)?.getOrNull(currentIndex.second)?.also {
            return if (it == remainingWord[0]) {
                recursiveSearch(input, Pair(currentIndex.first + directIndex.first, currentIndex.second + directIndex.second), directIndex, remainingWord.drop(1))
            } else 0
        } ?: return 0
        return 0
    }

    private fun getDiagonals(grid: List<String>): List<String> {
        val numRows = grid.size
        val numCols = if (grid.isNotEmpty()) grid[0].length else 0
        val diagonals = mutableListOf<String>()

        // Top-left to bottom-right diagonals
        /*for (d in -(numCols - 1) until numRows) {
            val diagonal = mutableListOf<Char>()
            for (row in 0 until numRows) {
                val col = row - d
                if (col in 0 until numCols) {
                    diagonal.add(grid[row][col])
                }
            }
            if (diagonal.isNotEmpty()) diagonals.add(diagonal.joinToString(""))
        }*/
        println(diagonals)

        // Top-right to bottom-left diagonals
        for (d in 0 until (numRows + numCols - 1)) {
            val diagonal = mutableListOf<Char>()
            for (row in 0 until numRows) {
                val col = d - row
                if (col in 0 until numCols) {
                    diagonal.add(grid[row][col])
                }
            }
            if (diagonal.isNotEmpty()) diagonals.add(diagonal.joinToString(""))
        }
        println(diagonals)

        return diagonals
    }
}