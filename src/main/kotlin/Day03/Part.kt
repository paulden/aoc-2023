package Day03

class Part(
    val value: String,
    private val startX: Int,
    private val endX: Int,
    private val y: Int
) {
    fun hasNeighbor(potentialNeighbors: List<Part>): Boolean {
        return potentialNeighbors.any { isNeighbor(it) }
    }

    fun listNeighbors(potentialNeighbors: List<Part>): List<Part> {
        return potentialNeighbors.filter { isNeighbor((it)) }
    }

    private fun isNeighbor(neighbor: Part): Boolean {
        val hasHorizontalNeighborhood = (startX - 1 <= neighbor.endX) && (endX + 1 >= neighbor.startX)
        val hasVerticalNeighborhood = (y - 1 <= neighbor.y) && (y + 1 >= neighbor.y)
        return hasHorizontalNeighborhood && hasVerticalNeighborhood
    }
}
