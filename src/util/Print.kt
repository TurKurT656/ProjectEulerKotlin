package util

import kotlin.system.measureTimeMillis

private const val LENGTH = 60

fun solve(problemSolve: () -> String) {
    println(charAppender(LENGTH))
    val problemName = problemSolve.toString()
        .removePrefix("fun ")
        .removeSuffix("(): kotlin.String")
        .capitalize()
    println(problemName.lineGenerator(LENGTH))
    println("".lineGenerator(LENGTH))
    val time = measureTimeMillis {
        val solution = problemSolve()
        println(solution.lineGenerator(LENGTH))
    }
    val timeResult = "Calculated time: $time in milli seconds"
    println(timeResult.lineGenerator(LENGTH))
    println(charAppender(LENGTH))
}

fun String.lineGenerator(length: Int, char: Char = ':'): String {
    val twice = "$char$char"
    val prefix = "$twice "
    val suffix = " $twice"
    return "$prefix$this${charAppender(length - prefix.length - suffix.length - this.length, ' ')}$suffix"
}

fun charAppender(length: Int, char: Char = ':') =
    StringBuilder().apply {
        for (i in 0..length) append(char)
    }.toString()