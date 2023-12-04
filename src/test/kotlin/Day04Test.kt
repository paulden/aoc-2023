import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day04Test {
    @Test
    fun `part1 should return 13 with test input`() {
        val testInput = readInput("Day04_test")

        val actual = day04Part1(testInput)

        assertEquals(13, actual)
    }

    @Test
    fun `part2 should return 30 with test input`() {
        val testInput = readInput("Day04_test")

        val actual = day04Part2(testInput)

        assertEquals(30, actual)
    }
}
