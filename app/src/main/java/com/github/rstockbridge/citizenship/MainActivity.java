package com.github.rstockbridge.citizenship;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.rstockbridge.citizenship.data.FavoritesStorage;
import com.github.rstockbridge.citizenship.data.Question;
import com.github.rstockbridge.citizenship.data.QuestionBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SHORT_LENGTH = 10;
    private static final int MED_LENGTH = 25;
    private static final int LONG_LENGTH = 100;

    private Button shortButton;
    private Button medButton;
    private Button longButton;
    private Button favoritesPracticeButton;
    private Button manageFavoritesButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
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

            case R.id.long_button:
                startFlashcards(LONG_LENGTH);
                break;

            case R.id.favorites_practice_button:
                startFavoritesPractice();
                break;

            case R.id.manage_favorites_button:
                startManageFavorites();
                break;

            default:
                throw new IllegalStateException("This line should never be reached.");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        syncFavoritesButton();
    }

    private void setupUI() {
        initializeViews();
        setListeners();
        syncFavoritesButton();
    }

    private void initializeViews() {
        shortButton = findViewById(R.id.short_button);
        medButton = findViewById(R.id.med_button);
        longButton = findViewById(R.id.long_button);
        favoritesPracticeButton = findViewById(R.id.favorites_practice_button);
        manageFavoritesButton = findViewById(R.id.manage_favorites_button);
    }

    private void setListeners() {
        shortButton.setOnClickListener(this);
        medButton.setOnClickListener(this);
        longButton.setOnClickListener(this);
        favoritesPracticeButton.setOnClickListener(this);
        manageFavoritesButton.setOnClickListener(this);
    }

    private void syncFavoritesButton() {
        final int size = FavoritesStorage.getSharedInstance().getSize();
        favoritesPracticeButton.setEnabled(size > 0);
        favoritesPracticeButton.setText(getResources().getString(R.string.favorites, size));
    }

    private void startFlashcards(final int numberOfFlashcards) {
        final List<Question> allQuestions = QuestionBank.getSharedInstance().getAllQuestions();
        Collections.shuffle(allQuestions);
        FlashcardPagerActivity.start(this, new ArrayList<>(allQuestions.subList(0, numberOfFlashcards)), false);
    }

    private void startFavoritesPractice() {
        final ArrayList<Question> favorites = new ArrayList<>(FavoritesStorage.getSharedInstance().getFavorites());
        Collections.shuffle(favorites);
        FlashcardPagerActivity.start(this, favorites, true);
    }

    private void startManageFavorites() {
        final Intent intent = new Intent(this, ManageFavoritesActivity.class);
        startActivity(intent);
    }
}
