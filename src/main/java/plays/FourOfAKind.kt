package plays

import java.util.regex.Pattern
import Card
import plays.util.stringifyRanks

class FourOfAKind : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val triplePattern = Pattern.compile("(\\d{1,2}:)\\1\\1\\1")
        return triplePattern.matcher(cards.stringifyRanks()).find()
    }

}