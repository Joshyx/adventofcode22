import days.*

fun main() {

    val days = listOf(
        Day1(),
        Day2(),
        Day3(),
        Day4(),
        Day5(),
    )

    days.forEach {
        println("Day ${it.getDay()}")
        println("Result 1: ${it.getResult()}")
        println("Result 2: ${it.getSecondResult()}")
        println()
    }
}