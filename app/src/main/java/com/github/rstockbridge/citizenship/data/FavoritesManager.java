package com.github.rstockbridge.citizenship.data;

import java.util.ArrayList;
import java.util.List;

public class FavoritesManager {

    private static FavoritesManager favoritesManager;

    private List<Integer> favorites;

    public static FavoritesManager getSharedInstance() {
        if (favoritesManager == null) {
            favoritesManager = new FavoritesManager();
        }
        return favoritesManager;
    }

    private FavoritesManager() {
        favorites = new ArrayList<>();
    }

    public List<Integer> getFavorites() {
        return new ArrayList<>(favorites);
    }

    public void addToFavorites(final int id) {
        favorites.add(id);
    }

    public void removeFromFavorites(final int id) {
        favorites.remove(favorites.indexOf(id));
    }

    public boolean contains(final int id) {
        return favorites.contains(id);
    }
}
