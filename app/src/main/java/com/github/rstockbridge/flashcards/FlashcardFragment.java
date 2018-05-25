package com.github.rstockbridge.flashcards;

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

    private static final String ARG_PRACTICE_LENGTH = "practice_length";
    private static final String ARG_POSITION = "position";

    private int position;
    private int practiceLength;

    private TextView answer;
    private Button answerButton;
    private Button nextButton;
    private Button advanceButton;

    public static FlashcardFragment newInstance(final int position, final int practiceLength) {
        final Bundle args = new Bundle();
        args.putInt(ARG_PRACTICE_LENGTH, practiceLength);
        args.putInt(ARG_POSITION, position);

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

        practiceLength = getArguments().getInt(ARG_PRACTICE_LENGTH);
        position = getArguments().getInt(ARG_POSITION);

        answer = v.findViewById(R.id.answer);
        answerButton = v.findViewById(R.id.answer_button);
        nextButton = v.findViewById(R.id.next_button);
        advanceButton = v.findViewById(R.id.advance_button);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setTextColor(Color.WHITE);
                answerButton.setVisibility(View.GONE);

                if (position < practiceLength - 1) {
                    advanceButton.setVisibility(View.GONE);
                    nextButton.setVisibility(View.VISIBLE);
                } else {
                    advanceButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.GONE);
                }
            }
        });

        return v;
    }
}
