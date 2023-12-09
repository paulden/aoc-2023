import day08.part1
import day08.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day08Test {
    @Test
    fun `part1 should return 2 with first test input`() {
        val testInput = readInput("Day08_part1_test1")

        val actual = part1(testInput)

        assertEquals(2, actual)
    }
    
    @Test
    fun `part1 should return 6 with second test input`() {
        val testInput = readInput("Day08_part1_test2")

        val actual = part1(testInput)

        assertEquals(6, actual)
    }

    @Test
    fun `part2 should return 6 with test input`() {
        val testInput = readInput("Day08_part2_test")

        val actual = part2(testInput)

        assertEquals(6.0, actual)
    }
}
