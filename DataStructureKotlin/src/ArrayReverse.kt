fun main() {

    val arr = intArrayOf(10,20,5,4,3,100)

    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp

        left++
        right--
    }

    println(arr.contentToString())
}