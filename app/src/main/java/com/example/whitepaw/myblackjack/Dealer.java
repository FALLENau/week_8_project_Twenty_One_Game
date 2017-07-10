package com.example.whitepaw.myblackjack;

import java.util.ArrayList;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class Dealer extends Player {
    private Deck deck;

    public Dealer() {
        super();
//        deck = new Deck();
    }

    public int countDeck() {
        return deck.countDeck();
    }

    public Card dealerCanGiveCard() {
        Card card = deck.dealNextCard();
        return card;
    }

    public void addCardToDealerHand(Card card) {
        myHand.add(card);
    }
    //note: Card myHand is inherited by player

    public void giveCardToPlayer(Player playerHand) {
        Card card = this.dealerCanGiveCard();
        playerHand.addCardToPlayerHand(card);
    }

    public int countDealerHand() {
        return myHand.size();
    }//note: Card myHand is inherited by player

    public int countValueOfHand() {
        int i;
        int sum = 0;
        for(i = 0; i < myHand.size(); i++) {
            sum += myHand.get(i).getNumber();
        }
        return sum;
    }//note: Card myHand is inherited by player
}
