package com.example.gloice.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

public class BackgroundSync extends BroadcastReceiver {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();

        if (connectivityManager != null) {
            connectivityManager.registerNetworkCallback(
                    builder.build(),
                    new ConnectivityManager.NetworkCallback() {

                        @Override
                        public void onAvailable(@NotNull Network network) {
                            // Network Available
                            Log.d("internet","intrnet");
                        }


                        @Override
                        public void onLost(@NotNull Network network) {
                            // Network Not Available
                            Log.d("internet","throwable");

                        }
                    }
            );
        }
    }
}
