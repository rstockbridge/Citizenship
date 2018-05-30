package com.github.rstockbridge.citizenship;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.rstockbridge.citizenship.data.Question;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteHolder> {
    private Fragment fragment;
    private List<Question> questions;

    FavoriteAdapter(final Fragment inputFragment, final List<Question> inputQuestions) {
        questions = inputQuestions;
        fragment = inputFragment;
    }

    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(fragment.getActivity());
        return new FavoriteHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteHolder holder, int position) {
        final Question question = questions.get(position);
        holder.bind(question);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
