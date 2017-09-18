package plays

import org.assertj.core.api.Assertions
import org.junit.Test
import Card

class TwoPairsTest {

    @Test
    fun twoPairsCanBeDetected() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(TwoPairs().matches(pair)).isTrue()
    }

    @Test
    fun twoPairsAreNotFoundWhereNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(TwoPairs().matches(pair)).isFalse()
    }

}