package com.github.rstockbridge.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int SHORT_LENGTH = 10;
    private static final int MED_LENGTH = 25;
    private static final int LONG_LENGTH = 100;

    private Button shortButton;
    private Button medButton;
    private Button longButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shortButton = findViewById(R.id.short_button);
        shortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = FlashcardPagerActivity.newIntent(MainActivity.this, SHORT_LENGTH);
                startActivity(intent);
            }
        });

        medButton = findViewById(R.id.med_button);
        medButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = FlashcardPagerActivity.newIntent(MainActivity.this, MED_LENGTH);
                startActivity(intent);
            }
        });

        longButton = findViewById(R.id.long_button);
        longButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = FlashcardPagerActivity.newIntent(MainActivity.this, LONG_LENGTH);
                startActivity(intent);
            }
        });
    }
}