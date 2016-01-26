package com.ozankurt.blackjack.players;

import com.ozankurt.blackjack.deck.cards.Card;
import com.ozankurt.blackjack.deck.cards.Rank;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean exceeded21() {
        return getValue() > 21;
    }

    public int getValue() {
        int sum = 0;

        for (Card card: cards) {
            sum += card.getRank().getValue();
        }

        int decreasedAceValue = 0;

        while (sum > 21 && containsAce() && getAceCount() != decreasedAceValue)
        {
            sum -= 10;
            decreasedAceValue++;
        }

        return sum;
    }

    private int getAceCount() {
        int count = 0;

        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                count++;
            }
        }

        return count;
    }

    public boolean containsAce() {
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(cards);
    }
}
