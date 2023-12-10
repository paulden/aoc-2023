package day10

fun part1(input: List<String>): Int {
    val tiles = input
        .mapIndexed { j, line ->
            line.mapIndexed { i, char -> Tile(char, i, j) }
        }
        .flatten()

    val startingTile = tiles.first { it.type == 'S' }
    val startingNeighbors = tiles.filter { it.isNeighbor(startingTile) }

    val loop = mutableListOf(startingTile)
    var currentTile = startingNeighbors.first()
    var hasLooped = false

    while (!hasLooped) {
        loop.addLast(currentTile)
        val neighbors = currentTile.getNeighbors(tiles)
        if (!loop.contains(neighbors[0])) {
            currentTile = neighbors[0]
        } else if (!loop.contains(neighbors[1])) {
            currentTile = neighbors[1]
        } else {
            hasLooped = true
        }
    }
    return loop.size / 2
}

fun part2(input: List<String>): Int {
    return 1
}
