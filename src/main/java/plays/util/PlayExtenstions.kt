package plays.util

import Card

fun Array<Card>.stringifyRanks() = sorted().map { it.rank.ordinal }.joinToString(separator = ":", postfix = ":")
