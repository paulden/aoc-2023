import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day02Test {
    @Test
    fun `part1 should return 8 with test input`() {
        val testInput = readInput("Day02_test")

        val actual = day02Part1(testInput)

        assertEquals(8, actual)
    }

    @Test
    fun `part2 should return 2286 with test input`() {
        val testInput = readInput("Day02_test")

        val actual = day02Part2(testInput)

        assertEquals(2286, actual)
    }
}
