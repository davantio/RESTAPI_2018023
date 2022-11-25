package com.example.tugas3_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static RetrofitClient myInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(myInstance == null){
            myInstance = new RetrofitClient();
        }
        return myInstance;
    }
    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
