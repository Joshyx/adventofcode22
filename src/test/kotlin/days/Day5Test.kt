package days

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class Day5Test {
    private val dayFive = Day5()
    private val testInput = "    [D]    \n" +
            "[N] [C]    \n" +
            "[Z] [M] [P]\n" +
            " 1   2   3 \n" +
            "\n" +
            "move 1 from 2 to 1\n" +
            "move 3 from 1 to 3\n" +
            "move 2 from 2 to 1\n" +
            "move 1 from 1 to 2"

    @Test
    fun testGetResultOfRearrangement() {
        assertEquals("CMZ", dayFive.getResultOfRearrangement(testInput))
    }

    @Test
    fun testDoInstructions() {
        assertEquals(
            mapOf(1 to listOf('C'), 2 to listOf('M'), 3 to listOf('Z', 'N', 'D', 'P')),
            dayFive.doInstructions(
                mutableMapOf(1 to mutableListOf('N', 'Z'), 2 to mutableListOf('D', 'C', 'M'), 3 to mutableListOf('P')),
                listOf(listOf(1, 2, 1), listOf(3, 1, 3), listOf(2, 2, 1), listOf(1, 1, 2))
            )
        )
    }

    @Test
    fun testDoInstructionsForNewCrane() {
        assertEquals(
            mapOf(1 to listOf('M'), 2 to listOf('C'), 3 to listOf('D', 'N', 'Z', 'P')),
            dayFive.doInstructionsForNewCrane(
                mutableMapOf(1 to mutableListOf('N', 'Z'), 2 to mutableListOf('D', 'C', 'M'), 3 to mutableListOf('P')),
                listOf(listOf(1, 2, 1), listOf(3, 1, 3), listOf(2, 2, 1), listOf(1, 1, 2))
            )
        )
    }

    @Test
    fun testMapInstructions() {
        assertContentEquals(
            listOf(listOf(1, 2, 1), listOf(3, 1, 3), listOf(2, 2, 1), listOf(1, 1, 2)),
            dayFive.mapInstructions("move 1 from 2 to 1\n" +
                    "move 3 from 1 to 3\n" +
                    "move 2 from 2 to 1\n" +
                    "move 1 from 1 to 2")
        )
    }

    @Test
    fun testMapStacks() {
        assertEquals(
            mapOf(1 to listOf('N', 'Z'), 2 to listOf('D', 'C', 'M'), 3 to listOf('P')), dayFive.mapStacks(
                "    [D]    \n" +
                        "[N] [C]    \n" +
                        "[Z] [M] [P]\n" +
                        " 1   2   3 "
            )
        )
    }
}