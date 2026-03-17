package javademo.collections.arrays

import kotlin.math.max

fun main() {

    val array = intArrayOf(0, 18, 15, 17, 20)
    var largest = 0
    var secondLargest = 0

    for ((index, value) in array.withIndex()) {

        if (value > largest) {
            secondLargest = largest
            largest = value
        }
    }

    println(largest)
    println(secondLargest)
}