package com.example.whitepaw.myblackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Whitepaw on 08/07/2017.
 */

public class Deck {

    private ArrayList<Card> myDeck;
    private int numberOfCards;

    public Deck() {
        this(1, true);
    }

    public Deck(int numberOfCardsInDeck, boolean shuffleDeck) {
        myDeck = new ArrayList<Card>();

        //note index picker

        //note: take a deck
        for (int deck = 0; deck < numberOfCardsInDeck; deck++) {
            //note: pick a suit
            for (int suit = 0; suit < 4; suit++) {
                //note: pick a number
                for (int number = 1; number < 14; number++) {
                    //note: add card to hand
                    this.myDeck.add(new Card(Suit.values()[suit], number));
                    this.numberOfCards++;
                }
            }
        }
        if (shuffleDeck == true) {
            this.shuffleDeck();
        }

    }

    public void shuffleDeck() {
        Collections.shuffle(myDeck, new Random());
    }

    public Card dealNextCard() {
        Card topCard = myDeck.remove(0);
        return topCard;
    }

    public int countDeck() {
        return myDeck.size();
    }

    public void printDeck(int cardsOfDeckToPrint) {
        for (int card = 0; card < cardsOfDeckToPrint; card++) {
            System.out.printf("% 3d/%d %s\n", card+1, this.numberOfCards, this.myDeck.get(card).toString());
        }
        System.out.printf("\t\t[%d other]\n", this.numberOfCards-cardsOfDeckToPrint);
    }

}
