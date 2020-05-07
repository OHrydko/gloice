package com.example.gloice.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloice.load_more.LoadMoreItemsRV;
import com.example.gloice.R;
import com.example.gloice.adapter.MovieAdapter;
import com.example.gloice.databinding.FragmentMainBinding;
import com.example.gloice.model.Movie;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class MainFragment extends Fragment implements MovieAdapter.OnItemClick {
    private MainViewModel viewModel;
    private FragmentActivity activity;
    private MovieAdapter adapter;
    private int currentPage;
    private int total;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_main, container, false);
        viewModel = new ViewModelProvider(activity).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        viewModel.init(activity);
        currentPage = 1;
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setHasFixedSize(true);
        adapter = new MovieAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);
        getMovies();
        LoadMoreItemsRV loadMoreItemsRV = new LoadMoreItemsRV(5);
        loadMoreItemsRV.setView(recyclerView);
        loadMoreItemsRV.setLoadMore(() -> {
            if (currentPage < total) {
                viewModel.getAllData(currentPage);
            }
        });
        return binding.getRoot();
    }

    private void getMovies() {
        viewModel.getAllData(currentPage).observe(activity, movies -> {
            if (movies != null) {
                adapter.setMovies(movies.getResults());
                total = movies.getTotalPages();
                currentPage = movies.getPage() + 1;

            }
        });
    }


    @Override
    public void onClick(Movie movie) {
        viewModel.setCurrentMovie(movie);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new ContentFragment())
                .addToBackStack(null)
                .commit();
    }
}
