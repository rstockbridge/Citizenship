package com.github.rstockbridge.flashcards;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlashcardPagerActivity extends AppCompatActivity {

    private static final String EXTRA_PRACTICE_LENGTH = "com.github.rstockbridge.flashcards.practice_length";

    private QuestionBank questionBank;

    private int practiceLength;

    private List<Integer> randomizedOrder;

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

        questionBank = QuestionBank.get();
        practiceLength = getIntent().getIntExtra(EXTRA_PRACTICE_LENGTH, 0);

        randomizeOrder();

        viewPager = findViewById(R.id.flashcard_view_pager);

        final FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                if (position < practiceLength) {
                    final int index = getQuestionIndex(position);
                    return FlashcardFragment.newInstance(position == practiceLength - 1, questionBank.getQuestionText(index), questionBank.getAnswerText(index));
                } else {
                    return new CompletedFragment();
                }
            }

            @Override
            public int getCount() {
                return practiceLength + 1;
            }
        });

        setTitle("Page " + (viewPager.getCurrentItem() + 1) + " of " + practiceLength);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // this method intentionally left blank
            }

            @Override
            public void onPageSelected(int position) {
                if (position < practiceLength) {
                    setTitle(getResources().getString(R.string.page_title, position + 1, practiceLength));
                } else {
                    setTitle(getResources().getString(R.string.complete_title));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // this method intentionally left blank
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() < practiceLength) {
            showAlertDialogButton();
        } else {
            finish();
        }
    }

    public void showAlertDialogButton() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_exit);
        builder.setMessage(R.string.exit_message);

        builder.setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int id) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, null);

        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void jumpToPage(final View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    private void randomizeOrder() {
        randomizedOrder = new ArrayList<>();
        for (int i = 0; i < questionBank.getSize(); i++) {
            randomizedOrder.add(i);
        }
        Collections.shuffle(randomizedOrder);
    }

    private int getQuestionIndex(final int position) {
        return randomizedOrder.get(position);
    }
}
