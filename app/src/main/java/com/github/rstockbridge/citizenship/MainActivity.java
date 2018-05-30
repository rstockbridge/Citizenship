package com.github.rstockbridge.citizenship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.rstockbridge.citizenship.data.FavoritesManager;
import com.github.rstockbridge.citizenship.data.Question;
import com.github.rstockbridge.citizenship.data.QuestionBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SHORT_LENGTH = 10;
    private static final int MED_LENGTH = 25;
    private static final int LONG_LENGTH = 100;

    private Button favoritesPracticeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button shortButton = findViewById(R.id.short_button);
        final Button medButton = findViewById(R.id.med_button);
        final Button longButton = findViewById(R.id.long_button);
        favoritesPracticeButton = findViewById(R.id.favorites_practice_button);
        final Button manageFavoritesButton = findViewById(R.id.manage_favorites_button);

        shortButton.setOnClickListener(this);
        medButton.setOnClickListener(this);
        longButton.setOnClickListener(this);
        favoritesPracticeButton.setOnClickListener(this);
        manageFavoritesButton.setOnClickListener(this);

        syncFavoritesButton();
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
            case R.id.favorites_practice_button: {
                startFavoritesPractice();
                break;
            }
            case R.id.manage_favorites_button: {
                startManageFavorites();
                break;
            }
            default:
                // this branch intentionally left blank
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        syncFavoritesButton();
    }

    private void syncFavoritesButton() {
        final List<Integer> favorites = FavoritesManager.getSharedInstance().getFavorites();
        favoritesPracticeButton.setEnabled(favorites.size() > 0);
        favoritesPracticeButton.setText(getResources().getString(R.string.favorites, favorites.size()));
    }

    private void startFlashcards(final int numberOfFlashcards) {
        final List<Question> allQuestions = QuestionBank.getSharedInstance().getAllQuestions();
        Collections.shuffle(allQuestions);

        FlashcardPagerActivity.start(this, new ArrayList<>(allQuestions.subList(0, numberOfFlashcards)), false);
    }

    private void startFavoritesPractice() {
        final List<Integer> favorites = FavoritesManager.getSharedInstance().getFavorites();
        FlashcardPagerActivity.start(this, QuestionBank.getSharedInstance().getQuestionsFromId(favorites), true);
    }

    private void startManageFavorites() {
        ManageFavoritesActivity.start(this);
    }
}