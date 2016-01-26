package com.ozankurt.blackjack.deck.cards;

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
        return name().substring(0,1).toUpperCase() + name().substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return getName();
    }
}
