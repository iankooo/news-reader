package com.schipala_ianko_radoslav.newsreader.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.schipala_ianko_radoslav.newsreader.databinding.NewsListFragmentBinding;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model.NewsReaderViewModel;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.model.factory.ViewModelFactory;
import com.schipala_ianko_radoslav.newsreader.feature.newsreaderlist.navigator.AlertNavigator;

public class NewsListFragment extends Fragment {

    private NewsReaderViewModel viewModel;
    private AlertNavigator alertNavigator;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());

        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsReaderViewModel.class);
        viewModel.error.observe(this, throwable -> alertNavigator.showErrorFor(throwable));
        viewModel.openLink.observe(this, link -> openLink(link));

        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }
}