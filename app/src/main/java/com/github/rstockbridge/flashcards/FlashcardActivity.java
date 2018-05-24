package com.github.rstockbridge.flashcards;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FlashcardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        final FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.flashcard_container);

        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.flashcard_container, new FlashcardFragment())
                    .commit();
        }
    }
}
