fun main() {

    val factorial = factorial(5)
    println(factorial)
}

tailrec fun factorial(n: Int, acc: Int = 1): Int {
    return if (n == 0) acc else factorial(n - 1, acc * n)
}