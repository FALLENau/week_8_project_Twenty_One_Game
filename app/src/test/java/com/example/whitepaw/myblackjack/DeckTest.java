package com.example.whitepaw.myblackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class DeckTest {
    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void canCountDeck() {
        assertEquals(52, deck.countDeck());
    }

//    @Test
//    public void printOutDeck() {
//        this.deck.printDeck(52);
//    }

    @Test
    public void deckCanGiveCards() {
        assertNotNull(deck.dealNextCard());
    }
}
