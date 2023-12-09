import day09.part1
import day09.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day09Test {
    @Test
    fun `part1 should return 114 with first test input`() {
        val testInput = readInput("Day09_test")

        val actual = part1(testInput)

        assertEquals(114, actual)
    }

    @Test
    fun `part2 should return 2 with first test input`() {
        val testInput = readInput("Day09_test")

        val actual = part2(testInput)

        assertEquals(2, actual)
    }
}
