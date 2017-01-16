package com.example.bhavyasapra.authorslistapi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bhavya Sapra on 16-01-2017.
 */

public interface ApiInterface {
    @GET("author + Apikeyclass.API_KEY")
    Call<authorlistdata> getauthorlist();
}
