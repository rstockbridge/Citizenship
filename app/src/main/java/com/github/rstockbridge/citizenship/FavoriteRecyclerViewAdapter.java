package com.github.rstockbridge.citizenship;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.rstockbridge.citizenship.data.FavoritesStorage;
import com.github.rstockbridge.citizenship.data.Question;

import java.util.List;

public final class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.FavoriteHolder> {

    @NonNull
    private final Context context;

    @NonNull
    private final List<Question> questions;

    FavoriteRecyclerViewAdapter(
            @NonNull final Context context, @NonNull final List<Question> questions) {

        this.context = context;
        this.questions = questions;
    }

    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        return new FavoriteHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteHolder holder, final int position) {
        final Question question = questions.get(position);
        holder.bind(question);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    final class FavoriteHolder extends RecyclerView.ViewHolder {

        private final TextView questionLabel;
        private final ImageButton favoriteButton;

        FavoriteHolder(@NonNull final LayoutInflater inflater, @NonNull final ViewGroup parent) {

            super(inflater.inflate(R.layout.list_favorite, parent, false));

            questionLabel = itemView.findViewById(R.id.question_label_list);
            favoriteButton = itemView.findViewById(R.id.make_favorite_list);
        }

        void bind(@NonNull final Question question) {
            questionLabel.setText(question.getQuestionText());

            favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (questionIsFavorite(question)) {
                        FavoritesStorage.getSharedInstance().removeFromFavorites(question);
                    } else {
                        FavoritesStorage.getSharedInstance().addToFavorites(question);
                    }

                    syncFavoriteButton(question);
                }
            });

            syncFavoriteButton(question);
        }

        private void syncFavoriteButton(@NonNull final Question question) {
            favoriteButton.setSelected(questionIsFavorite(question));
        }

        private boolean questionIsFavorite(@NonNull final Question question) {
            return FavoritesStorage.getSharedInstance().contains(question);
        }
    }
}
