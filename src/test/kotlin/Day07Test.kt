import day07.part1
import day07.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day07Test {
    @Test
    fun `part1 should return 6440 with test input`() {
        val testInput = readInput("Day07_test")

        val actual = part1(testInput)

        assertEquals(6440, actual)
    }

    @Test
    fun `part2 should return 5905 with test input`() {
        val testInput = readInput("Day07_test")

        val actual = part2(testInput)

        assertEquals(5905, actual)
    }
}
