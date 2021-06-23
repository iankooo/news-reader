package com.schipala_ianko_radoslav.data.news.local;

import com.schipala_ianko_radoslav.data.news.model.Article;
import com.schipala_ianko_radoslav.data.news.remote.mapper.NewsArticlesToEntity;
import com.schipala_ianko_radoslav.data.news.remote.mapper.NewsEntityToArticle;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsReaderLocalSource {

    private NewsReaderDao dao;

    public NewsReaderLocalSource(NewsReaderDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getNewsReaderList() {
        return dao.queryNewsReaders().map(new NewsEntityToArticle());
    }

    public Single<NewsReaderEntity> getNewsReaderItem(int id) {
        return dao.queryNewsReaderItem(id);
    }

    public Completable deleteNewsReaderItem(int id) {
        return dao.deleteNewsReaderItem(id);
    }

    public Completable saveArticle(NewsReaderEntity newsReaderEntity) {
        if (newsReaderEntity.id == null) {
            return dao.insertNewsReader(newsReaderEntity);
        } else {
            return dao.updateProfile(newsReaderEntity.title, newsReaderEntity.content, newsReaderEntity.imageUrl, newsReaderEntity.id);
        }
    }

    public void saveArticles(List<Article> articles) throws Exception {
        Single.just(articles).map(new NewsArticlesToEntity())
                .flatMapCompletable((newsReaderEntities -> dao.insertNewsReaders(newsReaderEntities)))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

}
