package com.example.gloice.network;


import com.example.gloice.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("3/movie/popular")
    Call<Data> getData(@Query("api_key") String api_key,
                       @Query("language") String language,
                       @Query("page") String page);

}
