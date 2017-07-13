package com.example.whitepaw.myblackjack;

import android.content.Intent;
import android.media.MediaPlayer;
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
    Button restartButton;
    TextView resultText;
    TextView handText;
    TextView handScoreText;
    TextView dealerHandText;
    TextView dealerHandScoreText;
    Deck deck;
    Player player1;
    Player dealer;
    ArrayList<Player> appGame;
    Game newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name", "Player");
        Log.e("Ahhh", "value of name is: " + name);



        deck = new Deck();
        dealer = new Dealer("Dealer");
        player1 = new Player(name);
        appGame = new ArrayList<Player>();
        appGame.add(player1);
        appGame.add(dealer);
        newGame = new Game(appGame, deck);
        newGame.playGame();
        String playerBlackjack = newGame.blackJack();

        hitButton = (Button) findViewById(R.id.hit_button);
        holdButton = (Button) findViewById(R.id.hold_button);
        restartButton = (Button) findViewById(R.id.restart);
        resultText = (TextView) findViewById(R.id.result_text);

        handText = (TextView) findViewById(R.id.hand_text);
        handScoreText = (TextView) findViewById(R.id.hand_value);

        dealerHandText = (TextView) findViewById(R.id.dealer_hand_text);
        dealerHandScoreText = (TextView) findViewById(R.id.dealer_hand_value);


        if(playerBlackjack == null) {
            createData();
        } else {
            createData();
            resultText.setText(playerBlackjack);
            endGame();
        }
    }

    public void onClickHitButton(View button) {
        player1.addCardToPlayerHand(newGame.getCard());
        String hand = player1.getCardsOfPlayerHand();

        int handScore = newGame.countScore(player1);
        String handValue = Integer.toString(handScore);

        if (newGame.checkForBust(player1)) {
            resultText.setText(getString(R.string.app_bust));
            endGame();

        } else {
            handText.setText((hand));
        }
        handScoreText.setText((handValue));
    }


    public void onClickHoldButton(View button) {
        newGame.playTurn(dealer);
        String result = newGame.compareValueOfHands();
        resultText.setText((result));
        createData();
        endGame();
    }

    public void onReset(View button) {
        finish();
    }

    private void createData() {

        TextView nameText = (TextView) findViewById(R.id.name_game_text);
        nameText.setText(player1.getName());
        String hand = player1.getCardsOfPlayerHand();
        int handScore = newGame.countScore(player1);
        String handValue = Integer.toString(handScore);

        String dealerHand = dealer.getCardsOfPlayerHand();
        int dealerHandScore = newGame.countScore(dealer);
        String dealerHandValue = Integer.toString(dealerHandScore);

        handText.setText((hand));
        handScoreText.setText((handValue));

        dealerHandText.setText((dealerHand));
        dealerHandScoreText.setText((dealerHandValue));
    }

    private void endGame() {

        if(resultText.getText().equals("Dealer")) {
            MediaPlayer fail = MediaPlayer.create(this, R.raw.sound);

            fail.start();
        }

        restartButton.setVisibility(View.VISIBLE);
        hitButton.setVisibility(View.INVISIBLE);
        holdButton.setVisibility(View.INVISIBLE);
    }
}
