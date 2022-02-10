package educative

import org.junit.Test
import kotlin.test.assertEquals
import org.junit.Assert.*


internal class KClosestNumbersTest {

    @Test
    fun findTestError() {
        val c = KClosestNumbers()
        try {
            c.find(arrayOf(1, 2), 3, 5)
        } catch (e: IllegalArgumentException) {
            // good catch.
        }
    }

    @Test
    fun getStartingIndexTest() {
        val c = KClosestNumbers()
        assertEquals(2, c.getStartingIndex(arrayOf(1, 2),  5))
        assertEquals(4, c.getStartingIndex(arrayOf(1, 2, 3, 4, 7, 8),  5))
        assertEquals(0, c.getStartingIndex(arrayOf(1, 2, 3, 4, 7, 8),  -1))
        assertEquals(3, c.getStartingIndex(arrayOf(1, 2, 3, 4, 7, 8),  4))
        assertEquals(5, c.getStartingIndex(arrayOf(1, 2, 3, 4, 7, 8),  8))
        assertEquals(6, c.getStartingIndex(arrayOf(1, 2, 3, 4, 7, 8),  9))
    }

    @Test
    fun findClosest() {
        val c = KClosestNumbers()
        assertArrayEquals(arrayOf(2), c.find(arrayOf(1, 2), 1, 5))
        assertArrayEquals(arrayOf(3, 4), c.find(arrayOf(1, 2, 3, 4, 7, 8), 2, 5))
        assertArrayEquals(arrayOf(3, 6), c.find(arrayOf(1, 2, 3, 6, 7, 8), 2, 5))
        assertArrayEquals(arrayOf(1, 2), c.find(arrayOf(1, 2, 3, 4, 7, 8), 2, -1))
    }
}