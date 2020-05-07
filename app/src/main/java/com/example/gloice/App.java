package com.example.gloice;

import android.app.Application;
import android.content.IntentFilter;

import com.example.gloice.di.Component;
import com.example.gloice.di.DaggerComponent;
import com.example.gloice.di.RetrofitModule;
import com.example.gloice.di.RoomModule;
import com.example.gloice.receiver.BackgroundSync;


public class App extends Application {

    private static Component component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerComponent.builder()
                .application(this)
                .retrofitModule(new RetrofitModule())
                .roomModule(new RoomModule())
                .build();

        this.registerReceiver(new BackgroundSync(), new IntentFilter(
                "android.net.conn.CONNECTIVITY_CHANGE"));

    }

    public static Component getComponent() {
        return component;
    }
}

