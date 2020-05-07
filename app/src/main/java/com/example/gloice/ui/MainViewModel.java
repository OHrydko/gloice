package com.example.gloice.ui;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gloice.model.Data;
import com.example.gloice.model.Movie;
import com.example.gloice.repository.Repository;

public class MainViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<Movie> currentMovie = new MutableLiveData<>();
    private SharedPreferences sharedPreferences;

    void init(FragmentActivity activity) {
        sharedPreferences = activity.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        repository = new Repository();
    }

    MutableLiveData<Data> getAllData(int page) {
        boolean isInternet = sharedPreferences.getBoolean("isInternet",false);
        return (isInternet) ? repository.getMovies(page) : repository.getMoviesFromDB(page);
    }

    MutableLiveData<Movie> getCurrentMovie() {
        return currentMovie;
    }

    void setCurrentMovie(Movie currentMovie) {
        this.currentMovie.setValue(currentMovie);
    }
}
