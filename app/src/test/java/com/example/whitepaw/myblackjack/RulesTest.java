package com.example.whitepaw.myblackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Whitepaw on 10/07/2017.
 */

public class RulesTest {
    Dealer dealer;
    Deck deck;
    Player player1;

    @Before
    public void before() {
        deck = new Deck();
        dealer = new Dealer("Dealer");
        player1 = new Player("Reece");
    }
}
