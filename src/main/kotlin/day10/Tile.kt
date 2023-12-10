package day10

class Tile(
    val type: Char,
    private val x: Int,
    private val y: Int
) {
    fun getNeighbors(tiles: List<Tile>): List<Tile> {
        return connectedTo()
            .map { pair -> tiles.first { it.x == pair.first && it.y == pair.second } }
    }

    fun isNeighbor(tile: Tile): Boolean {
        return connectedTo().contains(tile.x to tile.y)
    }

    private fun connectedTo(): List<Pair<Int, Int>> {
        return when (type) {
            '|' -> listOf(x to y - 1, x to y + 1)
            '-' -> listOf(x - 1 to y, x + 1 to y)
            'L' -> listOf(x to y - 1, x + 1 to y)
            'J' -> listOf(x to y - 1, x - 1 to y)
            '7' -> listOf(x to y + 1, x - 1 to y)
            'F' -> listOf(x to y + 1, x + 1 to y)
            else -> emptyList()
        }
    }

}
