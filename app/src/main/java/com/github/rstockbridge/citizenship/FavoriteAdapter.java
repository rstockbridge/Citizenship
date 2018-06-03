package com.github.rstockbridge.citizenship;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.rstockbridge.citizenship.data.FavoritesStorage;
import com.github.rstockbridge.citizenship.data.Question;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder> {
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

    class FavoriteHolder extends RecyclerView.ViewHolder {
        private TextView questionLabel;
        private ImageButton favoriteButton;

        FavoriteHolder(final LayoutInflater inflater, final ViewGroup parent) {
            super(inflater.inflate(R.layout.list_favorite, parent, false));

            questionLabel = itemView.findViewById(R.id.question_label_list);
            favoriteButton = itemView.findViewById(R.id.make_favorite_list);
        }

        void bind(final Question question) {
            Log.i("help", "id: " + question.getId() + "    question is favorite: " + questionIsFavorite(question));
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

        private void syncFavoriteButton(final Question question) {
            favoriteButton.setSelected(questionIsFavorite(question));
        }

        private boolean questionIsFavorite(final Question question) {
            return FavoritesStorage.getSharedInstance().contains(question);
        }
    }
}
