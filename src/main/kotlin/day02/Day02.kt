package day02

fun part1(input: List<String>): Int {
    return input
        .map { Game(it) }
        .filter { it.isPossible() }
        .sumOf { it.id }
}

fun part2(input: List<String>): Int {
    return input
        .map { Game(it) }
        .sumOf { it.fewestCubesPower() }
}
