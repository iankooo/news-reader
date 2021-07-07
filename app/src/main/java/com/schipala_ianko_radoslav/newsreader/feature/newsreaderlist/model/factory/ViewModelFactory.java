package com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model.factory;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.schipala_ianko_radoslav.data.NewsRepository;
import com.schipala_ianko_radoslav.newsreader.NewsReaderApplication;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model.NewsReaderViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsReaderViewModel.class)) {
            NewsRepository repo = NewsReaderApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsReaderViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}