package com.github.rstockbridge.citizenship;

import android.app.Application;

import com.github.rstockbridge.citizenship.data.FavoritesStorage;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FavoritesStorage.init(this);
    }
}
