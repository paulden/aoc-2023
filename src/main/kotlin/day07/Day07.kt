package day07

fun part1(input: List<String>): Int {
    return input.map { Hand(it) }
        .sortedWith(
            compareBy(
                { it.type },
                { it.cards[0] },
                { it.cards[1] },
                { it.cards[2] },
                { it.cards[3] },
                { it.cards[4] })
        )
        .mapIndexed { rank, hand -> hand.bid * (rank + 1) }
        .sum()
}

fun part2(input: List<String>): Int {
    return input.map { JokerHand(it) }
        .sortedWith(
            compareBy(
                { it.type },
                { it.cards[0] },
                { it.cards[1] },
                { it.cards[2] },
                { it.cards[3] },
                { it.cards[4] })
        )
        .mapIndexed { rank, hand -> hand.bid * (rank + 1) }
        .sum()
}
