package plays

import org.assertj.core.api.Assertions
import org.junit.Test
import Card

class FullHouseTest {

    @Test
    fun aFullHouseCanBeDetected() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(FullHouse().matches(pair)).isTrue()
    }

    @Test
    fun threeOfAkindAreNotFullHouses() {
        val threeOfAKind = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.SPADES),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(FullHouse().matches(threeOfAKind)).isFalse()
    }

    @Test
    fun aFullHouseAreNotFoundWhereNotPresent() {
        val pair = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )

        Assertions.assertThat(FullHouse().matches(pair)).isFalse()
    }

}