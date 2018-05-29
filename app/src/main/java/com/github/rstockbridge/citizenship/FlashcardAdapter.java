package com.github.rstockbridge.citizenship;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.rstockbridge.citizenship.data.Question;

import java.util.List;


public class FlashcardAdapter extends FragmentStatePagerAdapter {

    private List<Question> questions;

    public FlashcardAdapter(
            @NonNull final FragmentManager fragmentManager,
            final List<Question> inputQuestions) {
        super(fragmentManager);

        questions = inputQuestions;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < getCount() - 1) {
            final boolean lastFlashcard = position == getCount() - 2;
            return FlashcardFragment.newInstance(questions.get(position), lastFlashcard);
        } else {
            return new CompletedFragment();
        }
    }

    @Override
    public int getCount() {
        return questions.size() + 1;
    }
}