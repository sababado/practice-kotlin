package educative

import org.junit.Test
import org.junit.Assert.*

internal class EqualSubsetSumPartitionTest {

    @Test
    fun partionTest() {
        val e = EqualSubsetSumPartition()

        var input = setOf(3, 2, 0, 4, 1)
        var actual: Pair<Set<Int>, Set<Int>>? = e.partion(input)
        assertEquals("3,2", actual!!.first.joinToString(","))
        assertEquals("0,4,1", actual.second.joinToString(","))

        input = setOf(4, 2, 0, 3, 1)
        actual = e.partion(input)
        assertEquals("4,1", actual!!.first.joinToString(","))
        assertEquals("0,3,2", actual.second.joinToString(","))

        input = setOf(1, 5, 4)
        actual = e.partion(input)
        assertEquals("5", actual!!.first.joinToString(","))
        assertEquals("4,1", actual.second.joinToString(","))

        input = setOf(1, 2)
        actual = e.partion(input)
        assertEquals(actual, null)

        input = setOf(1)
        actual = e.partion(input)
        assertEquals(actual, null)
    }

    @Test
    fun isWholeTest() {
        assert(EqualSubsetSumPartition().isWhole(-0.0))
        assert(EqualSubsetSumPartition().isWhole(1.0))
        assert(EqualSubsetSumPartition().isWhole(2.0))
        assert(!EqualSubsetSumPartition().isWhole(2.5))

    }
}