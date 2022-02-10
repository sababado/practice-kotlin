package educative

/**
 * Equal subset sum partition

Problem statement:
Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 */
class EqualSubsetSumPartition {
    fun partion(set: Set<Int>): Pair<Set<Int>, Set<Int>>? {
        val setOne = mutableSetOf<Int>()
        val setTwo = mutableSetOf<Int>()

        // initial breakup
        var setOneValue: Int = 0
        var setTwoValue: Int = 0
        for ((index, value) in set.iterator().withIndex()) {
            if (index == 0) {
                setOne.add(value)
                setOneValue = value
            } else {
                setTwo.add(value)
                setTwoValue += value
            }
        }

        // compare difference but only if a whole number

        for (i in 0..setOne.size) {
            val diff = (setOneValue - setTwoValue) / -2.0
            if (diff == 0.0) {
                return Pair(setOne, setTwo)
            }
            if (isWhole(diff)) {
                val iValue = setOne.elementAt(i)
                for (jValue in setTwo.iterator()) {
                    val newIValue = iValue + diff.toInt() // we know it's a whole number by this point.
                    if (newIValue == jValue) {
                        // found the number to swap. Do it and get out of here!
                        setOne.remove(iValue)
                        setOne.add(jValue)

                        setTwo.remove(jValue)
                        setTwo.add(iValue)
                        return Pair(setOne, setTwo)
                    }
                }
            }
            // finished looking through the current broken up sets, need to rebalance
            if (setTwo.size < 2) {
                break
            }
            val element = setTwo.first()
            setOne.add(element)
            setTwo.remove(element)
            setOneValue += element
            setTwoValue -= element
        }
        return null
    }

    internal fun isWhole(value: Double): Boolean {
        return (value - value.toInt()) == 0.0
    }
}