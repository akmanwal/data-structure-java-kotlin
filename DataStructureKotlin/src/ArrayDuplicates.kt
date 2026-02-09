fun main() {

    val arr = intArrayOf(1, 1, 2, 2, 2, 3, 4, 5)
    removeDup(arr)

    val arr1 = intArrayOf(5,5,5,1,1,4,3,2,1,2,5)
    removeDuplicates(arr1)
}

fun removeDup(arr: IntArray) {

    var index = 1
    for (i in 1 until arr.size) {
        if (arr[i] != arr[i - 1]) {
            arr[index++] = arr[i]
        }
    }

    for (j in 0 until index) {
        print(arr[j])
    }
}

fun removeDuplicates(arr: IntArray) {

    val mySet = LinkedHashSet<Int>()

    for (i in arr.indices) {
        mySet.add(arr[i])
    }

    val newArr = IntArray(mySet.size)

    var index = 0

    for(elements in mySet) {
        newArr[index++] = elements
    }

    println(newArr.contentToString())
}