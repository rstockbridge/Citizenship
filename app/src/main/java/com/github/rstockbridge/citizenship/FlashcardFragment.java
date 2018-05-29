package com.github.rstockbridge.citizenship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.rstockbridge.citizenship.data.Question;

public class FlashcardFragment extends Fragment implements View.OnClickListener {

    public interface OnNextQuestionClickListener {
        void onNextQuestionClick();
    }

    private static final String ARG_LAST_FLASHCARD = "last_flashcard";
    private static final String ARG_QUESTION = "question";

    private static final String SAVED_ANSWER_REVEALED = "answer_revealed";

    private OnNextQuestionClickListener listener;
    private String answer;
    private boolean answerRevealed;
    private boolean lastFlashcard;
    private TextView questionLabel;
    private TextView answerLabel;
    private Button actionButton;

    public static FlashcardFragment newInstance(final Question question, final boolean lastFlashcard) {
        final Bundle args = new Bundle();
        args.putBoolean(ARG_LAST_FLASHCARD, lastFlashcard);
        args.putParcelable(ARG_QUESTION, question);

        final FlashcardFragment fragment = new FlashcardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        try {
            listener = (OnNextQuestionClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnNextQuestionClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_flashcard, container, false);

        actionButton = v.findViewById(R.id.action_button);
        actionButton.setOnClickListener(this);

        questionLabel = v.findViewById(R.id.question_label);
        answerLabel = v.findViewById(R.id.answer_label);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lastFlashcard = getArguments().getBoolean(ARG_LAST_FLASHCARD);

        final Question question = getArguments().getParcelable(ARG_QUESTION);
        answer = question.getAnswerText();

        questionLabel.setText(question.getQuestionText());

        if (savedInstanceState != null && savedInstanceState.getBoolean(SAVED_ANSWER_REVEALED)) {
            revealAnswer();
        } else {
            actionButton.setText(getResources().getString(R.string.show_answer));
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_ANSWER_REVEALED, answerRevealed);
    }

    private void revealAnswer() {
        answerRevealed = true;
        answerLabel.setText(answer);
        actionButton.setText(lastFlashcard ? getResources().getString(R.string.advance) : getResources().getString(R.string.next_question));
    }

    @Override
    public void onClick(final View v) {
        if (answerRevealed) {
            listener.onNextQuestionClick();
        } else {
            revealAnswer();
        }
    }
}
