package problems

import kotlin.system.measureTimeMillis

/*
Even Fibonacci numbers

Each new term in the Fibonacci sequence is generated by adding the previous two terms.
By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million,
find the sum of the even-valued terms.
 */

fun main() {

    val time = measureTimeMillis {
        var sum = 0
        var i = 0
        while (true) {
            val fib = fibonacci(i)
            if (fib > 4_000_000) break
            if (fib % 2 == 0) sum += fib
            i++
        }
        println("Sum: $sum")
    }

    println("Calculated time: $time")

}

/**
 * Fibonacci generator
 * [n] is nth desired Fibonacci number
 * The value of [b] is the previous value, and the value of [a] is the one before that
 */
tailrec fun fibonacci(n: Int, a: Int = 1, b: Int = 2): Int =
    when (n) {
        0 -> a
        1 -> b
        else -> fibonacci(n - 1, b, a + b)
    }