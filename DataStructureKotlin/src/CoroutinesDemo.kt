import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import java.io.ObjectInputFilter

fun main() {

    // Global Scope -> Dis.Default
    // Coroutine Scope -> Any (customizable)
    // MainScope - Dis.MAIN


    // coroutineScope { ... }
    //This is a suspending function that creates a scope and waits for all children to finish before returning.
    // If any child fails, the scope fails, and the rest are canceled.

    //supervisorScope { ... }
    //Similar to coroutineScope, but a failure in one child does not cancel the others.
    // This is critical for independent tasks.


    //Dispatchers.IO vs. Dispatchers.Default
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

    /*runBlocking {
        println("Hello, World!")
        val job = launch {
            val data = performTask()
            println(data)
        }

        job.join()

        println("Hello, Coroutines!")
    }
*/
    /* runBlocking is a coroutine builder
    * It is a coroutine builder that blocks the current thread until every coroutine inside its block is finished.
    * Unlike launch or async (which are non-blocking),
    * runBlocking tells the thread: "Stop right here. Do not execute the next line of code until I am completely done."
    * it simply hijacks the current thread and refuses to let go until its work is finished.
    * If you call runBlocking while on the Main Thread, it runs on the Main Thread and blocks it.
    * If you call it on an IO Thread, it blocks that specific IO Thread.
    */
}