private val wordsToNumber = mapOf(
    "zero" to 0,
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
    "0" to 0,
    "1" to 1,
    "2" to 2,
    "3" to 3,
    "4" to 4,
    "5" to 5,
    "6" to 6,
    "7" to 7,
    "8" to 8,
    "9" to 9,
)

fun part1(input: List<String>): Int {
    var calibrationValuesSum = 0
    for (line in input) {
        val digits = line
            .filter { it.isDigit() }
            .map { it.digitToInt() }
        calibrationValuesSum += digits.first() * 10 + digits.last()
    }
    return calibrationValuesSum
}

fun part2(input: List<String>): Int {
    var calibrationValuesSum = 0
    for (line in input) {
        val firstDigit = wordsToNumber
            .map { Pair(line.indexOf(it.key), it.value) }
            .filter { it.first >= 0 }
            .minBy { it.first }
            .second

        val lastDigit = wordsToNumber
            .map { Pair(line.lastIndexOf(it.key), it.value) }
            .filter { it.first >= 0 }
            .maxBy { it.first }
            .second

        calibrationValuesSum += firstDigit * 10 + lastDigit
    }
    return calibrationValuesSum
}
