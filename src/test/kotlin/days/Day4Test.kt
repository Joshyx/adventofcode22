package days

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {
    private val dayFour = Day4()
    private val testInput = "2-4,6-8\n" +
            "2-3,4-5\n" +
            "5-7,7-9\n" +
            "2-8,3-7\n" +
            "6-6,4-6\n" +
            "2-6,4-8"

    @Test
    fun testDoRangesFullyOverlap() {
        assertEquals(true, dayFour.doRangesFullyOverlap(3..4 to 2..9))
        assertEquals(true, dayFour.doRangesFullyOverlap(5..17 to 8..13))
        assertEquals(true, dayFour.doRangesFullyOverlap(6..6 to 4..6))
        assertEquals(false, dayFour.doRangesFullyOverlap(3..12 to 2..9))
    }

    @Test
    fun testDoRangesOverlap() {
        assertEquals(true, dayFour.doRangesOverlap(3..4 to 2..9))
        assertEquals(true, dayFour.doRangesOverlap(3..12 to 2..9))
        assertEquals(false, dayFour.doRangesOverlap(3..6 to 7..9))
    }

    @Test
    fun testGetRangesFromString() {
        assertEquals(3..4 to 2..9, dayFour.getRangesFromString("3-4,2-9"))
        assertEquals(39..68 to 55..70, dayFour.getRangesFromString("39-68,55-70"))
    }

    @Test
    fun testGetAmountOfFullOverlaps() {
        assertEquals(2, dayFour.getAmountOfFullOverlaps(testInput))
    }

    @Test
    fun testGetAmountOfOverlaps() {
        assertEquals(4, dayFour.getAmountOfOverlaps(testInput))
    }
}