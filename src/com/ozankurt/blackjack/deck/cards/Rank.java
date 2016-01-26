package com.ozankurt.blackjack.deck.cards;

import com.ozankurt.blackjack.utilities.StringUtilities;

public enum Rank {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return StringUtilities.upperCaseFirst(name());
    }

    @Override
    public String toString() {
        return getName();
    }
}
