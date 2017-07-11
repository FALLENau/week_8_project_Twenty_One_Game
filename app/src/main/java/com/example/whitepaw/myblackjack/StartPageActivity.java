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
        game.playGame();
        hitButton = (Button) findViewById(R.id.rock_button);
        holdButton = (Button) findViewById(R.id.paper_button);
        resultText = (TextView) findViewById(R.id.result_text);
    }

    public void onClickHitButton(View button) {
        boolean playerInput = true;
        game = new Game(game.askIfHit(Player player));
        //String userInput = game.getPlayerInput();
//        String computerChoice = game.generateComputersChoice();
        String result = game.askIfHit(playerInput);

//        Log.d(getClass().toString(), result);
        // Intent intent = new Intent(this, GameActivity.class);
        // intent.putExtra("choice", userInput);
        // startActivity(intent);
        resultText.setText((result));
    }//Note: all commented out info is the first draft(which was wrong)

    public void onClickHoldButton(View button) {
        boolean buttonInput = false;
        game = new Game(playerInput);
//        String computerChoice = game.generateComputersChoice();
        String result = game.gameLogic(computerChoice);

//        Log.d(getClass().toString(), result);
        resultText.setText((result));
    }

}
