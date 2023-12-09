import day02.part1
import day02.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day02Test {
    @Test
    fun `part1 should return 8 with test input`() {
        val testInput = readInput("Day02_test")

        val actual = part1(testInput)

        assertEquals(8, actual)
    }

    @Test
    fun `part2 should return 2286 with test input`() {
        val testInput = readInput("Day02_test")

        val actual = part2(testInput)

        assertEquals(2286, actual)
    }
}
