import plays.Play

class NoGame : Play {
    override fun matches(cards: Array<Card>) = true
}