package com.example.whitepaw.myblackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class DealerTest {
    Dealer dealer;
    Deck deck;
    Player player1;

    @Before
    public void before() {
        dealer = new Dealer();
        deck = new Deck();
        player1 = new Player();
    }

    @Test
    public void canCountDeckInDealersHand() {
        assertEquals(52, dealer.countDeck());
    }

    @Test
    public void canDealerGiveHimselfCards() {
        dealer.addCardToDealerHand(dealer.dealerCanGiveCard());
        assertEquals(1, dealer.countDealerHand());
    }

    @Test
    public void canDealerGivePlayerCards() {
        dealer.giveCardToPlayer(player1);
        assertEquals(1, player1.countPlayerHand());
    }
}
