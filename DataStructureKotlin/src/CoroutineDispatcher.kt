import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    checking()
}

fun checking() = runBlocking {

    /**1. Default
     * 2. Unconfined
     * 3. Main
     * 4. IO
     */

    // Without parameter: CONFINED [CONFINED Dispatcher] .../
    launch { // context from parent-> same thread as parent
        println("C1 before ${Thread.currentThread().name}") // Thread: Main
        delay(1000L)
        println("C1 after ${Thread.currentThread().name}") // Thread: Main

        // both on main because no dispatcher is there
    }

    // With parameter: Dispatchers.Default [Similar to GlobalScope.launch{}]
    launch(Dispatchers.Default) {
        println("C2 ${Thread.currentThread().name}") // T1: Background thread : DefaultDispatcher-worker-1
        delay(1000)
        // This can change the thread
        println("C2 ${Thread.currentThread().name}") // Background Thread: T1 or can be another
    }

    // With parameter: Dispatchers.Unconfined [UNCONFINED Dispatcher]
    // This coroutine start coroutine on current thread that is MAIN because it inherit it from parent runBlocking
    launch(Dispatchers.Unconfined) {
        println("C3 before delay: ${Thread.currentThread().name}") // Main
        delay(1000)
        // can continue on any thread after delay()
        println("C3 after delay: ${Thread.currentThread().name}") // kotlinx.coroutines.DefaultExecutor-> from thread pool

        // coroutineContext: part on immediate parent
        // it's passing the context of runBlocking here
        launch(coroutineContext) { // Behaves like CONFINED
            println("C4 before ${Thread.currentThread().name}") // Thread: T1
            delay(1000L)
            println("C4 after ${Thread.currentThread().name}") // Thread: T1

            // both on main because no dispatcher is there
        }
    }

}