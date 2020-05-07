package com.example.gloice.di;

import android.app.Application;

import com.example.gloice.db.Dao;
import com.example.gloice.network.ApiService;

import dagger.BindsInstance;


@dagger.Component(modules = {RetrofitModule.class, RoomModule.class})
public interface Component {
    ApiService getApi();

    Dao getDao();

    @dagger.Component.Builder
    interface Builder {
        Component build();

        Builder retrofitModule(RetrofitModule retrofitModule);

        Builder roomModule(RoomModule roomModule);

        @BindsInstance
        Builder application(Application application);

    }
}
