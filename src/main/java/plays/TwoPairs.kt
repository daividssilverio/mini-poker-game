package plays

import Card
import plays.util.stringifyRanks
import java.util.regex.Pattern

class TwoPairs : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val pairPattern = Pattern.compile("(\\d{1,2}:)\\1")
        val pairMatcher = pairPattern.matcher(cards.stringifyRanks())
        return pairMatcher.find() && pairMatcher.find()
    }

}