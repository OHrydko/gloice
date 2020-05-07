package com.example.gloice.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gloice.R;
import com.example.gloice.databinding.FragmentContentBinding;
import com.example.gloice.model.Movie;
import com.google.android.material.appbar.AppBarLayout;

import org.jetbrains.annotations.NotNull;


public class ContentFragment extends Fragment {
    private FragmentActivity activity;
    private MainViewModel viewModel;
    private Menu collapsedMenu;
    private boolean appBarExpanded = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentContentBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_content, container, false);
        viewModel = new ViewModelProvider(activity).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        Movie movie = viewModel.getCurrentMovie().getValue();
        return binding.getRoot();
    }

}
