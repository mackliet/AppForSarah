package com.example.michael.appforsarah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    public final static String GAME_TYPE = "com.example.michael.appforsarah.TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /* Opens Game activity in correct mode

     */
    public void openGame (View view){
        Intent intent = new Intent(this, GameActivity.class);
        Button button = (Button) view;
        String type = button.getText().toString();
        intent.putExtra(GAME_TYPE, type);
        startActivity(intent);
    }
}
