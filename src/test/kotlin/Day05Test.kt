import Day05.part1
import Day05.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day05Test {
    @Test
    fun `part1 should return 35 with test input`() {
        val testInput = readInput("Day05_test")

        val actual = part1(testInput)

        assertEquals(35, actual)
    }

    @Test
    fun `part2 should return 46 with test input`() {
        val testInput = readInput("Day05_test")

        val actual = part2(testInput)

        assertEquals(46, actual)
    }
}
