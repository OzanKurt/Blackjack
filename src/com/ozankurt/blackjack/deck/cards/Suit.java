package com.ozankurt.blackjack.deck.cards;

import com.ozankurt.blackjack.utilities.StringUtilities;

public enum Suit {

    HEARTS,
    SPADES,
    DIAMONDS,
    CLUBS;

    public String getName() {
        return StringUtilities.upperCaseFirst(name());
    }

    @Override
    public String toString() {
        return getName();
    }
}