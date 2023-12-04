package Day04

import parseIntegers
import kotlin.math.pow

fun part1(input: List<String>): Int {
    return input
        .map { Card(it) }
        .sumOf { it.computeScore() }
}

fun part2(input: List<String>): Int {
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
