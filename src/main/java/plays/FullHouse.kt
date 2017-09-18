package plays
import Card
import plays.util.stringifyRanks
import java.util.regex.Pattern

class FullHouse : Play {

    override fun matches(cards: Array<Card>): Boolean {
        val fullHousePattern = Pattern.compile("(\\d{1,2}:)\\1{1,2}(?!\\1)(\\d{1,2}:)\\2{1,2}")
        val cardsString = cards.stringifyRanks()

        return fullHousePattern.matcher(cardsString).matches()
    }

}