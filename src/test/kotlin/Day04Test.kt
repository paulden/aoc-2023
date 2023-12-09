import day04.part1
import day04.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day04Test {
    @Test
    fun `part1 should return 13 with test input`() {
        val testInput = readInput("Day04_test")

        val actual = part1(testInput)

        assertEquals(13, actual)
    }

    @Test
    fun `part2 should return 30 with test input`() {
        val testInput = readInput("Day04_test")

        val actual = part2(testInput)

        assertEquals(30, actual)
    }
}
