package com.example.whitepaw.myblackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class GameTest {
    Game newGame;
    Dealer dealer;
    Deck deck;
    Player player1;

    @Before
    public void before() {
        deck = new Deck();
        dealer = new Dealer("Dealer");
        player1 = new Player("Reece");
        ArrayList<Player> liveGame = new ArrayList<Player>();
        liveGame.add(player1);
        liveGame.add(dealer);
        newGame = new Game(liveGame, deck);
    }

    @Test
    public void canCountDeck() {
        assertEquals(52, newGame.countDeck());
    }

    @Test
    public void giveCardToPlayer() {
        newGame.giveCardToPlayer(dealer, newGame.getCard());
        assertEquals(1, dealer.countPlayerHand());
    }


    @Test
    public void sumOfHand() {
        newGame.giveCardToPlayer(player1, newGame.getCard());
        assertNotNull(newGame.countValueOfHand(player1));
    }

    @Test
    public void playRound() {
        newGame.giveCardToPlayer(player1, newGame.getCard());
        newGame.giveCardToPlayer(dealer, newGame.getCard());
        assertNotNull(newGame.compareValueOfHands());
    }

    @Test
    public void checkForBust() {
        newGame.setupGame();
        newGame.giveCardToPlayer(player1, newGame.getCard());
        newGame.giveCardToPlayer(player1, newGame.getCard());
        newGame.giveCardToPlayer(player1, newGame.getCard());
        assertEquals(true, newGame.checkForBust(player1));
        System.out.println(newGame.checkForBust(player1));
    }

//    @Test
//    public void playTwoRounds() {
//        newGame.giveCardToPlayer(player1, newGame.getCard());
//        newGame.giveCardToPlayer(dealer, newGame.getCard());
//
//        assertEquals(1, newGame.countPlayerHand(player1));
//        //hit on call and add card.
//        newGame.giveCardToPlayer(player1, newGame.getCard());
//        assertEquals(2, newGame.countPlayerHand(player1));
//        //sit, circle though other players and finish.
//
//        assertNotEquals(0, newGame.compareValueOfHands());
//        System.out.println(newGame.compareValueOfHands());
//    }note: complete don't worrie about it bro!



}

