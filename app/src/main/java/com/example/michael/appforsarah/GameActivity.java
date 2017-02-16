package com.example.michael.appforsarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {
    private boolean canFlipCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        canFlipCards = false;
    }

    public void newGame(View view){

    }

    public void flipCard(View view){

    }
}
