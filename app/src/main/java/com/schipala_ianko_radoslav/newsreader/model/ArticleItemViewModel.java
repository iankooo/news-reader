package com.schipala_ianko_radoslav.newsreader.model;

public class ArticleItemViewModel {
    public final String title;
    public final String content;
    public final String imageURL;

    public ArticleItemViewModel(String title, String content, String imageURL) {
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }
}
