package plays

import Card

interface Play {
    fun matches(cards: Array<Card>): Boolean
}