package com.example.gloice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloice.R;
import com.example.gloice.databinding.ItemBinding;
import com.example.gloice.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private OnItemClick onItemClick;

    public MovieAdapter(List<Movie> movies, OnItemClick onItemClick) {
        this.movies = movies;
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void onClick(Movie movie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.itemBinding.name.setText(movie.getTitle());
        String url = "https://image.tmdb.org/t/p/w500";
        Picasso.get()
                .load(url + movie.getPosterPath())
                .into(holder.itemBinding.image);
        holder.itemBinding.container.setOnClickListener(v -> onItemClick.onClick(movie));
        holder.itemBinding.ratingBarIndicator.setRating(movie.getVoteAverage().floatValue());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;

        MovieViewHolder(@NonNull ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
