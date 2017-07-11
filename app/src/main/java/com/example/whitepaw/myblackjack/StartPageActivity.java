package com.example.whitepaw.myblackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StartPageActivity extends AppCompatActivity {
    Button hitButton;
    Button holdButton;
    TextView resultText;
    TextView handText;
    boolean playerInput;
    Deck deck;
    Player player1;
    ArrayList<Player> appGame;
    Game newGame;
    Player dealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        deck = new Deck();
        dealer = new Dealer("Dealer");
        player1 = new Player("Reece");
        appGame = new ArrayList<Player>();
        appGame.add(player1);
        appGame.add(dealer);

        newGame = new Game(appGame, deck);
        newGame.playGame();

        String currentPlayer = player1.getName();

        hitButton = (Button) findViewById(R.id.hit_button);
        holdButton = (Button) findViewById(R.id.hold_button);
        resultText = (TextView) findViewById(R.id.result_text);
        handText = (TextView) findViewById(R.id.hand_text);
    }

    public void onClickHitButton(View button) {
        player1.addCardToPlayerHand(newGame.getCard());
        String hand = player1.getCardsOfPlayerHand();
//        Log.d(getClass().toString(), score);
        handText.setText((hand));
    }

    public void onClickHoldButton(View button) {
        newGame.playTurn(player1);
        String result = newGame.compareValueOfHands();
//        int score = newGame.countScore(player1);
        String hand = player1.getCardsOfPlayerHand();

//        Log.d(getClass().toString(), result);
        handText.setText((hand));
        resultText.setText((result));
    }//note: hash out till functional

}
