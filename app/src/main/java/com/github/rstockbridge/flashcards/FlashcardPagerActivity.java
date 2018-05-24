package com.github.rstockbridge.flashcards;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FlashcardPagerActivity extends AppCompatActivity {

    private static final String EXTRA_PRACTICE_LENGTH = "com.github.rstockbridge.flashcards.practice_length";

    private NonSwipeableViewPager viewPager;

    public static Intent newIntent(final Context context, final int practiceLength) {
        final Intent intent = new Intent(context, FlashcardPagerActivity.class);
        intent.putExtra(EXTRA_PRACTICE_LENGTH, practiceLength);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        viewPager = findViewById(R.id.flashcard_view_pager);

        final FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return new FlashcardFragment();
            }

            @Override
            public int getCount() {
                return getIntent().getIntExtra(EXTRA_PRACTICE_LENGTH, 0);
            }
        });
    }

    public void jumpToPage(final View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }
}
