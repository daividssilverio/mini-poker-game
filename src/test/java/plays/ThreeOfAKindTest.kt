package plays

import org.assertj.core.api.Assertions.*
import org.junit.Test
import Card

class ThreeOfAKindTest {

    @Test
    fun aTripleCanBeDetected() {
        val triple = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS)
        )

        assertThat(ThreeOfAKind().matches(triple)).isTrue()
    }

    @Test
    fun aTripleIsNotFoundWhereIsNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS)
        )

        assertThat(ThreeOfAKind().matches(pair)).isFalse()
    }

}