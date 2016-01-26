package com.ozankurt.blackjack.players;

import com.ozankurt.blackjack.deck.cards.Card;

import java.util.ArrayList;

public class Player {

    private static int currentPlayerId = 0;

    protected int id;
    protected Hand hand = new Hand();
    protected State state;

    public Player() {
        this.id = currentPlayerId++;
    }

    public Card drawCard(ArrayList<Card> cards) {
        int index = cards.size() - 1;

        Card card = cards.get(index);

        this.hand.addCard(card);

        cards.remove(index);

        return card;
    }

    public boolean hasBlackJack() {
        return hand.getValue() == 21;
    }

    public Hand getHand() {
        return hand;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean didNotSayStand() {
        if (state == null || state != State.STAND)
            return true;

        return false;
    }
}
