package day04

fun part1(input: List<String>): Int {
    return input
        .map { Card(it) }
        .sumOf { it.computeScore() }
}

fun part2(input: List<String>): Int {
    val cards: Map<Int, Card> = input
        .map { Card(it) }
        .associateBy { it.id }

    var countOfNewCards = cards.values
        .toList()
        .associateWith { 1 }
    var totalScratchcards = countOfNewCards.values.sum()

    while (countOfNewCards.isNotEmpty()) {
        val nextRound = mutableMapOf<Card, Int>()
            .withDefault { 0 }

        countOfNewCards
            .forEach { card ->
                val newCardsWon = card.key.getCardsWon(cards)
                for (newCard in newCardsWon) {
                    nextRound[newCard] = nextRound.getValue(newCard) + card.value
                }
            }

        countOfNewCards = nextRound

        totalScratchcards += countOfNewCards.values.sum()
    }
    return totalScratchcards
}
