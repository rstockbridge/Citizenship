package com.github.rstockbridge.citizenship;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ManageFavoritesActivity extends AppCompatActivity {

    public static void start(final Context context) {
        final Intent intent = new Intent(context, ManageFavoritesActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_favorites);

        final FragmentManager fm = getSupportFragmentManager();
        final Fragment fragment = fm.findFragmentById(R.id.favorites_container);

        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.favorites_container, new ManageFavoritesFragment())
                    .commit();
        }

        setTitle(getString(R.string.manage_favorites));
    }
}
