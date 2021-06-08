package com.schipala_ianko_radoslav.data.news;

import com.schipala_ianko_radoslav.data.NewsRepository;
import com.schipala_ianko_radoslav.data.news.model.Article;
import com.schipala_ianko_radoslav.data.news.remote.NewsRemoteSource;
import com.schipala_ianko_radoslav.data.news.remote.mapper.NewsDtoToNewsMapper;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());
    }

}
