package com.github.rstockbridge.citizenship;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rstockbridge.citizenship.data.Question;
import com.github.rstockbridge.citizenship.data.QuestionBank;

import java.util.List;

public final class ManageFavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_favorites);

        final List<Question> allQuestions = QuestionBank.getSharedInstance().getAllQuestions();

        final RecyclerView recyclerView = findViewById(R.id.favorites_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final FavoriteRecyclerViewAdapter adapter = new FavoriteRecyclerViewAdapter(this, allQuestions);
        recyclerView.setAdapter(adapter);

        setTitle(getString(R.string.manage_favorites));
    }
}
