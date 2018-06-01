package com.github.rstockbridge.citizenship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.rstockbridge.citizenship.data.FavoritesStorage;
import com.github.rstockbridge.citizenship.data.Question;

class FavoriteHolder extends RecyclerView.ViewHolder {
    private TextView questionLabel;
    private ImageButton favoriteButton;

    FavoriteHolder(final LayoutInflater inflater, final ViewGroup parent) {
        super(inflater.inflate(R.layout.list_favorite, parent, false));

        questionLabel = itemView.findViewById(R.id.question_label_list);
        favoriteButton = itemView.findViewById(R.id.make_favorite_list);
    }

    public void bind(final Question question) {
        questionLabel.setText(question.getQuestionText());

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionIsFavorite(question)) {
                    FavoritesStorage.getSharedInstance().removeFromFavorites(question.getId());
                } else {
                    FavoritesStorage.getSharedInstance().addToFavorites(question.getId());
                }

                syncFavoriteButton(question);
            }
        });

        syncFavoriteButton(question);
    }

    private void syncFavoriteButton(final Question question) {
        favoriteButton.setImageResource(questionIsFavorite(question) ? R.drawable.ic_favorite_filled : R.drawable.ic_favorite_border);
    }

    private boolean questionIsFavorite(final Question question) {
        return FavoritesStorage.getSharedInstance().contains(question.getId());
    }
}