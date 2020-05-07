package com.example.gloice.di;

import android.app.Application;

import androidx.room.Room;

import com.example.gloice.db.AppDataBase;
import com.example.gloice.db.Dao;

import dagger.Module;
import dagger.Provides;

@Module
public
class RoomModule {

    @Provides
    Dao getDao(AppDataBase appDataBase) {
        return appDataBase.getDao();
    }

    @Provides
    AppDataBase getDataBase(Application context) {
        return Room.databaseBuilder(context, AppDataBase.class, "db")
                .allowMainThreadQueries()
                .build();
    }
}
