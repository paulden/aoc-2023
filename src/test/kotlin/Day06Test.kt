import day06.part1
import day06.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day06Test {
    @Test
    fun `part1 should return 288 with test input`() {
        val testInput = readInput("Day06_test")

        val actual = part1(testInput)

        assertEquals(288, actual)
    }

    @Test
    fun `part2 should return 71503 with test input`() {
        val testInput = readInput("Day06_test")

        val actual = part2(testInput)

        assertEquals(71503, actual)
    }
}
