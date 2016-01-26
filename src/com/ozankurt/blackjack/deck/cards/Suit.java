package com.ozankurt.blackjack.deck.cards;

public enum Suit {

    HEARTS,
    SPADES,
    DIAMONDS,
    CLUBS;

    public String getName() {
        return name().substring(0,1).toUpperCase() + name().substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return getName();
    }
}