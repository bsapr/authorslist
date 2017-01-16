package com.example.bhavyasapra.authorslistapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bhavya Sapra on 16-01-2017.
 */

public interface ApiInterface {
    @GET("author")
    Call<authorlistdata> getauthorlist(@Header("X-Mashape-Key") String API_KEY);
}
