package day1

import IDay
import java.io.File
import java.nio.file.Files

class Day1 : IDay {
    fun getAllElves(input: String): List<Long> {
        var calories: MutableList<Long> = mutableListOf()

        var currentElf = 0
        for(calory: String in input.split("\n")) {
            if(!calory.trim().isNullOrEmpty()) {

                if(calories.count() <= currentElf) {
                    calories.add(0)
                }
                calories[currentElf] += calory.toLong()
            } else {
                currentElf++
            }
        }

        return calories
    }

    fun getRichestElf(input: String): Long {
        return getAllElves(input).sortedDescending()[0]
    }

    override fun getResult(): String {
        return getRichestElf(getInput()).toString()
    }

    override fun getSecondResult(): String {
        return getTopThreeElves(getInput()).toString()
    }

    override fun getInput(): String {
        return Files.readString(File("src/main/resources/day1/input.txt").toPath()).trim()
    }

    fun getTopThreeElves(input: String): Long {
        val elves = getAllElves(input).sortedDescending()

        return elves[0] + elves[1] + elves[2]
    }
}