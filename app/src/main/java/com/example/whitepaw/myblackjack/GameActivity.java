package com.example.whitepaw.myblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    Button hitButton;
    Button holdButton;
    TextView resultText;
    TextView handText;
    TextView handScoreText;
    Button restartButton;
    Deck deck;
    Player player1;
    ArrayList<Player> appGame;
    Game newGame;
    Player dealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        
        TextView nameText = (TextView) findViewById(R.id.name_game_text);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name", " Player ");
        Log.e("Ahhh", "value of name is: " + name);
        nameText.setText(name);
//        answerText.setText(answer);

        deck = new Deck();
        dealer = new Dealer("Dealer");
        player1 = new Player(name);
        appGame = new ArrayList<Player>();
        appGame.add(player1);
        appGame.add(dealer);

        newGame = new Game(appGame, deck);
        newGame.playGame();

        String hand = player1.getCardsOfPlayerHand();
        int handScore = newGame.countScore(player1);
        String handValue = Integer.toString(handScore);

        hitButton = (Button) findViewById(R.id.hit_button);
        holdButton = (Button) findViewById(R.id.hold_button);
        resultText = (TextView) findViewById(R.id.result_text);
        handText = (TextView) findViewById(R.id.hand_text);
        handScoreText = (TextView) findViewById(R.id.hand_value);
        restartButton = (Button) findViewById(R.id.restart);

        handText.setText((hand));
        handScoreText.setText((handValue));
    }

    public void onClickHitButton(View button) {
        player1.addCardToPlayerHand(newGame.getCard());
        String hand = player1.getCardsOfPlayerHand();

        int handScore = newGame.countScore(player1);
        String handValue = Integer.toString(handScore);

        if (newGame.checkForBust(player1)) {
            handText.setText(getString(R.string.app_bust));
            restartButton.setVisibility(View.VISIBLE);
            hitButton.setVisibility(View.INVISIBLE);
        } else {
            handText.setText((hand));
        }
        handScoreText.setText((handValue));
    }

    public void onClickHoldButton(View button) {
        newGame.playTurn(dealer);
        String result = newGame.compareValueOfHands();
        String hand = player1.getCardsOfPlayerHand();

        handText.setText((hand));
        resultText.setText((result));

        restartButton.setVisibility(View.VISIBLE);
        holdButton.setVisibility(View.INVISIBLE);
    }

    public void onReset(View button) {
        finish();
    }
}
