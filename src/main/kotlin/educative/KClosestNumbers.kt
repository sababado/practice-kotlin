package educative

/**
 * Find ‘k’ closest numbers

Problem Statement: Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
 *
 */
class KClosestNumbers {
    /**
     *
     * @param sortedArray Sorted number array
     * @param k Number of close numbers to find
     * @param x Number to find values near.
     *
     * @throws IllegalArgumentException if [k] > [sortedArray].size
     * @return sorted numbers found.
     */
    fun find(sortedArray: Array<Int>, k: Int, x: Int): Array<Int> {
        // bounds check
        if (k > sortedArray.size) {
            throw IllegalArgumentException("k must be less than or equal to the array size.")
        }
        // solution
        // getStartingIndex
        val startingIndex: Int = getStartingIndex(sortedArray, x)

        var indexRight = 0
        var indexLeft = 1
//        var goRight = true // true for right, false for left.

        // get the next or previous number, whichever is available
        fun getNext(goRight: Boolean): Int {
//            println("indexRight:$indexRight | indexLeft:$indexLeft | goRight:$goRight")
            return if (goRight) {
                if (startingIndex + indexRight < sortedArray.size) {
                    sortedArray[startingIndex + indexRight++]
                } else {
                    sortedArray[startingIndex - indexLeft++]
                }
            } else { // go left
                if (startingIndex - indexLeft >= 0) {
                    sortedArray[startingIndex - indexLeft++]
                } else {
                    sortedArray[startingIndex + indexRight++]
                }
            }
        }
        // find t values
        // get the next or previous number, whichever is available
        var tRight: Int? = null
        var tLeft: Int? = null
        val answerList: MutableList<Int> = mutableListOf()

        for (i in 0..k) {
            // get two values to compare
            if (tRight == null) {
                tRight = getNext(true)
            } else {
                tLeft = getNext(false)
            }
//            println("t1:$tRight | t2:$tLeft")
            if (tLeft != null) { // t1 always exists here
                // compare
                if (kotlin.math.abs(x - tLeft) <= kotlin.math.abs(x - tRight)) {
                    answerList.add(tLeft)
                    tLeft = null
                } else {
                    answerList.add(tRight) // better to prepend
                    tRight = null
                }
            }
        }

        answerList.sort()
//        println(answerList.joinToString(","))
        return answerList.toTypedArray()
    }

    /**
     * if starting index exists, start searching right of index
     * if starting index doesn't exist, start searching right from start, sequentially (binary more efficient)
     * and return the index of the first value greater than x
     *
     * @param sortedArray Sorted number array
     * @param x Number to find values near.
     */
    internal fun getStartingIndex(sortedArray: Array<Int>, x: Int): Int {
        val startingIndex: Int = sortedArray.indexOf(x)
        if (startingIndex == -1) {
            for (index in sortedArray.indices) {
                if (sortedArray[index] > x) {
                    return index
                }
            }
            // not found, greater than all items in list
            return sortedArray.size
        }
        return startingIndex
    }
}