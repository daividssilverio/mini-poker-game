import java.util.*

data class Hand(val cards: Array<Card>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hand

        if (!Arrays.equals(cards, other.cards)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(cards)
    }

}