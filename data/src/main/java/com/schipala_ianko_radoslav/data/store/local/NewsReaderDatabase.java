package com.schipala_ianko_radoslav.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.schipala_ianko_radoslav.data.news.local.NewsReaderDao;
import com.schipala_ianko_radoslav.data.news.local.NewsReaderEntity;

@Database(entities = {NewsReaderEntity.class}, version = 1)
public abstract class NewsReaderDatabase extends RoomDatabase {

    public abstract NewsReaderDao newsReaderDao();

}
