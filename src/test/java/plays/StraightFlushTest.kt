package plays

import org.assertj.core.api.Assertions
import org.junit.Test
import Card

class StraightFlushTest {

    @Test
    fun aStraightFlushCanBeDetected() {
        val pair = arrayOf(
                Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS),
                Card(Card.Rank.NINE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.JACK, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(StraightFlush().matches(pair)).isTrue()
    }

    @Test
    fun aStraightFlushAreNotFoundWhereNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.SPADES),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SIX, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(StraightFlush().matches(pair)).isFalse()
    }

    @Test
    fun aStraightFlushIsNotFoundWhereTheImplementationIsNaive() {
        val pair = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(Straight().matches(pair)).isFalse()
    }

}