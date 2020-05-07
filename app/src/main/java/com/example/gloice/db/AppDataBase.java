package com.example.gloice.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gloice.model.Data;
import com.example.gloice.model.Movie;

@Database(entities = {Movie.class, Data.class}, version = 1, exportSchema = false)
abstract public class AppDataBase extends RoomDatabase {
    public abstract Dao getDao();
}
