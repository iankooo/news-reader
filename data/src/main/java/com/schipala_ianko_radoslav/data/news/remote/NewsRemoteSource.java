package com.schipala_ianko_radoslav.data.news.remote;

import com.schipala_ianko_radoslav.data.news.remote.model.ArticleListDto;
import com.schipala_ianko_radoslav.data.remote.NewsApi;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    private static final String API_KEY = "918642e7154a4b6a8ebb43b20502d61e";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<ArticleListDto> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io());
    }

}
