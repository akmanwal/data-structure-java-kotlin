fun main() {

    val name= "Ashish"
    val result = name.addSomething("Manwal")
    println(result)
}

fun DelegatesDemo.addSomething(data : String) : String {
    return this + data
}