package com.example.whitepaw.myblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartPageActivity extends AppCompatActivity {
    TextView nameText;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        nameText = (EditText) findViewById(R.id.name_text);
        startButton = (Button) findViewById(R.id.start_button);
    }

    public void onStartButtonClicked(View Button) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("name", nameText.getText());
        startActivity(intent);
    }
}