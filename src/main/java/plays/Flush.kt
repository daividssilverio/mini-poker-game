package plays

import Card

class Flush : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val cardRanks = cards.map { it.suit.ordinal }.sorted()
        return cardRanks[0] == cardRanks[4]
    }

}