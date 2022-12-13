package days

import days.Day3
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Day3Test {
	private val day3 = Day3()
	private val testInput = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
			"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
			"PmmdzqPrVvPwwTWBwg\n" +
			"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
			"ttgJtRGJQctTZtZT\n" +
			"CrZsJsPPZsGzwwsLwLmpwMDw"

	@Test
	fun testGetCompartments() {
		assertContentEquals(arrayOf("vJrwpWtwJgWr", "hcsFMMfFFhFp"), day3.getCompartments("vJrwpWtwJgWrhcsFMMfFFhFp"))
		assertContentEquals(
			arrayOf("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"),
			day3.getCompartments("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
		)
	}

	@Test
	fun testGetPriority() {
		assertEquals(1, day3.getPriority('a'))
		assertEquals(52, day3.getPriority('Z'))
		assertEquals(16, day3.getPriority('p'))
		assertEquals(38, day3.getPriority('L'))
	}

	@Test
	fun testGetCommonItemType() {
		assertEquals('p', day3.getCommonItemType("vJrwpWtwJgWrhcsFMMfFFhFp"))
		assertEquals('L', day3.getCommonItemType("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
		assertEquals('s', day3.getCommonItemType("CrZsJsPPZsGzwwsLwLmpwMDw"))
	}

	@Test
	fun testGetTotalPriority() {
		assertEquals(157, day3.getTotalPriority(testInput))
	}


	@Test
	fun testGetCommonItemTypeForGroup() {
		assertEquals(
			'r', day3.getCommonItemTypeForGroup(
				listOf(
					"vJrwpWtwJgWrhcsFMMfFFhFp",
					"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
					"PmmdzqPrVvPwwTWBwg"
				)
			)
		)
	}

	@Test
	fun getGroups() {
		assertContentEquals(
			listOf(
				listOf(
					"vJrwpWtwJgWrhcsFMMfFFhFp",
					"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
					"PmmdzqPrVvPwwTWBwg"
				),
				listOf(
					"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
					"ttgJtRGJQctTZtZT",
					"CrZsJsPPZsGzwwsLwLmpwMDw"
				)
			), day3.getGroups(testInput)
		)
	}

	@Test
	fun getTotalItemPriorityForGroups() {
		assertEquals(70, day3.getTotalItemPriorityForGroups(testInput))
	}
}