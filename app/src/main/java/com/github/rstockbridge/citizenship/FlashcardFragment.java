package com.github.rstockbridge.citizenship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FlashcardFragment extends Fragment {

    private static final String ARG_ON_LAST_FLASHCARD = "on_last_flashcard";
    private static final String ARG_QUESTION_TEXT = "question_text";
    private static final String ARG_ANSWER_TEXT = "answer_text";

    private TextView question;
    private TextView answer;
    private Button answerButton;
    private Button nextButton;
    private Button advanceButton;

    public static FlashcardFragment newInstance(final boolean onLastFlashcard, final String questionText, final String answerText) {
        final Bundle args = new Bundle();
        args.putBoolean(ARG_ON_LAST_FLASHCARD, onLastFlashcard);
        args.putString(ARG_QUESTION_TEXT, questionText);
        args.putString(ARG_ANSWER_TEXT, answerText);

        final FlashcardFragment fragment = new FlashcardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_flashcard, container, false);

        question = v.findViewById(R.id.question);
        question.setText(getArguments().getString(ARG_QUESTION_TEXT));

        answer = v.findViewById(R.id.answer);
        answer.setText(getArguments().getString(ARG_ANSWER_TEXT));

        answerButton = v.findViewById(R.id.answer_button);
        nextButton = v.findViewById(R.id.next_button);
        advanceButton = v.findViewById(R.id.advance_button);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setTextColor(Color.WHITE);
                answerButton.setVisibility(View.GONE);

                if (getArguments().getBoolean(ARG_ON_LAST_FLASHCARD)) {
                    advanceButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.GONE);
                } else {
                    advanceButton.setVisibility(View.GONE);
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        });

        return v;
    }
}
