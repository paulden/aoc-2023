package Day08

fun part1(input: List<String>): Int {
    val instructions = input.first()

    val nodes = input
        .drop(2)
        .map { Node(it) }
        .associateBy { it.self }

    var steps = 0
    var currentNode = nodes["AAA"]!!

    while (currentNode.self != "ZZZ") {
        val instruction = instructions[steps % instructions.length]
        val nextNode = if (instruction == 'L') currentNode.left else currentNode.right
        currentNode = nodes[nextNode]!!
        steps++
    }
    return steps
}

fun part2(input: List<String>): Double {
    val instructions = input.first()

    val nodes = input
        .drop(2)
        .map { Node(it) }
        .associateBy { it.self }

    val startingNodes = nodes
        .filter { it.key[2] == 'A' }
        .map { it.value }

    return startingNodes
        .map { startingNode ->
            var currentNode = startingNode
            var steps = 0
            while (currentNode.self[2] != 'Z') {
                val instruction = instructions[steps % instructions.length]
                val nextNode = if (instruction == 'L') currentNode.left else currentNode.right
                currentNode = nodes[nextNode]!!
                steps++
            }
            steps
        }
        .map { it.toDouble() }
        .reduce { acc, steps -> getLCM(acc, steps) }
}

fun getLCM(a: Double, b: Double): Double {
    val highestNumber = if (a > b) a else b
    val highestCommonMultiple = a * b
    var potentialCommonMultiple = highestNumber
    while (potentialCommonMultiple <= highestCommonMultiple) {
        if (potentialCommonMultiple % a == 0.0 && potentialCommonMultiple % b == 0.0) {
            return potentialCommonMultiple
        }
        potentialCommonMultiple += highestNumber
    }
    return highestCommonMultiple
}
