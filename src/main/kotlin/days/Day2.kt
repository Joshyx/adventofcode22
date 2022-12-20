package days

import Day

class Day2 : Day {
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
    // X: lose; Y: draw; Z: win
    // A: Rock; B: Paper; C: Scissors (keys)
    // X: Rock; Y: Paper; Z: Scissors (values)
    private val shapeToPlayLUT = mapOf(
        "X" to mapOf("A" to "Z", "B" to "X", "C" to "Y"),
        "Y" to mapOf("A" to "X", "B" to "Y", "C" to "Z"),
        "Z" to mapOf("A" to "Y", "B" to "Z", "C" to "X")
    )

    override fun getResult(): String {
        return getTotalScore(getInput()).toString()
    }

    override fun getSecondResult(): String {
        return getSecondTotalScore(getInput()).toString()
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

    fun chooseShape(match: String): String {
        val roundOutcome = match.split(" ")[1]
        val opponentShape = match.split(" ")[0]

        return shapeToPlayLUT[roundOutcome]!![opponentShape]!!
    }
    fun getScoreForSecondRound(match: String): Int {
        return getScoreForRound(match.substring(0, 2) + chooseShape(match))
    }
    fun getSecondTotalScore(input: String): Long {
        var totalScore = 0L

        for(match: String in input.split("\n")) {
            totalScore += getScoreForSecondRound(match)
        }

        return totalScore
    }

    override fun getDay(): Int {
        return 2
    }
}