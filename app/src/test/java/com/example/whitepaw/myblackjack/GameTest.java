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
        assertNotNull(newGame.countScore(player1));
    }

    @Test
    public void playRound() {
        newGame.giveCardToPlayer(player1, newGame.getCard());
        newGame.giveCardToPlayer(dealer, newGame.getCard());
        assertNotNull(newGame.compareValueOfHands());
    }

//    @Test
//    public void checkForBust() {
//        newGame.playGame();
//        newGame.giveCardToPlayer(dealer, newGame.getCard());
//        newGame.giveCardToPlayer(player1, newGame.getCard());
//        newGame.giveCardToPlayer(player1, newGame.getCard());
//        newGame.giveCardToPlayer(player1, newGame.getCard());
//        newGame.giveCardToPlayer(player1, newGame.getCard());
//        System.out.println(newGame.countPlayerHand(player1));
//        System.out.println(newGame.countScore(player1));
//        newGame.askIfHit(dealer);
//        assertEquals(false, newGame.checkForBust(dealer));
//        System.out.println(newGame.countPlayerHand(dealer));
//        System.out.println(newGame.countScore(dealer));
//        System.out.println(newGame.compareValueOfHands());
//    }//note: works just fine

//    @Test
//    public void whatCardsDoesPlayer1Have() {
//        newGame.playGame();
//        System.out.println(newGame.countPlayerHand(player1));
//        System.out.println(newGame.countScore(player1));
//        System.out.println(player1.countHand());
//    }

    @Test
    public void whyDoesDealWin() {
        newGame.giveCardToPlayer(player1, new Card(Suit.Clubs, 6));
        newGame.giveCardToPlayer(player1, new Card(Suit.Clubs, 10));
        newGame.giveCardToPlayer(dealer, new Card(Suit.Clubs, 8));
        newGame.giveCardToPlayer(dealer, new Card(Suit.Clubs, 3));

        System.out.println(player1.getCardsOfPlayerHand());
        System.out.println(player1.countHand());
        System.out.println(newGame.countScore(player1));

        System.out.println(dealer.getCardsOfPlayerHand());
        System.out.println(dealer.countHand());
        System.out.println(newGame.countScore(dealer));
        assertEquals("dealer", newGame.compareValueOfHands());
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

//    @Test
//    public void playGame() {
//        newGame.playGame();
//        System.out.println(newGame.countPlayerHand(player1));
//        System.out.println(newGame.countPlayerHand(dealer));
//        System.out.println(newGame.countScore(player1));
//        System.out.println(newGame.countScore(dealer));
//
//
//    }



}

