package javademo.leetcode

fun main() {


    val name = "Ashish"

    for (i in 0 until name.length) {
        val length = 0
        checkPalindrome(name, i, i, length)
        checkPalindrome(name, i, i + 1, length)
    }
}

fun checkPalindrome(s: String, left: Int, right: Int, maxLength: Int) {

    var L = left
    var R = right

    var length = maxLength

    while (L >= 0 && R < s.length && s[L] == s[R]) {
        println(s.substring(L, R + 1))

        length = s.substring(L, R + 1).length
        L--
        R++
    }

}