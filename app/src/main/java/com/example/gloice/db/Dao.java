package com.example.gloice.db;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gloice.model.Movie;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM movie")
    List<Movie> getAll();

    @Query("SELECT * FROM movie where id = :id")
    Movie getMovieById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Movie> movie);


}
