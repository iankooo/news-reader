package com.schipala_ianko_radoslav.data;

import androidx.annotation.NonNull;

import com.schipala_ianko_radoslav.data.news.local.NewsReaderEntity;
import com.schipala_ianko_radoslav.data.news.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface NewsRepository {
    @NotNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Single<List<Article>> getNewsReaderList();

    @NonNull
    Single<NewsReaderEntity> getNewsReaderItem(int itemId);

    @NonNull
    Completable saveNewsReaderItem(NewsReaderEntity newsReaders);

    @NonNull
    Completable deleteItem(int itemId);
}
