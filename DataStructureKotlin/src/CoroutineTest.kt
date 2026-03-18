import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {

    val testingCoroutines = CoroutineTest()
    testingCoroutines.startTesting()
}

class CoroutineTest {

    val supervisor = SupervisorJob()
    val coroutineScope = CoroutineScope(Dispatchers.IO + supervisor)
    suspend fun startTesting() {

        val job = coroutineScope.launch {
            for (i in 1..5) {
                println("Inside job1 $i")
                delay(1000L)
                //throw Exception("Exception1")
            }
        }

        val job2 = coroutineScope.launch {
            for (i in 1..5) {
                println("Inside job2 $i")
                delay(1000L)
                //throw Exception("Exception2")
            }
        }

        job.join()
        job2.join()

        /*println("Before cancel 1")
        delay(3000L)
        job.cancel()
        println("Before join 1")
        job.join()

        println("After after 1")*/

    }

}
