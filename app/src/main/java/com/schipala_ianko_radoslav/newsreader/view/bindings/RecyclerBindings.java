package com.schipala_ianko_radoslav.newsreader.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.adapter.NewsReaderAdapter;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.listener.NewsReaderHandler;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {
    @BindingAdapter({"items", "handler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles, NewsReaderHandler handler) {
        NewsReaderAdapter readerAdapter = (NewsReaderAdapter) recyclerView.getAdapter();

        if (readerAdapter == null) {
            readerAdapter = new NewsReaderAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(readerAdapter);
        }

        readerAdapter.setItems(articles, handler);
    }
}
