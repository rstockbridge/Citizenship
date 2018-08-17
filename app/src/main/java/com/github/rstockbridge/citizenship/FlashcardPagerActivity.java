package com.github.rstockbridge.citizenship;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.rstockbridge.citizenship.data.Question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FlashcardPagerActivity
        extends AppCompatActivity
        implements FlashcardFragment.OnNextQuestionClickListener, FlashcardFragment.OnRemoveFavoriteListener {

    private static final String EXTRA_QUESTIONS = "questions";
    private static final String EXTRA_FAVORITES_PRACTICE = "enable_favorites";
    private static final String SAVED_DIALOG_VISIBLE = "dialog_visible";

    private boolean favoritesPractice;
    private List<Question> questions;

    private NonSwipeableViewPager viewPager;
    private FlashcardAdapter adapter;

    private AlertDialog dialog;

    public static void start(
            @NonNull final Context context,
            @NonNull final ArrayList<Question> questions,
            final boolean favoritesPractice) {

        final Intent intent = new Intent(context, FlashcardPagerActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_QUESTIONS, questions);
        intent.putExtra(EXTRA_FAVORITES_PRACTICE, favoritesPractice);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        enableUpButton();

        questions = getIntent().getParcelableArrayListExtra(EXTRA_QUESTIONS);
        favoritesPractice = getIntent().getBooleanExtra(EXTRA_FAVORITES_PRACTICE, false);

        viewPager = findViewById(R.id.flashcard_view_pager);
        adapter = new FlashcardAdapter(getSupportFragmentManager(), questions, favoritesPractice);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // this method intentionally left blank
            }

            @Override
            public void onPageSelected(int position) {
                updateScreenTitle();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // this method intentionally left blank
            }
        });

        updateScreenTitle();

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(SAVED_DIALOG_VISIBLE)) {
                showAlertDialog();
            }
        }
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
        if (viewPager.getCurrentItem() < adapter.getCount() - 1) {
            showAlertDialog();
        } else {
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        if (dialog != null) {
            outState.putBoolean(SAVED_DIALOG_VISIBLE, dialog.isShowing());
        }
    }

    @Override
    public void onNextQuestionClick() {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    @Override
    public void onRemoveFavorite(final int questionId) {
        if (favoritesPractice) {
            final int currentPage = viewPager.getCurrentItem();
            viewPager.setAdapter(null);

            final Iterator<Question> iterator = questions.iterator();

            while (iterator.hasNext()) {
                final Question question = iterator.next();
                if (question.getId() == questionId) {
                    iterator.remove();
                    break;
                }
            }

            adapter = new FlashcardAdapter(getSupportFragmentManager(), questions, favoritesPractice);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(currentPage);
            updateScreenTitle();
        }
    }

    public void showAlertDialog() {
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

        dialog = builder.create();
        dialog.show();
    }

    private void enableUpButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void updateScreenTitle() {
        setTitle(onFlashcard() ? getResources().getString(R.string.page_title, (viewPager.getCurrentItem() + 1), adapter.getCount() - 1) : getResources().getString(R.string.complete_title));
    }

    private boolean onFlashcard() {
        return viewPager.getCurrentItem() < adapter.getCount() - 1;
    }
}
