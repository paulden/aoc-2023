package day06

fun part1(input: List<String>): Int {
    val times = parseInformation(input[0])
    val recordDistances = parseInformation(input[1])

    return times.indices.map {i ->
        var winningCount = 0
        for (holdTime in 1..<times[i]) {
            val remainingTime = times[i] - holdTime
            val traveledDistance = holdTime * remainingTime
            if (traveledDistance > recordDistances[i]) {
                winningCount++
            }
        }
        winningCount
    }
        .reduce{acc, count -> acc * count}
}

fun part2(input: List<String>): Long {
    val time = parseInformationWithAdjustedKerning(input[0])
    val recordDistance = parseInformationWithAdjustedKerning(input[1])

    var winningCount : Long = 0
    for (holdTime in 1..<time) {
        val remainingTime = time - holdTime
        val traveledDistance = holdTime * remainingTime
        if (traveledDistance > recordDistance) {
            winningCount++
        }
    }
    return winningCount
}

fun parseInformation(information: String): List<Int> {
    return information
        .split(" ")
        .map{ it.trim() }
        .filter{ it.isNotEmpty() }
        .drop(1)
        .map{ it.toInt() }
}

fun parseInformationWithAdjustedKerning(information: String): Long {
    return information
        .filter{ it.isDigit() }
        .toLong()
}
