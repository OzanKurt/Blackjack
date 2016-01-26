package com.ozankurt.blackjack;

import com.ozankurt.blackjack.deck.cards.Card;
import com.ozankurt.blackjack.deck.Deck;
import com.ozankurt.blackjack.players.Dealer;
import com.ozankurt.blackjack.players.Player;
import com.ozankurt.blackjack.players.State;

import java.util.Scanner;

public class Game {

    private Dealer dealer;
    private Player player;

    private Deck deck;

    public Game() {
        this.dealer = new Dealer();
        this.player = new Player();
        this.deck = new Deck();
    }

    public void start() {

        dealCards();

        if (player.hasBlackJack()) {
            System.out.println("Player wins via BlackJack.");

            System.exit(0);
        }

        if (dealer.hasBlackJack()) {
            System.out.println("Dealer reveals the second card: " + dealer.getHiddenCard());

            System.out.println("Dealer wins via BlackJack.");

            System.exit(0);
        }

        while (player.didNotSayStand()) {
            askPlayer();
        }

        runDealersTurn();

        readUserInput();

    }

    private void runDealersTurn() {
        System.out.println("Dealer reveals the second card.");
        System.out.println("Dealers hand: " + dealer.getHand().getValue() + " -> " + dealer.getHand());

        if (dealer.getHand().getValue() > player.getHand().getValue())
        {
            System.out.println("Player lost.");

            System.exit(0);
        }

        while (dealer.shouldDraw()) {
            Card drawnCard = dealer.drawCard(deck.getCards());

            System.out.println("Dealer draws: " + drawnCard);

            printCurrentHands();

            if (dealer.getHand().exceeded21())
            {
                System.out.println("Dealer busts. Player won.");

                System.exit(0);
            }

            if (dealer.getHand().getValue() > player.getHand().getValue())
            {
                System.out.println("Player lost.");

                System.exit(0);
            }
        }

        printCurrentHands();

        System.out.println("Dealer cannot draw more cards.");

        if (dealer.getHand().getValue() > player.getHand().getValue())
        {
            System.out.println("Player lost.");

            System.exit(0);
        }
        else
        {
            System.out.println("Player won.");

            System.exit(0);
        }
    }

    private void askPlayer() {
        printCurrentHands();

        System.out.println("Which action you want to take? (Hit, Stand)");

        String action = readUserInput();

        if (action.equalsIgnoreCase("hit")) {
            player.drawCard(deck.getCards());

            if (player.getHand().exceeded21()) {
                System.out.println("Player busts. " + player.getHand().getValue() + " -> " + player.getHand());
                System.exit(0);
            }

            player.setState(State.HIT);
        }

        if (action.equalsIgnoreCase("stand")) {
            player.setState(State.STAND);
        }
    }

    private void printCurrentHands() {
        System.out.println("Your hand: " + player.getHand().getValue() + " -> " + player.getHand());

        if (player.getState() == State.STAND)
        {
            System.out.println("Dealers hand: " + dealer.getHand().getValue() + " -> " + dealer.getHand());
        }
        else
        {
            System.out.println("Dealers hand: " + dealer.getHiddenHand().getValue() + " -> " + dealer.getHiddenHand());
        }
    }

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private void dealCards() {
        Card drawnCard;

        drawnCard = player.drawCard(deck.getCards());
        System.out.println("Player draws: " + drawnCard);

        drawnCard = dealer.drawCard(deck.getCards());
        System.out.println("Dealer draws: " + drawnCard);

        drawnCard = player.drawCard(deck.getCards());
        System.out.println("Player draws: " + drawnCard);

        dealer.drawCard(deck.getCards());
        System.out.println("Dealer draws.");
    }
}
