package plays

import Card
import plays.util.stringifyRanks

import java.util.regex.Pattern

class OnePair : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val pairPattern = Pattern.compile("(\\d{1,2}:)\\1")
        return pairPattern.matcher(cards.stringifyRanks()).find()
    }

}
