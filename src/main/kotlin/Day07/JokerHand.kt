package Day07

private val headsToNumber = mapOf(
    'T' to 10,
    'J' to 0,
    'Q' to 12,
    'K' to 13,
    'A' to 14,
)

class JokerHand(hand: String) {
    val type: Int
    val bid: Int
    val cards: List<Int>

    init {
        val (first, second) = hand
            .split(" ")

        bid = second.toInt()

        val cardsCount = first
            .filter { it != 'J' }
            .groupingBy { it }
            .eachCount()
            .values
            .sorted()
            .reversed()

        val maxCount = cardsCount.getOrElse(0) { 0 }
        val secondMaxCount = cardsCount.getOrElse(1) { 0 }

        val jokersCount = first.count { it == 'J' }

        cards = first
            .map { if (headsToNumber.containsKey(it)) headsToNumber[it]!! else it.digitToInt() }

        type = when {
            maxCount + jokersCount == 5 -> 6
            maxCount + jokersCount == 4 -> 5
            (maxCount + jokersCount == 3 && secondMaxCount == 2) || (maxCount == 3 && secondMaxCount + jokersCount == 2) -> 4
            maxCount + jokersCount == 3 -> 3
            (maxCount + jokersCount == 2 && secondMaxCount == 2) || (maxCount == 2 && secondMaxCount + jokersCount == 2) -> 2
            maxCount + jokersCount == 2 -> 1
            else -> 0
        }
    }
}
