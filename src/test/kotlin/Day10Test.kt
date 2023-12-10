import day10.part1
import day10.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day10Test {
    @Test
    fun `part1 should return 4 with first test input`() {
        val testInput = readInput("Day10_test1")

        val actual = part1(testInput)

        assertEquals(4, actual)
    }

    @Test
    fun `part1 should return 8 with first test input`() {
        val testInput = readInput("Day10_test2")

        val actual = part1(testInput)

        assertEquals(8, actual)
    }
}
