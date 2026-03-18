package javademo.leetcode

fun main() {

    val array = arrayOf(0, 18, 15, 17, 20)
    array.sort()
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