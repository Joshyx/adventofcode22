package days

fun String.areAllCharactersUnique(): Boolean {
    this.forEach { char ->
        this.replaceFirst(char.toString(), "").forEach { comparedChar ->
            if(char == comparedChar) {
                return false
            }
        }
    }

    return true
}