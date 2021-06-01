package com.schipala_ianko_radoslav.newsreader.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = NewsListViewModel.class.getName();

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList;

    public NewsListViewModel() {
        super();
        newsList = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void fetchNewsList() {
        Log.d(TAG, "fetchToDoList()");
        if (newsList.isEmpty()) {
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());

        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
