package com.example.whitepaw.myblackjack;

import java.util.ArrayList;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class Player {
    private ArrayList<Card> myHand;
    private int handTotal;

    public Player() {
        myHand = new ArrayList<Card>();
    }


    public void addCardToPlayerHand(Card card) {
        myHand.add(card);
    }

//    public void addCardToDealerHand(Card card) {
//        dealersHand.add(card);
//    }

    public int countPlayerHand() {
        return myHand.size();
    }

}
