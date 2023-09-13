package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayLoss extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayend);

        Intent intent = getIntent();
        String message = intent.getStringExtra("com.example.sendmessage.MESSAGE");
        message = message + "\n GAME OVER \n You clicked on a mine!";

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    public void backToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}