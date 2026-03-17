package javademo.leetcode


fun main() {
    val array = lengthOfLongestSubstring("pwwkew")
    println(array.toString())
}

fun lengthOfLongestSubstring(string: String): MutableList<String> {


    val stringArray = mutableListOf<String>()

    for (left in 0 until string.length) {
        var subStr = string[left].toString()

        for (right in (left + 1) until string.length) {

            if (subStr.contains(string[right])) {
                break
            } else {
                subStr = string.substring(left, right + 1)
            }
        }
        stringArray.add(subStr)

        subStr = subStr[0].toString()
    }

    return stringArray
}