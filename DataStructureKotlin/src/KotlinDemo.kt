class KotlinDemo(val name: String, val age: Int) {

    constructor(id: Int, name: String, age: Int) : this(name, age) {
        println("$id, $name, $age")
    }

    constructor(place: String) : this(place, 1) {
        println(place)
    }

    fun print() {
        println("$name, $age")
    }
}

fun main() {

    KotlinDemo(5, "Ashish", 25)
    KotlinDemo("Ashish", 25).print()
    KotlinDemo("Ashish")

    val name = "Ashish"
    val charArray = name.toCharArray()

    for (i in charArray.indices) {
        when (charArray[i]) {
            'A' -> print("A")
            'B' -> print("B")
            'h' -> print("h")
        }
    }
}

fun muFun() {

}