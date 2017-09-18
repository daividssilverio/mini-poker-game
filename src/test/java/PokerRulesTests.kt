import org.junit.Test
import kotlin.test.assertFailsWith
import org.assertj.core.api.Assertions.*

class PokerRulesTests {

    private val pokerRules = PokerRules()
    private val player1 = Player("Player 1", pokerRules, Hand(emptyArray()))
    private val player2 = Player("Player 2", pokerRules, Hand(emptyArray()))

    companion object {
        val PAIR = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.SPADES),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )
        val THREE_OF_A_KIND = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.SPADES),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )
        val FOUR_OF_A_KIND = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.SPADES),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )
        val TWO_PAIRS = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.SPADES),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )
        val FLUSH = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS)
        )
        val FULL_HOUSE = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.SPADES),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS)
        )
        val STRAIGHT = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.SPADES),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SIX, Card.Suit.DIAMONDS)
        )
        val STRAIGHT_FLUSH = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
                Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SIX, Card.Suit.DIAMONDS)
        )
        val ROYAL_FLUSH = arrayOf(
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
                Card(Card.Rank.TEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.JACK, Card.Suit.DIAMONDS),
                Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS),
                Card(Card.Rank.KING, Card.Suit.DIAMONDS)
        )
        val GARBAGE = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.SPADES),
                Card(Card.Rank.FOUR, Card.Suit.SPADES),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS)
        )
        val BETTER_GARBAGE = arrayOf(
                Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
                Card(Card.Rank.THREE, Card.Suit.SPADES),
                Card(Card.Rank.FOUR, Card.Suit.SPADES),
                Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
                Card(Card.Rank.ACE, Card.Suit.DIAMONDS)
        )
    }


    @Test
    fun aPlayerHasToHaveAtLeast5Cards() {
        player1.hand = Hand(arrayOf(
                Card(Card.Rank.TWO, Card.Suit.SPADES),
                Card(Card.Rank.FOUR, Card.Suit.SPADES),
                Card(Card.Rank.FIVE, Card.Suit.SPADES),
                Card(Card.Rank.SIX, Card.Suit.SPADES))
        )
        player2.hand = Hand(PAIR)

        assertFailsWith(PokerRules.InvalidHandException::class) {
            pokerRules.appointWinner(player1, player2)
        }
    }

    @Test
    fun aPlayerHasToHaveAtMost5Cards() {
        player1.hand = Hand(arrayOf(
                Card(Card.Rank.TWO, Card.Suit.SPADES),
                Card(Card.Rank.FOUR, Card.Suit.SPADES),
                Card(Card.Rank.FIVE, Card.Suit.SPADES),
                Card(Card.Rank.SIX, Card.Suit.SPADES),
                Card(Card.Rank.SEVEN, Card.Suit.SPADES),
                Card(Card.Rank.EIGHT, Card.Suit.SPADES))
        )
        player2.hand = Hand(PAIR)

        assertFailsWith(PokerRules.InvalidHandException::class) {
            pokerRules.appointWinner(player1, player2)
        }
    }

    @Test
    fun canDecideIfAPairIsBetterThanNothing() {
        player1.hand = Hand(PAIR)
        player2.hand = Hand(GARBAGE)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfToTwoPairsIsBetterThanOnePair() {
        player1.hand = Hand(TWO_PAIRS)
        player2.hand = Hand(PAIR)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfThreeOfAKindIsBetterThanTwoPairs() {
        player1.hand = Hand(THREE_OF_A_KIND)
        player2.hand = Hand(TWO_PAIRS)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfAnStraightIsBetterThreeOfAKind() {
        player1.hand = Hand(STRAIGHT)
        player2.hand = Hand(THREE_OF_A_KIND)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfAFlushIsBetterThanAnStraight() {
        player1.hand = Hand(FLUSH)
        player2.hand = Hand(STRAIGHT)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfAFullHouseIsBetterThanAFlush() {
        player1.hand = Hand(FULL_HOUSE)
        player2.hand = Hand(FLUSH)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfAFourOfAKindIsBetterThanAFullHouse() {
        player1.hand = Hand(FOUR_OF_A_KIND)
        player2.hand = Hand(FULL_HOUSE)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfAStraightFlushIsBetternThanFourOfAKind() {
        player1.hand = Hand(STRAIGHT_FLUSH)
        player2.hand = Hand(FOUR_OF_A_KIND)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideIfARoyalFlushIsBetterTHanAStraightFlush() {
        player1.hand = Hand(ROYAL_FLUSH)
        player2.hand = Hand(STRAIGHT_FLUSH)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

    @Test
    fun canDecideOverATie() {
        player1.hand = Hand(BETTER_GARBAGE)
        player2.hand = Hand(GARBAGE)

        val winner = pokerRules.appointWinner(player1, player2)

        assertThat(winner).isEqualTo(player1)
    }

}