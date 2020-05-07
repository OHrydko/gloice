package com.example.gloice.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.gloice.App;
import com.example.gloice.model.Data;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private MutableLiveData<Data> movie = new MutableLiveData<>();


    public MutableLiveData<Data> getMovies(int page) {
        String api_key = "8e0652e0b30813d0c7410a3498a2e053";
        App.getComponent().getApi().getData(api_key, "en-US", Integer.toString(page)).
                enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(@NotNull Call<Data> call, @NotNull Response<Data> response) {
                        Data data = response.body();
                        if (data != null) {
                            movie.postValue(data);
                            new Thread(() -> App.getComponent().getDao().insert(data)).run();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<Data> call, @NotNull Throwable t) {
                        Log.d("throwable", Objects.requireNonNull(t.getMessage()));
                    }
                });
        return movie;
    }

    public MutableLiveData<Data> getMoviesFromDB(int page) {
        movie.postValue(App.getComponent().getDao().getAllFromPage(page));
        return movie;
    }
}
