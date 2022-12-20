package days

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6Test {
    val day6 = Day6()

    @Test
    fun checkIfSequenceHasUniqueCharacters() {
        assertTrue("ABCD".areAllCharactersUnique())
        assertTrue("fdge".areAllCharactersUnique())
        assertFalse("fdfe".areAllCharactersUnique())
    }

    @Test
    fun getIndexOfFinishedSequence() {
        assertEquals(7, day6.getIndexOfFinishedSequence("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5, day6.getIndexOfFinishedSequence("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, day6.getIndexOfFinishedSequence("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, day6.getIndexOfFinishedSequence("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, day6.getIndexOfFinishedSequence("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}