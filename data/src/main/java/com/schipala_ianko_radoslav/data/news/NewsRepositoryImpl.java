package com.schipala_ianko_radoslav.data.news;

import com.schipala_ianko_radoslav.data.NewsRepository;
import com.schipala_ianko_radoslav.data.news.local.NewsReaderEntity;
import com.schipala_ianko_radoslav.data.news.local.NewsReaderLocalSource;
import com.schipala_ianko_radoslav.data.news.model.Article;
import com.schipala_ianko_radoslav.data.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRepositoryImpl implements NewsRepository {

    private static final String TAG = NewsRepositoryImpl.class.getName();

    private final NewsReaderLocalSource newsReaderLocalSource;

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsReaderLocalSource newsReaderLocalSource, NewsRemoteSource remoteSource) {
        this.newsReaderLocalSource = newsReaderLocalSource;
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(newsReaderLocalSource::saveArticles)
                .onErrorResumeNext(newsReaderLocalSource.getNewsReaderList());
    }

    @androidx.annotation.NonNull
    @Override
    public Single<List<Article>> getNewsReaderList() {
        return newsReaderLocalSource.getNewsReaderList()
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Completable saveNewsReaderItem(NewsReaderEntity newsReaderEntity) {
        return newsReaderLocalSource.saveArticle(newsReaderEntity)
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Completable deleteItem(int itemId) {
        return newsReaderLocalSource.deleteNewsReaderItem(itemId)
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Single<NewsReaderEntity> getNewsReaderItem(int itemId) {
        return newsReaderLocalSource.getNewsReaderItem(itemId)
                .subscribeOn(Schedulers.io());
    }
}
