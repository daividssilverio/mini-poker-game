package plays

import Card

class RoyalFlush : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val cardRanks = cards.map { it.rank.ordinal }.sorted()
        val rankRoyalStraight = cardRanks.containsAll(listOf(
                Card.Rank.TEN.ordinal,
                Card.Rank.JACK.ordinal,
                Card.Rank.QUEEN.ordinal,
                Card.Rank.KING.ordinal,
                Card.Rank.ACE.ordinal
        ))
        return rankRoyalStraight && Flush().matches(cards)
    }

}