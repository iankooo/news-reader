package com.schipala_ianko_radoslav.data.news.remote.mapper;

import com.schipala_ianko_radoslav.data.news.local.NewsReaderEntity;
import com.schipala_ianko_radoslav.data.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsArticlesToEntity implements Function<List<Article>, List<NewsReaderEntity>> {

    @Override
    public List<NewsReaderEntity> apply(List<Article> articles) {
        List<NewsReaderEntity> newsReaderEntities = new ArrayList<>();

        for (Article article : articles) {
            NewsReaderEntity newsReaderEntity = new NewsReaderEntity(
                    article.imageUrl != null ? article.imageUrl : "", //Adding default values for business model
                    article.title != null ? article.title : "",
                    article.content != null ? article.content : "",
                    article.description != null ? article.description : ""
            );

            newsReaderEntities.add(newsReaderEntity);
        }

        return newsReaderEntities;
    }
}
