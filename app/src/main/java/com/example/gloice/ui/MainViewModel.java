package com.example.gloice.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gloice.model.Data;
import com.example.gloice.model.Movie;
import com.example.gloice.repository.Repository;

public class MainViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<Movie> currentMovie = new MutableLiveData<>();

    void init() {
        repository = new Repository();
    }

    MutableLiveData<Data> getAllData(int page) {
        return repository.getMovies(page);
    }

    public MutableLiveData<Movie> getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie.setValue(currentMovie);
    }
}
