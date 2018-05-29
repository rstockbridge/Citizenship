package com.github.rstockbridge.citizenship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.rstockbridge.citizenship.data.Question;
import com.github.rstockbridge.citizenship.data.QuestionBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SHORT_LENGTH = 10;
    private static final int MED_LENGTH = 25;
    private static final int LONG_LENGTH = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button shortButton = findViewById(R.id.short_button);
        final Button medButton = findViewById(R.id.med_button);
        final Button longButton = findViewById(R.id.long_button);

        shortButton.setOnClickListener(this);
        medButton.setOnClickListener(this);
        longButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.short_button:
                startFlashcards(SHORT_LENGTH);
                break;
            case R.id.med_button:
                startFlashcards(MED_LENGTH);
                break;
            case R.id.long_button: {
                startFlashcards(LONG_LENGTH);
                break;
            }
            default:
                // This branch intentionally left blank
        }
    }

    private void startFlashcards(final int numberOfFlashcards) {
        final List<Question> allQuestions = QuestionBank.getNewInstance().getAllQuestions();
        Collections.shuffle(allQuestions);

        final Intent intent = FlashcardPagerActivity.newIntent(this, new ArrayList<>(allQuestions.subList(0, numberOfFlashcards)));
        startActivity(intent);
    }
}