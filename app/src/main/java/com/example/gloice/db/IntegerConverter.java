package com.example.gloice.db;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class IntegerConverter {

    @TypeConverter
    public String fromList(List<Integer> categories) {
        return new Gson().toJson(categories);
    }

    @TypeConverter
    public List<Integer> toList(String categories) {
        return new Gson().fromJson(categories, new TypeToken<ArrayList<Integer>>() {
        }.getType());
    }
}