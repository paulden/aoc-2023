fun readInput(name: String): List<String> {
    return object {}.javaClass.getResourceAsStream("$name.txt")!!
        .bufferedReader()
        .readLines()
}

fun parseIntegers(string: String): List<Int> {
    return string
        .split(" ")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
}
