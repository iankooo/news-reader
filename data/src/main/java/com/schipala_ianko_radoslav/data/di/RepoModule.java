package com.schipala_ianko_radoslav.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.schipala_ianko_radoslav.data.NewsRepository;
import com.schipala_ianko_radoslav.data.news.NewsRepositoryImpl;
import com.schipala_ianko_radoslav.data.news.local.NewsReaderLocalSource;
import com.schipala_ianko_radoslav.data.news.remote.NewsRemoteSource;
import com.schipala_ianko_radoslav.data.remote.HttpClientFactory;
import com.schipala_ianko_radoslav.data.store.local.NewsReaderDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;

    private volatile NewsReaderDatabase database;

    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideLocalSource(), provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsReaderLocalSource provideLocalSource() {
        NewsReaderDatabase database = getInstance();
        return new NewsReaderLocalSource(database.newsReaderDao());
    }

    NewsReaderDatabase getInstance() {
        if (database == null) {
            synchronized (NewsReaderDatabase.class) {
                if (database == null)
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsReaderDatabase.class,
                            "news.db")
                            .build();
            }
        }
        return database;
    }

}
