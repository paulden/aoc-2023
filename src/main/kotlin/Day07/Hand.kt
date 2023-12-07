package Day07

private val headsToNumber = mapOf(
    'T' to 10,
    'J' to 11,
    'Q' to 12,
    'K' to 13,
    'A' to 14,
)

class Hand(hand: String) {
    val type: Int
    val bid: Int
    val cards: List<Int>

    init {
        val (first, second) = hand
            .split(" ")

        bid = second.toInt()

        val cardsCount = first
            .groupingBy { it }
            .eachCount()
            .values

        cards = first
            .map { if (headsToNumber.containsKey(it)) headsToNumber[it]!! else it.digitToInt() }

        type = when {
            cardsCount.contains(5) -> 6
            cardsCount.contains(4) -> 5
            cardsCount.contains(3) && cardsCount.contains(2) -> 4
            cardsCount.contains(3) -> 3
            cardsCount.count { it == 2 } == 2 -> 2
            cardsCount.contains(2) -> 1
            else -> 0
        }
    }
}
