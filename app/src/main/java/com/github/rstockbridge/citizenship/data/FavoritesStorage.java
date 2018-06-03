package com.github.rstockbridge.citizenship.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class FavoritesStorage {

    private static final String PREF_FAVORITES = "favorites";

    private static FavoritesStorage favoritesStorage;

    private SharedPreferences sharedPreferences;

    public static void init(final Context context) {
        if (favoritesStorage == null) {
            favoritesStorage = new FavoritesStorage(context);
        }
    }

    private FavoritesStorage(final Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static FavoritesStorage getSharedInstance() {
        return favoritesStorage;
    }

    private String getIds() {
        return sharedPreferences.getString(PREF_FAVORITES, "");
    }

    private void update(final List<Integer> ids) {
        String string = "";

        for (final int id : ids) {
            string += id + ",";
        }

        sharedPreferences.edit().putString(PREF_FAVORITES, string).apply();
    }

    public void addToFavorites(final Question question) {
        final List<Integer> favoritesById = new ArrayList<>(getFavoritesById());
        favoritesById.add(question.getId());
        update(favoritesById);
    }

    public void removeFromFavorites(final Question question) {
        final List<Integer> favoritesById = new ArrayList<>(getFavoritesById());
        favoritesById.remove(favoritesById.indexOf(question.getId()));
        update(favoritesById);
    }

    public boolean contains(final Question question) {
        for (final Question testQuestion : getFavorites()) {
            if (testQuestion.getId() == question.getId()) {
                return true;
            }
        }

        return false;
    }

    public int getSize() {
        return getFavorites().size();
    }

    public List<Question> getFavorites() {
        return QuestionBank.getSharedInstance().getQuestionsFromId(getFavoritesById());
    }

    private List<Integer> getFavoritesById() {
        final List<Integer> favoritesById = new ArrayList<>();

        if (getIds().length() > 0) {
            final String[] splitIds = getIds().split(",");

            for (final String id : splitIds) {
                favoritesById.add(Integer.valueOf(id));
            }
        }

        return favoritesById;
    }
}
