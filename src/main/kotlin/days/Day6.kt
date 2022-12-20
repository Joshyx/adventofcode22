package days

import Day
import java.lang.Exception

class Day6 : Day {

    fun getIndexOfFinishedSequence(sequence: String): Int {
        for(index in 3 until sequence.length) {

            if("${sequence[index]}${sequence[index - 1]}${sequence[index - 2]}${sequence[index - 3]}".areAllCharactersUnique()) {
                return index + 1
            }
        }
        throw Exception("No Sequence found")
    }

    override fun getResult(): String {
        return getIndexOfFinishedSequence(getInput()).toString()
    }

    override fun getSecondResult(): String {
        TODO("Not yet implemented")
    }

    override fun getDay(): Int {
        return 6
    }
}