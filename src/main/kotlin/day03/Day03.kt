package day03

fun part1(input: List<String>): Int {
    val (engineParts: List<Part>, symbols: List<Part>) = parseEngineParts(input)

    return engineParts
        .filter { it.hasNeighbor(symbols) }
        .sumOf { it.value.toInt() }
}

fun part2(input: List<String>): Int {
    val (engineParts: List<Part>, symbols: List<Part>) = parseEngineParts(input)

    return symbols
        .filter { it.value == "*" }
        .map { it.listNeighbors(engineParts) }
        .filter { it.size == 2 }
        .sumOf { it[0].value.toInt() * it[1].value.toInt() }
}

private fun parseEngineParts(input: List<String>): Pair<List<Part>, List<Part>> {
    val engineParts: List<Part> = mutableListOf()
    val symbols: List<Part> = mutableListOf()

    for ((i, line) in input.withIndex()) {
        var currentPart = ""

        for ((j, char) in line.withIndex()) {
            if (currentPart != "" && !char.isDigit()) {
                engineParts.addLast(Part(currentPart, j - currentPart.length, j - 1, i))
                currentPart = ""
            }

            if (char == '.') {
                currentPart = ""
            } else if (!char.isDigit()) {
                symbols.addLast(Part(char.toString(), j, j, i))
            } else {
                currentPart += char.toString()
            }
        }

        if (currentPart != "") {
            engineParts.addLast(Part(currentPart, line.length - currentPart.length, line.length - 1, i))
        }
    }
    return Pair(engineParts, symbols)
}
