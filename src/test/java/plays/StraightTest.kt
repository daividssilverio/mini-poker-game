package plays

import org.assertj.core.api.Assertions
import org.junit.Test
import Card

class StraightTest {

    @Test
    fun aStraightCanBeDetected() {
        val pair = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SIX, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(Straight().matches(pair)).isTrue()
    }

    @Test
    fun aStraightAreNotFoundWhereNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(Straight().matches(pair)).isFalse()
    }

    @Test
    fun aStraightAreNotFoundWhereTheImplementationIsNaive() {
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