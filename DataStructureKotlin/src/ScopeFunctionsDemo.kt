fun main() {

    // let, run , with, apply , also

    var name: String? = null
    name = "Ashish"

    val myList = mutableListOf("Ashish", "Manwal", "Silawar")
    myList.apply {
    }

    myList?.also {
        it.add("Ashish")
    }

    // 1. let
    var person = Person("Ashish", 20)
    person.let {
        println(it)
        it.name = "let: Ashish"
        it.age = 21
    }

    println(person)

    // 2. also
    person.also {
        it.name = "also: Ashish"
        it.age = 22
    }

    println(person)

    // 3. apply
    person.apply {
        name = "apply: Ashish"
        age = 23
    }

    println(person)

    // 4. run
    person.run {
        age = 24
        name = "run: Ashish"
    }

    println(person)

    // 5. with
    with(person) {
        person = Person("Ashish", 20)
        age = 25
        name = "with: Ashish"
    }

    println(person)

    print(factorial(5, 1))

}

tailrec fun factorial(n: Int, acc: Int = 1): Int {
    return if (n == 0) acc else factorial(n - 1, acc * n)
}

data class Person(var name: String, var age: Int)