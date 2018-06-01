package com.github.rstockbridge.citizenship.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.github.rstockbridge.citizenship.R;

import java.util.ArrayList;
import java.util.List;

public class FavoritesStorage {

    private static final String PREF_FAVORITES = "favorites";
    private static String comma;
    private static String empty;

    private static FavoritesStorage favoritesStorage;

    private SharedPreferences sharedPreferences;

    public static void init(final Context context) {
        if (favoritesStorage == null) {
            favoritesStorage = new FavoritesStorage(context);
        }

        comma = context.getResources().getString(R.string.comma);
        empty = context.getResources().getString(R.string.empty);
    }

    private FavoritesStorage(final Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static FavoritesStorage getSharedInstance() {
        return favoritesStorage;
    }

    private String getIds() {
        return sharedPreferences.getString(PREF_FAVORITES, empty);
    }

    private void update(final String string) {
        sharedPreferences.edit().putString(PREF_FAVORITES, string).apply();
    }

    public void addToFavorites(final int id) {
        final String newIds = getIds() + id + comma;
        update(newIds);
    }

    public void removeFromFavorites(final int id) {
        final String newIds = getIds().replaceAll(id + comma, empty);
        update(newIds);
    }

    public boolean contains(final int id) {
        return getIds().contains(id + comma);
    }

    public int getSize() {
        if (getIds().length() > 0) {
            return getIds().split(comma).length;
        } else {
            return 0;
        }
    }

    public List<Question> getFavorites() {
        final List<Integer> favoritesById = new ArrayList<>();

        if (getIds().length() > 0) {
            final String[] splitIds = getIds().split(comma);

            for (final String id : splitIds) {
                favoritesById.add(Integer.valueOf(id));
            }
        }

        return QuestionBank.getSharedInstance().getQuestionsFromId(favoritesById);
    }
}
