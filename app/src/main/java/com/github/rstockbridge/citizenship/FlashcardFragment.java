package com.github.rstockbridge.citizenship;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.rstockbridge.citizenship.data.FavoritesStorage;
import com.github.rstockbridge.citizenship.data.Question;

public final class FlashcardFragment
        extends Fragment
        implements View.OnClickListener {

    public interface OnNextQuestionClickListener {
        void onNextQuestionClick();
    }

    public interface OnRemoveFavoriteListener {
        void onRemoveFavorite(final int id);
    }

    private static final String ARG_QUESTION = "question";
    private static final String ARG_LAST_FLASHCARD = "last_flashcard";
    private static final String ARG_FAVORITES_PRACTICE = "favorites_practice";

    private static final String SAVED_ANSWER_REVEALED = "answer_revealed";
    private static final String SAVED_DIALOG_VISIBLE = "dialog_visible";

    private OnNextQuestionClickListener nextQuestionListener;
    private OnRemoveFavoriteListener removeFavoriteListener;

    @NonNull
    private Question question;

    @NonNull
    private String answer;

    private boolean answerRevealed;
    private boolean lastFlashcard;

    private TextView answerLabel;
    private Button actionButton;
    private FloatingActionButton favoriteButton;

    private boolean favoritesPractice;

    private AlertDialog dialog;

    public static FlashcardFragment newInstance(
            @NonNull final Question question,
            final boolean lastFlashcard,
            final boolean favoritesPractice) {

        final Bundle args = new Bundle();
        args.putParcelable(ARG_QUESTION, question);
        args.putBoolean(ARG_LAST_FLASHCARD, lastFlashcard);
        args.putBoolean(ARG_FAVORITES_PRACTICE, favoritesPractice);

        final FlashcardFragment fragment = new FlashcardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);

        try {
            nextQuestionListener = (OnNextQuestionClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnNextQuestionClickListener");
        }

        try {
            removeFavoriteListener = (OnRemoveFavoriteListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnRemoveFavoriteListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_flashcard, container, false);

        favoritesPractice = getArguments().getBoolean(ARG_FAVORITES_PRACTICE);
        lastFlashcard = getArguments().getBoolean(ARG_LAST_FLASHCARD);
        question = getArguments().getParcelable(ARG_QUESTION);
        answer = question.getAnswerText();

        setupUI(v);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(SAVED_ANSWER_REVEALED)) {
                revealAnswer();
            }

            if (savedInstanceState.getBoolean(SAVED_DIALOG_VISIBLE)) {
                showAlertDialog();
            }
        } else {
            actionButton.setText(getResources().getString(R.string.show_answer));
        }

        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(SAVED_ANSWER_REVEALED, answerRevealed);

        if (dialog != null) {
            outState.putBoolean(SAVED_DIALOG_VISIBLE, dialog.isShowing());
        }
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.action_button:
                if (answerRevealed) {
                    nextQuestionListener.onNextQuestionClick();
                } else {
                    revealAnswer();
                }
                break;

            case R.id.fab_make_favorite:
                if (favoritesPractice) {
                    showAlertDialog();
                } else {
                    if (questionIsFavorite()) {
                        FavoritesStorage.getSharedInstance().removeFromFavorites(question);
                    } else {
                        FavoritesStorage.getSharedInstance().addToFavorites(question);
                    }

                    syncFavoriteButton();
                }
                break;

            default:
                throw new IllegalStateException("This line should never be reached.");
        }
    }

    private void revealAnswer() {
        answerRevealed = true;
        answerLabel.setText(answer);
        actionButton.setText(lastFlashcard ? getResources().getString(R.string.advance) : getResources().getString(R.string.next_question));
    }

    private void setupUI(@NonNull final View v) {
        actionButton = v.findViewById(R.id.action_button);
        actionButton.setOnClickListener(this);

        final TextView questionLabel = v.findViewById(R.id.question_label);
        questionLabel.setText(question.getQuestionText());

        answerLabel = v.findViewById(R.id.answer_label);

        favoriteButton = v.findViewById(R.id.fab_make_favorite);
        favoriteButton.setOnClickListener(this);
        syncFavoriteButton();
    }

    private void syncFavoriteButton() {
        favoriteButton.setSelected(questionIsFavorite());
    }

    private boolean questionIsFavorite() {
        return FavoritesStorage.getSharedInstance().contains(question);
    }

    private void removeFromFavoritesPractice() {
        removeFavoriteListener.onRemoveFavorite(question.getId());
        FavoritesStorage.getSharedInstance().removeFromFavorites(question);
    }

    private void showAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.confirm_removal);
        builder.setMessage(R.string.removal_message);

        builder.setPositiveButton(R.string.remove, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int id) {
                removeFromFavoritesPractice();
            }
        });
        builder.setNegativeButton(R.string.cancel, null);

        dialog = builder.create();
        dialog.show();
    }
}

