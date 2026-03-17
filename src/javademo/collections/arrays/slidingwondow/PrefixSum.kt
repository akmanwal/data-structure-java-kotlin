package javademo.collections.arrays.slidingwondow

fun main() {


    val array = arrayOf(1, 2, 3, 4, 5)

    var sum = 0

    for (i in 0 until array.size) {
        sum += array[i]
        array[i] = sum
    }

    println(array.contentToString())
}