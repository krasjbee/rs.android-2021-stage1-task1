package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        //critical case of empty input array
        if (sadArray.isEmpty()) return sadArray
        //convert sad array to mutable list
        val mutableSadArray = sadArray.toMutableList()
        var i = 1
        //flag which indicates if any elements were removed (indicates if array is happy)
        var isHappy = true
        while (i < mutableSadArray.size - 1) {
            if (isElementBad(
                    mutableSadArray[i],
                    mutableSadArray[i - 1],
                    mutableSadArray[i + 1]
                )
            ) {
                mutableSadArray.removeAt(i)
                isHappy = false
            } else {
                i += 1
            }
        }
        //return happy array if array is happy
        if (isHappy) return mutableSadArray.toIntArray()
        //recursive call of this function to if array is happy indeed
        return convertToHappy(mutableSadArray.toIntArray())
    }

    private fun isElementBad(element: Int, previousElement: Int, nextElement: Int): Boolean =
        element > (previousElement + nextElement)

}
