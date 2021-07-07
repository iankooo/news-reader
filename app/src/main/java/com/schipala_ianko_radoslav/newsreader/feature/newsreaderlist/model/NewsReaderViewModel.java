package com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.schipala_ianko_radoslav.data.NewsRepository;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.listener.NewsReaderHandler;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model.mapper.ArticlesToVMListMapper;
import com.schipala_ianko_radoslav.newsreader.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsReaderViewModel extends AndroidViewModel implements LifecycleObserver, NewsReaderHandler {

    private final static String LINK = "https://newsapi.org/";
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    private final NewsRepository repo;

    @NonNull
    public ObservableList<ArticleItemViewModel> items;

    public NewsReaderViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
        this.items = new ObservableArrayList<>();
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        isLoading.set(true);
        repo.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(List<ArticleItemViewModel> articles) {
        this.items.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {
    }
}
