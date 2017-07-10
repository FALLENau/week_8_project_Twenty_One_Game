package com.example.whitepaw.myblackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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
        dealer = new Dealer();
        player1 = new Player();
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
}

