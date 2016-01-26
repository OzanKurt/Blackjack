package com.ozankurt.blackjack.deck;

import com.ozankurt.blackjack.deck.cards.Card;
import com.ozankurt.blackjack.deck.cards.Rank;
import com.ozankurt.blackjack.deck.cards.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        addCards();

        shuffle();
    }

    private void addCards() {
        for (Rank rank: Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
