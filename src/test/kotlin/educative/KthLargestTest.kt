package educative

import org.junit.Test
import kotlin.test.assertEquals

internal class KthLargestTest {

    @Test
    fun addTest() {
        val c = KthLargest(arrayOf(4, 2, 5, 6, 3, 1, 1), 1)
        var expected = 6
        assertEquals(expected, c.add(3))

        expected = 7
        assertEquals(expected, c.add(7))

        expected = 9
        assertEquals(expected, c.add(9))
    }

    @Test
    fun kthLargestTest() {
        var c = KthLargest(arrayOf(4, 2, 5, 6, 3, 1, 1), 1)
        var expected = 6
        assertEquals(expected, c.kthLargest())

        c = KthLargest(arrayOf(4, 2, 5, 6, 3, 1, 1), 3)
        expected = 4
        assertEquals(expected, c.kthLargest())

        c = KthLargest(arrayOf(4, 2, 5, 6, 3, 1, 1), 9)
        try {
            c.kthLargest()
        } catch (e: IndexOutOfBoundsException) {
            // good catch
        }
    }
}