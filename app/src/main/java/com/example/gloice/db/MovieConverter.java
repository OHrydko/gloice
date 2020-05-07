package com.example.gloice.db;

import androidx.room.TypeConverter;

import com.example.gloice.model.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MovieConverter {
    @TypeConverter
    public String fromList(List<Movie> categories) {
        return new Gson().toJson(categories);
    }

    @TypeConverter
    public List<Movie> toList(String categories) {
        return new Gson().fromJson(categories, new TypeToken<ArrayList<Movie>>() {
        }.getType());
    }
}
