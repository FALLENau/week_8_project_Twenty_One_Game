package com.example.whitepaw.myblackjack;

import java.util.ArrayList;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class Game {
    ArrayList<Player> players;
    Deck deck;

    public Game(ArrayList<Player> gamePlayers, Deck gameDeck) {
        this.players = gamePlayers;
        this.deck = gameDeck;
    }

    public int countDeck() {
        return deck.countDeck();
    }

    public Card getCard() {
        Card card = deck.dealNextCard();
        return card;
    }


    public void giveCardToPlayer(Player playerHand, Card card) {
        playerHand.addCardToPlayerHand(card);
    }

    public int countValueOfHand(Player player) {
        int i;
        int sum = 0;
        for(i = 0; i < player.getMyHand().size(); i++) {
            sum += player.getMyHand().get(i).getNumber();
        }
        return sum;
    }//note: Card myHand is inherited by player

//    public int countValueOfHand() {
//        int i;
//        int sum = 0;
//        for(i = 0; i < myHand.size(); i++) {
//            sum += myHand.get(i).getNumber();
//        }
//        return sum;
//    }//note: Card myHand is inherited by player

}
