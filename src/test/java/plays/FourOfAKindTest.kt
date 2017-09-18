package plays

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import Card

class FourOfAKindTest {

    @Test
    fun aFourOfAKindCanBeDetected() {
        val fourOfAKind = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS)
        )

        assertThat(FourOfAKind().matches(fourOfAKind)).isTrue()
    }

    @Test
    fun aFourOfAKindIsNotFoundWhereIsNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS)
        )

        assertThat(FourOfAKind().matches(pair)).isFalse()
    }
}
