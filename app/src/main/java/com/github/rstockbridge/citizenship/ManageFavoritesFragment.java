package com.github.rstockbridge.citizenship;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rstockbridge.citizenship.data.Question;
import com.github.rstockbridge.citizenship.data.QuestionBank;

import java.util.List;

public class ManageFavoritesFragment extends Fragment {

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_manage_favorites, container, false);

        final List<Question> allQuestions = QuestionBank.getSharedInstance().getAllQuestions();

        final RecyclerView recyclerView = v.findViewById(R.id.favorites_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final FavoriteAdapter adapter = new FavoriteAdapter(this, allQuestions);
        recyclerView.setAdapter(adapter);

        return v;
    }
}
