package com.ozankurt.blackjack.players;

import com.ozankurt.blackjack.deck.cards.Card;

import java.util.ArrayList;

public class Player {

    private static int currentPlayerId = 0;

    private int id;
    private Hand hand = new Hand();
    private State state;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
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
