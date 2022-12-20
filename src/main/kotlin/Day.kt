import java.io.File
import java.nio.file.Files

interface Day {
    fun getResult(): String
    fun getSecondResult(): String
    fun getDay(): Int
    fun getInput(): String {
        return Files.readString(File("src/main/resources/day${getDay()}/input.txt").toPath())
    }
}