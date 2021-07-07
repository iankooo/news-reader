package com.schipala_ianko_radoslav.data.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class NewsReaderEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String imageUrl;

    public String title;

    public String content;

    public String description;

    public NewsReaderEntity(String imageUrl, String title, String content, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
