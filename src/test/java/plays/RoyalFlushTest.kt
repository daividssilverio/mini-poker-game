package plays

import org.assertj.core.api.Assertions
import org.junit.Test
import Card

class RoyalFlushTest {

    @Test
    fun aRoyalFlushCanBeDetected() {
        for (suit in Card.Suit.values()) {
            val royalFlush = arrayOf(
                    Card(Card.Rank.TEN, suit),
                    Card(Card.Rank.JACK, suit),
                    Card(Card.Rank.QUEEN, suit),
                    Card(Card.Rank.KING, suit),
                    Card(Card.Rank.ACE, suit)
            )

            Assertions.assertThat(RoyalFlush().matches(royalFlush)).isTrue()
        }
    }

    @Test
    fun aRoyalFlushAreNotFoundWhereNotPresent() {
        val somePlay = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(RoyalFlush().matches(somePlay)).isFalse()
    }

}