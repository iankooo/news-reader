package com.schipala_ianko_radoslav.newsreader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.schipala_ianko_radoslav.newsreader.databinding.NewsItemBinding;
import com.schipala_ianko_radoslav.newsreader.listener.NewsReaderHandler;
import com.schipala_ianko_radoslav.newsreader.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsReaderAdapter extends RecyclerView.Adapter<NewsReaderAdapter.ArticleViewHolder> {
    private List<ArticleItemViewModel> articleModelList;
    private NewsReaderHandler handler;

    public NewsReaderAdapter() {
        this.articleModelList = new ArrayList<>();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsItemBinding binder = NewsItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new ArticleViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.binding.setViewModel(articleModelList.get(position));
        holder.binding.setHandler(handler);
    }

    @Override
    public int getItemCount() {
        return articleModelList.size();
    }

    public void setItems(List<ArticleItemViewModel> items, NewsReaderHandler handler) {
        this.handler = handler;
        this.articleModelList = items;
        notifyDataSetChanged();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        final NewsItemBinding binding;

        public ArticleViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
