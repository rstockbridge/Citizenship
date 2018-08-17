package com.github.rstockbridge.citizenship;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.rstockbridge.citizenship.data.Question;

import java.util.List;


public final class FlashcardAdapter extends FragmentStatePagerAdapter {

    @NonNull
    private List<Question> questions;

    private boolean favoritesPractice;

    FlashcardAdapter(
            @NonNull final FragmentManager fragmentManager,
            @NonNull final List<Question> questions,
            final boolean favoritesPractice) {
        super(fragmentManager);

        this.questions = questions;
        this.favoritesPractice = favoritesPractice;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < getCount() - 1) {
            final boolean lastFlashcard = position == getCount() - 2;
            return FlashcardFragment.newInstance(questions.get(position), lastFlashcard, favoritesPractice);
        } else {
            return new CompletedFragment();
        }
    }

    @Override
    public int getCount() {
        return questions.size() + 1;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}