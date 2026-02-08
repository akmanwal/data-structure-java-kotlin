import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TestCases {

    @Test
    fun testCoroutines()  = runBlocking {

        learning(1000)

        Assert.assertEquals(10,5+5)

    }
}