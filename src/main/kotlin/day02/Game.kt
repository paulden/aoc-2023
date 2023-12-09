package day02

class Game(record: String) {
    val id: Int
    private val sets: List<Map<String, Int>>

    private val maximumCubes = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14
    )

    init {
        val (game, playedSets) = record.split(": ")
        id = game
            .filter { it.isDigit() }
            .toInt()
        sets = playedSets
            .split("; ")
            .map { parseSet(it) }
    }

    fun isPossible(): Boolean {
        for (set in sets) {
            set.forEach { cube ->
                if (cube.value > maximumCubes[cube.key]!!) {
                    return false
                }
            }
        }
        return true
    }

    fun fewestCubesPower(): Int {
        val fewestCubesRequired = mutableMapOf("red" to 0, "blue" to 0, "green" to 0)
        for (set in sets) {
            set.forEach { cube ->
                if (cube.value > fewestCubesRequired[cube.key]!!) {
                    fewestCubesRequired[cube.key] = cube.value
                }
            }
        }
        return fewestCubesRequired.values.reduce { acc, cube -> acc * cube }
    }

    private fun parseSet(set: String) =
        set
            .split(", ")
            .associate { parseCubes(it) }

    private fun parseCubes(cube: String): Pair<String, Int> {
        val (number, color) = cube.split(" ")
        return color to number.toInt()
    }
}
