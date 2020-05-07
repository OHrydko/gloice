package com.example.gloice.db;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gloice.model.Data;
import com.example.gloice.model.Movie;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM data where page = :page")
    Data getAllFromPage(int page);

    @Query("SELECT * FROM movie where id = :id")
    Movie getMovieById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Data movie);


}
