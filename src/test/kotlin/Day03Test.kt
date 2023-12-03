import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day03Test {
    @Test
    fun `part1 should return 4361 with test input`() {
        val testInput = readInput("Day03_test")

        val actual = day03Part1(testInput)

        assertEquals(4361, actual)
    }

    @Test
    fun `part2 should return 467835 with test input`() {
        val testInput = readInput("Day03_test")

        val actual = day03Part2(testInput)

        assertEquals(467835, actual)
    }
}
