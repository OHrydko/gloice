package com.example.gloice.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gloice.R;
import com.example.gloice.databinding.FragmentContentBinding;
import com.example.gloice.model.Movie;
import com.example.gloice.utils.PicassoTransformation;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;


public class ContentFragment extends Fragment {
    private FragmentActivity activity;


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
        MainViewModel viewModel = new ViewModelProvider(activity).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        Movie movie = viewModel.getCurrentMovie().getValue();
        if (movie != null) {
            updateUI(movie, binding);
        }
        return binding.getRoot();
    }

    private void updateUI(Movie movie, FragmentContentBinding binding) {
        String url = "https://image.tmdb.org/t/p/w500";
        Picasso.get().load(url+movie.getPosterPath())
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .transform(new PicassoTransformation(activity, binding.image))
                .into(binding.image);
        binding.title.setText(movie.getTitle());
        binding.overview.setText(movie.getOverview());
        binding.count.setText(String.valueOf(movie.getVoteAverage()));
        binding.ratingBarIndicator.setRating(movie.getVoteAverage().floatValue());

    }
}
