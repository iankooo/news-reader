package com.schipala_ianko_radoslav.newsreader.model;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {
    public final ObservableField<String> title;
    public final ObservableField<String> content;
    public final String image;
    @Nullable
    public Integer id;

    public ArticleItemViewModel() {
        this.title = new ObservableField<>();
        this.content = new ObservableField<>();
        image = "https://cdn.pixabay.com/photo/2015/03/26/09/47/sky-690293__340.jpg";
        //this.image = new ObservableField<>();
    }
}
