package plays

import Card
import plays.util.stringifyRanks
import java.util.regex.Pattern

class ThreeOfAKind : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val triplePattern = Pattern.compile("(\\d{1,2}:)\\1\\1")
        return triplePattern.matcher(cards.stringifyRanks()).find()
    }

}