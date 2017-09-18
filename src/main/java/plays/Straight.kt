package plays

import Card

class Straight : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val cardRanks = cards.map { it.rank.ordinal }.sorted()
        return (0..3).none { cardRanks[it] + 1 != cardRanks[it + 1] }
    }

}