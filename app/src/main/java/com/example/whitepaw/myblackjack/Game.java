package com.example.whitepaw.myblackjack;

import java.util.ArrayList;

/**
 * Created by Whitepaw on 09/07/2017.
 */

public class Game {
    Boolean playerInput;
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

    public int countPlayerHand(Player playerHand) {
        return playerHand.getMyHand().size();
    }//note: Card myHand is inherited by player

    public int countScore(Player player) {
        int i;
        int sum = 0;
        for (i = 0; i < player.getMyHand().size(); i++) {
            int num = player.getMyHand().get(i).getNumber();

            if (num > 10) {num = 10;}//note: this adjust face for blackjack to 10;

            if (sum < 11 && num == 1) {
                num = 11;
            }
            sum += num;
        }
        return sum;
    }//note: Card myHand is inherited by player

    public void playGame() {
        setupGame();
//        for (Player player : players) {
//            playTurn(player);
//        }
        compareValueOfHands();
    }//note: only thing that needs to be left within the game.class for when everything to rule class.

    public void playTurn(Player player) {
        if (askIfHit(player)) {
            while (true) {
                this.giveCardToPlayer(player, this.getCard());
                if (checkForBust(player)) break;
                if (!askIfHit(player)) break;
            }
        }
    }

    public boolean askIfHit(Player player) {
        boolean result = true;
//       add check for dealer here
        if (player.getName().equals("Dealer")) {
            this.countScore(player);{
            if (this.countScore(player) >= 16) return false;}
        } else { return true;}
//       does player bust (use break; in the while loop)
        return result;
    }

    public boolean checkForBust(Player player) {
        boolean result = false;
        if (this.countScore(player) > 21)
            result = true;
        return result;
    }

    public void setupGame() {
        for (Player player : players) {
            Card card1 = getCard();
            giveCardToPlayer(player, card1);
            Card card2  = getCard();
            giveCardToPlayer(player, card2);
        }
        //deal 2 cards for each player and dealer
        //check each player if they want to hit or not, and check if bust(in hti method)
        // while (wants to hit){ give card which will check for bust }
    }

    public String blackJack() {

//        Player blackJackPlayer = null;
        int blackJack = 21;

        for (Player player : this.players) {
            if (countScore(player) == blackJack) {
                return player.getName() + "\n has BlackJack! you wins";
            }
        }
        return null;
    }

    public String compareValueOfHands() {

        Player maxPlayer = null;

        for(Player player: this.players)
        {
            if(!checkForBust(player)) {
                maxPlayer = player;
                break;
            }
        }

        if(maxPlayer == null) {
            return "No one wins";
        }

        for(Player player : this.players) {
            if(countScore(player) >= countScore(maxPlayer) && !checkForBust(player)) {
                maxPlayer = player;
            }
        }
        return maxPlayer.getName();
    }
}
