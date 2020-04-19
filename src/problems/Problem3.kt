package problems

import kotlin.math.sqrt

/*
Largest prime factor

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

private const val UPPER_BOUND = 600_851_475_143

fun problem3(): String {
    var largestPrime = 2
    var num = UPPER_BOUND
    do {
        if (num % largestPrime == 0L) {
            num /= largestPrime
        } else {
            largestPrime++
        }
    } while (num != 1L)
    return "Largest prime is $largestPrime"
}

/**
 * Helper function to detect if a number is a prime one
 * returns true if number is prime
 */
fun Long.isPrime(): Boolean {
    if (this <= 1) return false
    if (this % 2 == 0L) return this == 2L
    for (i in 3 until sqrt(this.toDouble()).toLong() + 1 step 2)
        if (this % i == 0L) return false
    return true
}

/**
 * Another Helper function to detect if a number is a prime one
 * Copied from Python solutions and converted to Kotlin
 * @see <a href="https://stackoverflow.com/a/15285588/4254527">Stackoverflow answer</a>
 */
fun Long.isPrime2(): Boolean {
    if (this == 2L || this == 3L) return true
    if (this < 2 || this % 2 == 0L) return false
    if (this < 9) return true
    if (this % 3 == 0L) return false
    val root = sqrt(this.toDouble()).toLong()
    var f = 5
    while (f <= root) {
        if (this % f == 0L) return false
        if (this % (f + 2) == 0L) return false
        f += 6
    }
    return true
}