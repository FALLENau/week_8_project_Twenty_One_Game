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

        //note: shuffleDeck
        if (shuffleDeck == true) {
            this.shuffleDeck();
        }

    }

    public void shuffleDeck() {
        Collections.shuffle(myDeck, new Random());
//        Random random = new Random();
//        Card temp;
//        int value;
//        for (int i = 0; i < 500; i++) {
//            value = random.nextInt(this.numberOfCards);
////            temp = this.myDeck(i);
////            this.myDeck(i) = this.myDeck(value);
////            this.myDeck(value) = temp;
//        }
    }

    public Card dealNextCard() {
        Card topCard = myDeck.remove(0);
//        Card topCard = this.myDeck.get(0);
//        for (int card = 1; card < this.numberOfCards; card++) {
////            this.myDeck.get(card-1) = this.myDeck(card);
//        }
//        this.myDeck(this.numberOfCards-1) = null;
//        this.numberOfCards--;
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
