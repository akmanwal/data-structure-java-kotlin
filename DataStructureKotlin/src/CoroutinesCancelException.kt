import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

/**
 * Reasons to cancel coroutines
 * 1. No need of result
 * 2. it's taking too long
 *
 * Two ways to make coroutine cooperative (cancellable)->
 * 1. Only those suspending function that belongs to kotlinx.coroutines package will make coroutine cooperative
 * delay(), yield(), withContext(), withTimeout() etc. are the suspending functions that belongs to kotlinx.coroutines package
 * these functions always throw CancellationException
 * We can catch the exception using try catch
 *
 * 2. Explicitly check for the cancellation status within the coroutine
 * - CoroutineScope.isActive boolean flag
 * There is nothing like this in Threads
 *
 * Handling Exceptions:
 * 1. You can't execute a suspending function from the finally block because the coroutine running this code is already canceled.
 * 2. If you want to execute a suspending function from a finally block the wrap the code within withContext(NonCancellable) function.
 *
 * You can print your own cancellation message using
 * job.cancel(CancellationException("My crash message"))
 *
 * Timeouts:
 * 1. withTimeout()
 * 2. withTimeoutOrNull()
 * Similar to launch and async functions these both are coroutine builders.
 */

suspend fun main() {

    //cooperativeCoroutine()
    timeOutTest()
}

suspend fun cooperativeCoroutine() {

    runBlocking {
        // needs a scope to run
        val job = launch(Dispatchers.Default) {
            try {
                for (i in 1..500) {
                    // 1. Using suspend fun
                    //Thread.sleep(1000) // will not make it cooperative
                    //delay(50) // this fun is cancellable and cooperative
                    yield() // is cancellable, it doesnt not delay coroutine

                    // 2. Using isActive
                    /*if (!isActive){
                    //break
                    return@launch
                }*/
                    println("job: I'm sleeping $i ...")
                }
            } catch (e: CancellationException) {
                println("Exception: caught successfully ${e.message}")
            } finally {
                //delay(1000L) // again throw the CancellationException so next line will not execute
                withContext(NonCancellable) {
                    delay(1000L)
                    println("Closing in finally")
                }
            }
        }

        delay(10)
        // If the coroutine is cooperative then cancel it
        //job.cancel()
        job.cancel(CancellationException("My own crash message"))
        // Waits for the coroutine to finish
        job.join()

        //println(Thread.currentThread().name)

        // If the coroutine is cooperative then cancel it else, if it's not cooperative
        // then wait for the coroutine to finish
        //job.cancelAndJoin()
    }
}

suspend fun timeOutTest() {

    println("Main program started: ${Thread.currentThread().name}")

    // withTimeout(2000): It will throw TimeoutCancellationException after 2 seconds because the coroutine is not completed
    /*withTimeout(2000) {
        try {
            for (i in 1..1000) {
                println("I'm sleeping $i ...")
                delay(1000L)
            }
        } catch (e: TimeoutCancellationException) { // Subclass of CancellationException
            println("TimeoutCancellationException caught")
        } finally {
            println("TimeoutCancellationException caught in finally")
        }
    }*/

    // withTimeoutOrNull: will not throw exception
    // It will provide lambda result
    val result = withTimeoutOrNull(2000) {
        for (i in 1..100) {
            println("I'm sleeping $i ...")
            delay(10L)
        }
        "I am done"
    }

    // If coroutine finished withing time then lambda result will be returned.
    // Otherwise, lambda result will be null
    println("Result is $result")
    println("Main program ends: ${Thread.currentThread().name}")

}