fun main() {

    val name = "Ashish"
    println(checkRev(name))
}

fun checkRev(string: String): String {
    var result = ""

    for (i in 0 until string.length) {
        result = string[i] + result
    }

    return result
}