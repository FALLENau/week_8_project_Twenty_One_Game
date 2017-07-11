package com.example.whitepaw.myblackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartPageActivity extends AppCompatActivity {
    Button hitButton;
    Button holdButton;
    TextView resultText;
    boolean playerInput;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        game = new Game();
        game.playGame();
        hitButton = (Button) findViewById(R.id.hit_button);
        holdButton = (Button) findViewById(R.id.hold_button);
        resultText = (TextView) findViewById(R.id.result_text);
        handText = (TextView) findViewById(R.id.hand_text);
    }

    public boolean onClickHitButton(View button) {
        boolean playerInput = true;
        game = new Game(game.askIfHit(Player player));
        String result = game.countPlayerHand(Player who?);
        String hand = game.countPlayerHand(Player who?);

//        Log.d(getClass().toString(), result);
        handText.setText((hand));
        resultText.setText((result));
    }

    public boolean onClickHoldButton(View button) {
        boolean playerInput = false;
        game = new Game(game.askIfHit(playerInput));
        String result = game.countPlayerHand(Player player);
        String hand = game.countPlayerHand(Player player);

//        Log.d(getClass().toString(), result);
        handText.setText((hand));
        resultText.setText((result));
    }

}
