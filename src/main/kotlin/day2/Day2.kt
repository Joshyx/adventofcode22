package day2

import IDay
import java.io.File
import java.nio.file.Files

class Day2 : IDay {
    // A: Rock; B: Paper; C: Scissors (opponent)
    // X: Rock; Y: Paper; Z: Scissors (you)
    private val possibleScoresForShape = mapOf(
        "X" to 1, "Y" to 2, "Z" to 3
    )
    private val possibleScoresForOutcome = mapOf(
        "A X" to 3,
        "A Y" to 6,
        "A Z" to 0,
        "B X" to 0,
        "B Y" to 3,
        "B Z" to 6,
        "C X" to 6,
        "C Y" to 0,
        "C Z" to 3
    )

    override fun getResult(): String {
        return getTotalScore(getInput()).toString()
    }

    override fun getSecondResult(): String {
        TODO("Not yet implemented")
    }

    override fun getInput(): String {
        return Files.readString(File("src/main/resources/day2/input.txt").toPath()).trim()
    }

    fun getTotalScore(input: String): Long {
        var totalScore = 0L

        for(match: String in input.split("\n")) {
            totalScore += getScoreForRound(match)
        }

        return totalScore
    }

    fun getScoreForRound(match: String): Int {
        return getScoreForOutcome(match) + getScoreForShape(match)
    }

    fun getScoreForOutcome(match: String): Int {
        return possibleScoresForOutcome[match]!!
    }
    fun getScoreForShape(match: String): Int {
        return possibleScoresForShape[match.split(" ")[1]]!!
    }

    fun chooseShape(match: String) {
        val roundOutcome = match.split(" ")[1]
        val opponentShape = match.split(" ")[0]
    }
}