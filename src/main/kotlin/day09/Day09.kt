package day09

fun part1(input: List<String>): Int {
    return input
        .map { Changes(it) }
        .sumOf { it.extrapolateNextValue() }
}

fun part2(input: List<String>): Int {
    return input
        .map { Changes(it) }
        .sumOf { it.extrapolatePreviousValue() }
}
