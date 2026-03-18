fun main() {

    val testing2 = Testing2("Ashish", 25)
    println(testing2.sum(3,4))
}

open class Testing {

    var name: String? = null

    constructor(name: String) {
        this.name = name
    }
    fun sum(a: Int, b: Int): Int {
        println(name)
        return a + b
    }

    open fun sum1(a: Int, b: Int): Int = a + b

}

class Testing2(name: String) : Testing(name) {

    constructor(name: String, age: Int): this(name) {
        println("$name, $age")
    }

    override fun sum1(a: Int, b: Int): Int {
        return a * b
    }

    companion object {

        fun print() {
        }

        @JvmStatic
        fun main(args: Array<String>) {
            print()
        }
    }
}