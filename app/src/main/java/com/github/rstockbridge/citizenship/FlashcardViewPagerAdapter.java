package com.github.rstockbridge.citizenship;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.github.rstockbridge.citizenship.data.Question;

import java.util.List;


public final class FlashcardViewPagerAdapter extends FragmentStatePagerAdapter {

    @NonNull
    private final List<Question> questions;

    private final boolean isFavoritesPractice;

    FlashcardViewPagerAdapter(
            @NonNull final FragmentManager fragmentManager,
            @NonNull final List<Question> questions,
            final boolean isFavoritesPractice) {

        super(fragmentManager);

        this.questions = questions;
        this.isFavoritesPractice = isFavoritesPractice;
    }

    @Override
    public Fragment getItem(final int position) {
        if (position < getCount() - 1) {
            final boolean isLastFlashcard = position == getCount() - 2;
            return FlashcardFragment.newInstance(questions.get(position), isLastFlashcard, isFavoritesPractice);
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
