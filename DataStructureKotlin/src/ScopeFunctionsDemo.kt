fun main() {

    /**
     * There are two main difference between the scope functions
     * 1. The way to refer to the context object-> either this or it
     * 2. The return value -> Either return context object or the lambda result
     */
    // let, run , with, apply , also

    /** Scope function 'with'->
     * Property 1: Refer to context object(receiver = person) by using 'this'
     * Property 2: The return value is the 'lambda result'
     */
    val person = Person()
    val modifiedAge: Int = with(person) {
        name = "Manwal"
        age = 20

        age + 5 // last expression will return
    }

    println("After five years: $modifiedAge")

    /** Scope function 'apply'->
     * Property 1: Refer to context object by using 'this'
     * Property 2: The return value is the 'context object'
     */

    val person1 = Person().apply {
        name = "Jane"
        age = 18
    }
    // for print
    with(person1) {
        println(name)
        println(age)
    }

    person1.also {
        it.name = "Bob"
        println("New Name: ${it.name}")
    }

    /** Scope function 'apply'->
     * Property 1: Refer to context object by using 'it'
     * Property 2: The return value is the 'context object'
     */

    val numbersList = mutableListOf(1, 2, 3, 4, 5)

    val duplicateNumbers = numbersList.also {
        println("First Element: ${it.first()}")
        it.add(6)
        println("After adding: $it")
        it.remove(2)
        println("Removed: $it")
    }
    println(numbersList)
    println(duplicateNumbers)


    /** Scope function 'apply'->
     * Property 1: Refer to context object by using 'it'
     * Property 2: The return value is the 'lambda result'
     * Use let function to avoid NullPointerException
     */

    val name = "Hello"

    val length = name.let {
        println(name)
        println(it.reversed())
        println(it.length)

        it.length // return this statement
    }

    println(length)

    /** Scope function 'apply'->
     * Property 1: Refer to context object by using 'this'
     * Property 2: The return value is the 'lambda result'
     * combination of "let" and "with"
     */

    val person2 = Person()
    val bio = person2.run {
        println(name)
        println(age)
        "we are returning this"
    }
    println(bio)

    /**
     * Summary
     * with: If you want to operate on non-null object
     * let: If you want to just execute lambda expression on a nullable object and avoid NullPointerException
     * run: If you want to operate on a nullable object, execute lambda expression and avoid NullPointerException (with + let)
     * apply: If you want to initialize or configure an object
     * also: If you want to do some additional object configuration or operations
     */
}


class Person {

    var name: String = ""
    var age: Int = 0
}