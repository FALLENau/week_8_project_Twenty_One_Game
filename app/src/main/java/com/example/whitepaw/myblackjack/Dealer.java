package com.example.whitepaw.myblackjack;

import java.util.ArrayList;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class Dealer {
    private Deck deck;
    private ArrayList<Card> dealersHand;
    private int handTotal;

    public Dealer() {
        dealersHand = new ArrayList<Card>();
        deck = new Deck();
    }

    public int countDeck() {
        return deck.countDeck();
    }

    public Card dealerCanGiveCard() {
        Card card = deck.dealNextCard();
        return card;
    }

    public void addCardToDealerHand(Card card) {
        dealersHand.add(card);
    }

    public void giveCardToPlayer(Player playerHand) {
        Card card = this.dealerCanGiveCard();
        playerHand.addCardToPlayerHand(card);
    }

    public int countDealerHand() {
        return dealersHand.size();
    }
}
