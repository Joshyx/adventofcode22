package day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Day1Test {
    private val dayOne = Day1()
    private val testInput = "1000\n" +
            "2000\n" +
            "3000\n" +
            "\n" +
            "4000\n" +
            "\n" +
            "5000\n" +
            "6000\n" +
            "\n" +
            "7000\n" +
            "8000\n" +
            "9000\n" +
            "\n" +
            "10000\n"

    @Test
    fun testGetAllElves() {

        assertContentEquals(listOf(6000, 4000, 11000, 24000, 10000), dayOne.getAllElves(testInput))
    }

    @Test
    fun testGetRichestElf() {
        Assertions.assertEquals(24000, dayOne.getRichestElf(testInput))
    }

    @Test
    fun testGetTopThreeElves() {
        Assertions.assertEquals(45000, dayOne.getTopThreeElves(testInput))
    }
}