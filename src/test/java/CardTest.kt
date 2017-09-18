import org.assertj.core.api.Assertions.*
import org.junit.Test

class CardTest {

    @Test
    fun cardsCanBeCreated() {
        val card = Card(Card.Rank.ACE, Card.Suit.DIAMONDS)

        assertThat(card.rank).isEqualTo(Card.Rank.ACE)
        assertThat(card.suit).isEqualTo(Card.Suit.DIAMONDS)
    }

    @Test
    fun cardRanksCanBeCompared() {
        val cards = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SIX, Card.Suit.DIAMONDS),
                Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS),
                Card(Card.Rank.NINE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.JACK, Card.Suit.DIAMONDS),
                Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS)
        )

        for (cardIndex in 0..(cards.size - 2)) {
            assertThat(cards[cardIndex]).isLessThan(cards[cardIndex + 1])
        }
    }

    @Test
    fun cardsAreNotEqual() {
        val aceOfClubs = Card(Card.Rank.ACE, Card.Suit.CLUBS)
        val aceOfSpades = Card(Card.Rank.ACE, Card.Suit.SPADES)

        assertThat(aceOfClubs).isNotEqualTo(aceOfSpades)
        assertThat(aceOfClubs == aceOfSpades).isFalse()
    }

}