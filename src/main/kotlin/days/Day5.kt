package days

import Day

class Day5 : Day {

    fun doInstructions(currentStacks: MutableMap<Int, MutableList<Char>>, instructions: List<List<Int>>): MutableMap<Int, MutableList<Char>> {

        for(instruction in instructions) {
            for(times in 1..instruction[0]) {
                val crate = currentStacks[instruction[1]]!!.first()

                currentStacks[instruction[1]]?.remove(crate)
                currentStacks[instruction[2]]?.add(0, crate)
            }
        }

        return currentStacks
    }

    fun doInstructionsForNewCrane(currentStacks: MutableMap<Int, MutableList<Char>>, instructions: List<List<Int>>): MutableMap<Int, MutableList<Char>> {

        for(instruction in instructions) {
            val crates = currentStacks[instruction[1]]!!.slice(0 until instruction[0])

            currentStacks[instruction[1]] = currentStacks[instruction[1]]?.subList(instruction[0], currentStacks[instruction[1]]!!.size)?.toMutableList() ?: mutableListOf()
            currentStacks[instruction[2]]?.addAll(0, crates)
        }

        return currentStacks
    }

    fun getResultOfRearrangement(input: String): String {
        val newStacks = doInstructions(mapStacks(input.split("\n\n")[0]), mapInstructions(input.split("\n\n")[1]))

        var topCrates = ""

        for(stack in newStacks.values) {
            topCrates += stack.first()
        }

        return topCrates
    }

    fun getResultOfRearrangementForNewCrane(input: String): String {
        val newStacks = doInstructionsForNewCrane(mapStacks(input.split("\n\n")[0]), mapInstructions(input.split("\n\n")[1]))

        var topCrates = ""

        for(stack in newStacks.values) {
            topCrates += stack.first()
        }

        return topCrates
    }

    override fun getResult(): String {
        return getResultOfRearrangement(getInput())
    }

    override fun getSecondResult(): String {
        return getResultOfRearrangementForNewCrane(getInput())
    }

    override fun getDay(): Int {
        return 5
    }

    fun mapInstructions(input: String): List<List<Int>> {
        var result = mutableListOf<List<Int>>()

        for(line in input.split("\n")) {
            result.add(listOf(line.split(" ")[1].toInt(), line.split(" ")[3].toInt(), line.split(" ")[5].toInt()))
        }

        return result
    }

    fun mapStacks(input: String): MutableMap<Int, MutableList<Char>> {
        val lines = input.split("\n")
        val numberOfStacks = lines.last().split(" ").last { !it.isNullOrEmpty() }.toInt()

        var stacks = mutableMapOf<Int, MutableList<Char>>()

        for(stackNumber in 1..numberOfStacks) {
            stacks[stackNumber] = mutableListOf()

            for(line in lines.subList(0, lines.count() - 1)) {
                val crate = line[stackNumber * 4 - 3]

                if(crate != ' ') {
                    stacks[stackNumber]!!.add(crate)
                }
            }
        }

        return stacks
    }
}