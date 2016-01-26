package com.ozankurt.blackjack.players;

import com.ozankurt.blackjack.deck.cards.Card;

import java.util.ArrayList;

public class Dealer extends Player {

    public Dealer() {
        super();
    }

    public boolean shouldDraw() {
        return getHand().getValue() <= 16;
    }

    public Hand getHiddenHand() {
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(getHand().getCards().get(0));

        return new Hand(cards);
    }

    public Card getHiddenCard() {
        return getHand().getCards().get(1);
    }

}
