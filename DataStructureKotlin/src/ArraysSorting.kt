fun main() {

    val arr = intArrayOf(1, 2, 3, 4, 5)
    sorting(arr)
    println(arr.contentToString())
}

private fun sorting(arr: IntArray) {

    /*for (i in arr.indices) {
        for (j in i + 1 until arr.size - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }*/

    for (i in 0 until arr.size) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }

}