package day2

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

    }
}