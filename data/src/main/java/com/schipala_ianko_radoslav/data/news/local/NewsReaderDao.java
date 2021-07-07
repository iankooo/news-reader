package com.schipala_ianko_radoslav.data.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface NewsReaderDao {

    @Query("SELECT * FROM news")
    Single<List<NewsReaderEntity>> queryNewsReaders();

    @Query("SELECT * FROM news where id= :id")
    Single<NewsReaderEntity> queryNewsReaderItem(int id);

    @Query("DELETE FROM news where id=:id")
    Completable deleteNewsReaderItem(int id);

    @Query("DELETE FROM news")
    Completable deleteAllNewsReaders();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertNewsReaders(List<NewsReaderEntity> todos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertNewsReader(NewsReaderEntity todo);

    @Query("UPDATE news SET title = :title, content = :content, imageURL = :imageURL where id=:id")
    Completable updateProfile(String title, String content, String imageURL, int id);

}
