# week_8_project_Twenty_One_Game

<--------->Blackjack<-------->

Goal: Create a card game.

The goal of this project is to model in Java the elements involved in a game of cards. You are not required to write a Runner to actually play the game, just write and test the models.

These include (but are not limited to): players, cards, hands of cards, cards being dealt, turns being taken.

You will also need to implement the rules of the game. The choice of game is up to you, but one game you may wish to model is Blackjack/Pontoon. (It's probably best to stick to a game which involves each player having only a small number of cards).

Remember to use TDD!

<--MVP-->

Deal two cards to the dealer and the player
Compare the hands
Determine the winner from who has the highest value hand
Project Extension

Allow the player to "hit" up to 21 or "hold" (you go bust if you exceed this and lose the round).
Allow the dealer to do the same
Compare hands once both players call hold.

<--Extreme Extension-->

Create an Android Application which allows you to play the game where the user is the player and the Computer is the dealer. It does not need to have much or any interaction. The aim is to display the results of the Java logic already written. For example, if you had two players being dealt two cards each your screen might look something like:
  Player 1: Ace of Hearts, 9 of Diamonds
  Player 2: 3 of Clubs, 2 of Hearts

  Player 1 Wins!
