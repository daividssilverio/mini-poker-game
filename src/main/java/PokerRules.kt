import plays.*

class PokerRules : CardGameRules {

    companion object {
        private val games = arrayOf(
                RoyalFlush(),
                StraightFlush(),
                FourOfAKind(),
                FullHouse(),
                Flush(),
                Straight(),
                ThreeOfAKind(),
                TwoPairs(),
                OnePair(),
                NoGame()
        )
    }

    override fun appointWinner(player1: Player, player2: Player): Player {
        checkPlayerCardsValidity(player1.hand)
        checkPlayerCardsValidity(player2.hand)

        val player1GameRank = games.indexOf(identifyPlay(player1.hand))
        val player2GameRank = games.indexOf(identifyPlay(player2.hand))

        return when {
            player1GameRank < player2GameRank -> player1
            player2GameRank < player1GameRank -> player2
            else -> {
                resolveTie(player1, player2)
            }
        }
    }

    private fun resolveTie(player1: Player, player2: Player): Player {
        val player1SortedCards = player1.hand.cards.sorted()
        val player2SortedCards = player2.hand.cards.sorted()

        player1SortedCards.zip(player2SortedCards).forEach {
            if (it.first > it.second) return player1
            if (it.second > it.first) return player2
        }
        throw UnbreakableTieException()
    }

    private fun identifyPlay(hand: Hand): Play {
        return games.first { it.matches(hand.cards) }
    }

    override fun checkPlayerCardsValidity(hand: Hand?) {
        hand?.let {
            if (it.cards.size != 5) {
                throw InvalidHandException("A player has to have 5 cards, ${it.cards.size} given")
            }
        }
    }

    class UnbreakableTieException : Throwable()
    class InvalidHandException(override val message: String? = null) : Throwable(message)

}