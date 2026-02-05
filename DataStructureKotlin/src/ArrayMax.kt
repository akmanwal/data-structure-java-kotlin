fun main() {

    val arr = intArrayOf(10, 2, 50, 20)
    var max = 0

    // find max
    for (i in arr.indices) {
        if (arr[i] > max) max = arr[i]
    }

    println("Max: $max")

    // find min
    var min = arr[0]
    for (i in arr.indices) {
        if (arr[i] < min) min = arr[i]
    }

    println("Min: $min")
}