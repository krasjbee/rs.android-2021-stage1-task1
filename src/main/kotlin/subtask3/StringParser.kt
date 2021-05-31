package subtask3

class StringParser {
    //Map of special symbols
    private val specialSymbols = mapOf(
        '<' to '>',
        '[' to ']',
        '(' to ')'
    )

    fun getResult(inputString: String): Array<String> {

        val outputArray = mutableListOf<String>()
        var endOfString: Char?

        for ((index, char) in inputString.withIndex()) {
            if (specialSymbols.contains(char)) {
                var counter = 0
                endOfString = specialSymbols[char]

                for (subIndex in index..inputString.lastIndex) {
                    //counting number of opening special symbols
                    if (inputString[subIndex] == char) {
                        counter++
                    }
                    //counting number of closing special symbols
                    if (inputString[subIndex] == endOfString) {
                        counter--
                        if (counter == 0) {
                            outputArray.add(inputString.substring(index + 1 until subIndex))
                            break
                        }
                    }

                }
            }
        }
        return outputArray.toTypedArray()
    }

}