interface CardGameRules {
    fun checkPlayerCardsValidity(hand: Hand?)

    fun appointWinner(player1: Player, player2: Player): Player
}