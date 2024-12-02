package org.example.utils

object AOCUtils {
    fun getFileContent(dayNumber: Int): String? {
        return this::class.java.classLoader.getResource("day$dayNumber.txt")?.readText()
    }
}