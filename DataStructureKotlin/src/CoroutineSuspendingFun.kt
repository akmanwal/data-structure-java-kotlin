import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Sequential, Concurrent, and Lazy execution
 *
 * 1. Sequential Execution:
 * Functions execution are sequential by default
 *
 * 2. Concurrent Execution: (parallel)
 * Achieve concurrent execution by async{}
 *
 * 3. Lazy Coroutine Execution
 * Lazy execute code in coroutine
 */

// 1. In coroutine methods are getting executing in by default sequentially
fun main() = runBlocking {

    println("Main function started: ${Thread.currentThread().name}")

    //val time = measureTimeMillis {
        // 2. using async both functions will run parallel (concurrency)
        // async(start = CoroutineStart.LAZY): Will not execute if we are not using the result
        val msgOne : Deferred<String> = async(start = CoroutineStart.LAZY) {
            getMessageOne()
        }
        val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) {
            getMessageTwo()
        }

        println(msgOne.await() + msgTwo.await())
    //}

    //println("Completed in $time ms")

    println("Main function ends: ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String {
    delay(1000L) // doing some work
    println("Inside message one")
    return "Hello"
}

suspend fun getMessageTwo(): String {
    delay(1000L) // doing some work
    println("Inside message two")
    return "World"
}