package plays

import org.assertj.core.api.Assertions
import org.junit.Test
import Card

class FlushTest {

    @Test
    fun aFlushCanBeDetected() {
        val pair = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SIX, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(Flush().matches(pair)).isTrue()
    }

    @Test
    fun aFlushAreNotFoundWhereNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.SPADES),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(Flush().matches(pair)).isFalse()
    }

}