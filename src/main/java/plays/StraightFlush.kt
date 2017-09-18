package plays

import Card

class StraightFlush : Play {

    override fun matches(cards: Array<Card>) = Straight().matches(cards) && Flush().matches(cards)

}