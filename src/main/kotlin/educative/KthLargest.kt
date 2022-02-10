package educative

import java.util.*

/**
 * Find the kth largest element in a number stream

Problem Statement: Design a class to efficiently find the Kth largest element in a stream of numbers. The class should have the following two things:​

1. The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
2. The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 *
 * @param arr
 * @param k Should be 1 <= k <= arr.size
 */
class KthLargest(arr: Array<Int>, k: Int) {
    // Convert array to a sorted mutable list.
    private val list: SortedSet<Int>
    private val k: Int = k

    init {
        arr.sort()
        list = arr.toSortedSet()
    }

    /**
     * Stores the number here and returns the Kth largest number stored.
     * @param num Number to add
     * @return Kth largest element
     */
    fun add(num: Int): Int {
        list.add(num)
        // find Kth largest number
        return kthLargest()
    }

    /**
     * Find [k]th largest element in class [list].
     * @return Kth largest element.
     * @throws IndexOutOfBoundsException if K is greater than the array length.
     */
    internal fun kthLargest(): Int {
        if (k > list.size) {
            throw IndexOutOfBoundsException("K cannot be larger than the array size")
        }
        return list.elementAt(list.size - k)
    }
}