import org.junit.Test
import org.assertj.core.api.Assertions.*

class PlayerTests {

    private val dummyGameRules = object : CardGameRules {
        override fun checkPlayerCardsValidity(hand: Hand?) {
            TODO("not implemented")
        }

        override fun appointWinner(player1: Player, player2: Player): Player {
            TODO("not implemented")
        }

    }

    @Test
    fun aPlayerCanExist() {
        val player = Player("Player 1", dummyGameRules, Hand(emptyArray()))
        assertThat(player).isNotNull()
    }

}