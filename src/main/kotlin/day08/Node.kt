package day08

class Node(node: String) {
    val self: String
    val left: String
    val right: String

    init {
        val (source, targets) = node.split(" = ")
        self = source

        val destinations = targets.drop(1)
            .dropLast(1)
            .split(", ")

        left = destinations[0]
        right = destinations[1]
    }
}
