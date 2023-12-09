package day09

class Changes(history: String) {
    private val initialHistory: List<Int>
    private var histories: List<List<Int>> = mutableListOf()

    init {
        initialHistory = history
            .split(" ")
            .map { it.toInt() }

        histories.addLast(initialHistory)

        while (!histories.last().all { it == 0 }) {
            val nextHistory = histories.last()
                .windowed(2, 1)
                .map { it[1] - it[0] }
            histories.addLast(nextHistory)
        }
    }

    fun extrapolateNextValue(): Int {
        var lastValue = 0
        for (history in histories.dropLast(1).reversed()) {
            lastValue += history.last()
        }
        return lastValue
    }

    fun extrapolatePreviousValue(): Int {
        var previousValue = 0
        for (history in histories.dropLast(1).reversed()) {
            previousValue = history.first() - previousValue
        }
        return previousValue
    }
}
