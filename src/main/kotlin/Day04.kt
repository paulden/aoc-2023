import kotlin.math.pow

fun day04Part1(input: List<String>): Int {
    return input
        .map { Card(it) }
        .sumOf { it.computeScore() }
}

fun day04Part2(input: List<String>): Int {
    val cards: Map<Int, Card> = input
        .map { Card(it) }
        .associateBy { it.id }

    var newCards = cards.values.toList()
    var totalScratchcards = newCards.count()

    while (newCards.isNotEmpty()) {
        newCards = newCards
            .map { it.getCardsWon(cards) }
            .flatten()
        totalScratchcards += newCards.count()
    }
    return totalScratchcards
}

class Card(card: String) {
    val id: Int
    private val winningNumbers: Set<Int>
    private val cardNumbers: Set<Int>

    init {
        val (cardId, numbers) = card.split(": ")
        id = cardId
            .filter { it.isDigit() }
            .toInt()
        val (first, second) = numbers
            .split(" | ")
            .map { parseIntegers(it) }
            .map { it.toSet() }
        winningNumbers = first
        cardNumbers = second
    }

    fun computeScore(): Int {
        val commonNumbers = countCommonNumbers()
        return if (commonNumbers == 0) {
            0
        } else {
            2.0.pow((commonNumbers - 1).toDouble()).toInt()
        }
    }

    fun getCardsWon(cards: Map<Int, Card>): List<Card> {
        val score = countCommonNumbers()
        return ((id + 1)..(id + score))
            .map { cards[it]!! }
    }

    private fun countCommonNumbers(): Int {
        return winningNumbers
            .intersect(cardNumbers)
            .count()
    }
}
