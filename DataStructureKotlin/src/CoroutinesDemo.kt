import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() {

    // Global Scope -> Dis.Default
    // Coroutine Scope -> Any (customizable)
    // MainScope - Dis.MAIN


    // coroutineScope { ... }
    // This is a suspending function that creates a scope and waits for all children to finish before returning.
    // If any child fails, the scope fails, and the rest are canceled.

    // supervisorScope { ... }
    // Similar to coroutineScope, but a failure in one child does not cancel the others.
    // This is critical for independent tasks.


    // Dispatchers.IO vs. Dispatchers.Default
    // This is where most developers get confused. The difference lies in how they handle thread blocking:

    //Dispatchers.IO: Designed for tasks where the CPU is idle waiting for a response (e.g., waiting for a server).
    // It can scale up to 64 threads (or more) because the threads are mostly "waiting," not "working."

    //Dispatchers.Default: Designed for tasks where the CPU is pegged at 100% (e.g., a complex loop).
    // It limits the number of threads to the number of CPU cores.
    // Adding more threads here wouldn't help—it would actually slow things down due to context switching.

    //Dispatchers.Unconfined
    //This dispatcher is unique because it doesn't confine the coroutine to any specific thread.
    //It starts on the thread that called launch.
    //After the first suspension point, it resumes on whatever thread the suspend function finished on.
    //Warning: It can be unpredictable. It’s mostly used for unit tests or specific edge cases where thread overhead must be zero.

    runBlocking {
        println("Hello, World!")
        val job = launch {
            //val data = performTask()
            delay(1000L)
            //println(data)
            println("World!")
        }

        job.join()

        println("Hello, Coroutines!")
    }

    /* runBlocking is a coroutine builder
    * It is a coroutine builder that blocks the current thread until every coroutine inside its block is finished.
    * Unlike launch or async (which are non-blocking),
    * runBlocking tells the thread: "Stop right here. Do not execute the next line of code until I am completely done."
    * it simply hijacks the current thread and refuses to let go until its work is finished.
    * If you call runBlocking while on the Main Thread, it runs on the Main Thread and blocks it.
    * If you call it on an IO Thread, it blocks that specific IO Thread.
    * It is used to test suspending functions in test cases
    */

    /** From YouTube
     * Main thread -> Small operations, UI interaction, Button click, Mathematical operations
     * Background thread -> Long operations, file download, Network operation, Image loading, Database queries
     * Background thread 1 -> File upload, network operation, database query
     * Light-weight threads, Like threads, coroutines can run in parallel, wait for each other, and communicate with each other
     * Coroutine != thread
     * Coroutines are very cheap-almost free, create thousands of them without any memory issue
     */

    // Main function executes on main thread
    // Unlike threads, for coroutines the application by default does not wait it to finish execution
    runBlocking { // Main thread
        println("Main work started")
        println(Thread.currentThread().name)
        // child coroutine on background thread
        // fire and forget
        val job = launch {  // create a coroutine. Thread: Main-> inherit the thread of parent runBlocking
            println("Work started.")
            // suspend function delay(): suspend coroutine for 1 sec
            //delay(1000) // does not block the thread unlike thread.sleep(), thread is free for 1 sec T1
            println(Thread.currentThread().name) // may be T1 or T2 or any other
            println("Work finished.")
            //learning(2000)
        }

        // control the coroutine
        // using job-> wait to complete the coroutine and then next line execute
        job.join()

        //job.cancel()

        // Block the main thread and wait for coroutine to finish (practically not a right a way to wait)
        // creates a coroutines using runBlocking
        //runBlocking { delay(1000) } // same as Thread.sleep(1000)
        delay(2000)

        println("Main work finished")
        // above both thread running in parallel

        // create coroutine at local scope
        // having scope same as screen -> local scope
        // never block the thread
        launch {

        }
        // create coroutine at global(app) level
        // application level
        // Highly discouraged
        GlobalScope.launch {
            // launch ->
        }

        // same as launch but Deferred is subclass of Job class
        // interface Deferred<out T> : sunclass of Job (interface)
        // never block the thread
        val jobDeferred: Deferred<String> = async {
            "ashish"
        }
        //jobDeferred.join() // not return value but wait for coroutine to complete
        // jobDeferred.cancel()
        print(jobDeferred.await()) // await() to get result
    }


}

suspend fun learning(time: Long) {
    delay(time)
}