data class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {

    override fun compareTo(other: Card): Int {
        return rank.compareTo(other.rank)
    }

    enum class Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }

    enum class Suit {
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS
    }

}