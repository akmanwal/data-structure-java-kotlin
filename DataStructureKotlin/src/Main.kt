//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val map1 = mutableMapOf("Apple" to 1, "Orange" to 2, "Guava" to 3, "Grapes" to 4)
    val map2 = mutableMapOf("Ball" to 1, "Table" to 2, "Guava" to 3, "Grapes" to 4)

    val result = map1.toMutableMap()

    for ((key, value) in map2) {
        result[key] = (result[key] ?: 0) + value
    }

    print(result)

    reverser("Ashish")
}


private fun reverser(str: String) {
    var result = ""

    for (i in str.length - 1 downTo 0) {
        result += str[i]
    }

    print(result)

}