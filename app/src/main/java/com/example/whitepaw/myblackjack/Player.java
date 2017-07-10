package com.example.whitepaw.myblackjack;

import java.util.ArrayList;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class Player {
    protected ArrayList<Card> myHand;
    private int handTotal;
    private String name;

    public Player(String playerName) {
        this.name = playerName;
        myHand = new ArrayList<Card>();
    }


    public void addCardToPlayerHand(Card card) {
        myHand.add(card);
    }//note: takes card from dealer and adds it to hand.

    public int countPlayerHand() {
        return myHand.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getMyHand() {
        return myHand;
    }

    public int getTotalOfHandOnPlayer(Player player) {
        return player.myHand.size();
    }

    //    public int countHand() {
//        return myHand.size();
//    }//note: Card myHand is inherited by player for andriod dysplay later on.
}
