package days

import days.Day2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {
    private val day2 = Day2()
    private val testInput = "A Y\n" +
            "B X\n" +
            "C Z"

    @Test
    fun testGetScoreForRound() {
        assertEquals(6, day2.getScoreForRound("C Z"))
    }
    @Test
    fun testGetScoreForShape() {
        assertEquals(2, day2.getScoreForShape("A Y"))
    }
    @Test
    fun testGetScoreForOutcome() {
        assertEquals(3, day2.getScoreForOutcome("A X"))
    }

    @Test
    fun testGetTotalScore() {
        assertEquals(15, day2.getTotalScore(testInput))
    }

    @Test
    fun testChooseShape() {
        assertEquals("X", day2.chooseShape("A Y"))
        assertEquals("X", day2.chooseShape("B X"))
        assertEquals("X", day2.chooseShape("C Z"))
    }
    @Test
    fun testGetScoreForSecondRound() {
        assertEquals(4, day2.getScoreForSecondRound("A Y"))
        assertEquals(1, day2.getScoreForSecondRound("B X"))
        assertEquals(7, day2.getScoreForSecondRound("C Z"))
    }

    @Test
    fun testGetSecondTotalScore() {
        assertEquals(12, day2.getSecondTotalScore(testInput))
    }
}