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

    private TextView answer;
    private Button answerButton;
    private Button nextButton;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_flashcard, container,false);

        answer = v.findViewById(R.id.answer);
        answerButton = v.findViewById(R.id.answer_button);
        nextButton = v.findViewById(R.id.next_button);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setTextColor(Color.WHITE);
                answerButton.setVisibility(View.GONE);
                nextButton.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }
}
