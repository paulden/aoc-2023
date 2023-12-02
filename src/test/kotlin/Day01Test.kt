import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day01Test {
    @Test
    fun `part1 should return 142 with test input`() {
        val testInput = readInput("Day01_part1_test")

        val actual = day01Part1(testInput)

        assertEquals(142, actual)
    }

    @Test
    fun `part2 should return 281 with test input`() {
        val testInput = readInput("Day01_part2_test")

        val actual = day01Part2(testInput)

        assertEquals(281, actual)
    }
}
