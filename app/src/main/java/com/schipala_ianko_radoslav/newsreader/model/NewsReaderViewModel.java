package com.schipala_ianko_radoslav.newsreader.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.schipala_ianko_radoslav.newsreader.listener.NewsReaderHandler;

public class NewsReaderViewModel extends ViewModel implements LifecycleObserver, NewsReaderHandler {

    private static final String TAG = NewsReaderViewModel.class.getName();

    @NonNull
    public final ObservableList<ArticleItemViewModel> items;

    public NewsReaderViewModel() {
        super();
        this.items = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void fetchNewsList() {
        Log.d(TAG, "fetchToDoList()");
        if (items.isEmpty()) {
            items.add(new ArticleItemViewModel("Title1", "Content1Content1Content1Content1Content1Content1Content1Content1Content1", "https://cdn.pixabay.com/photo/2015/03/26/09/47/sky-690293__340.jpg"));
            items.add(new ArticleItemViewModel("Title2", "Content2Content2Content2Content2Content2Content2Content2Content2Content2", "https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg"));
            items.add(new ArticleItemViewModel("Title3", "Content3Content3Content3Content3Content3Content3Content3Content3Content3", "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg"));
            items.add(new ArticleItemViewModel("Title4", "ContentContentContentContentContentContentContentContentContentContent", "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg"));
            items.add(new ArticleItemViewModel("Title5", "ContentContentContentContentContentContentContentContentContentContent", "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg"));
            items.add(new ArticleItemViewModel("Title6", "ContentContentContentContentContentContentContentContentContentContent", "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg"));
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {
    }
}
