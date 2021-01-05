package com.a5studios.tictactoe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TicMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_main_page);
    }

    public void startgame(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
