package com.schipala_ianko_radoslav.newsreader;

import android.app.Application;

import com.schipala_ianko_radoslav.data.di.RepoModule;

public class NewsReaderApplication extends Application {

    private static RepoModule repoModule;

    public static RepoModule getRepoProvider() {
        return repoModule;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.repoModule = new RepoModule(this);
    }
}
