package com.schipala_ianko_radoslav.data.news.remote.mapper;

import com.schipala_ianko_radoslav.data.news.local.NewsReaderEntity;
import com.schipala_ianko_radoslav.data.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsEntityToArticle implements Function<List<NewsReaderEntity>, List<Article>> {

    @Override
    public List<Article> apply(List<NewsReaderEntity> articles) {
        List<Article> newsReaderEntities = new ArrayList<>();

        for (NewsReaderEntity article : articles) {
            Article newsReaderEntity = new Article(
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
