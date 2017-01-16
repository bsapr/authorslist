package com.example.bhavyasapra.authorslistapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bhavya Sapra on 16-01-2017.
 */

public class ApiClient {
    private static ApiInterface mService;

    public static ApiInterface getApiInterface(){
        if(mService==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://thundercomb-poetry-db-v1.p.mashape.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mService=retrofit.create(ApiInterface.class);
        }
        return mService;
    }
}
