package problems

import kotlin.system.measureTimeMillis

/*
Multiples of 3 and 5

If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
 */

fun main() {

    val time = measureTimeMillis {
        var sum = 0
        for (i in 1 until 1_000)
            if (i % 3 == 0 || i % 5 == 0) sum += i
        println("Sum: $sum")
    }

    println("Calculated time: $time")

}