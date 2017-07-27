package com.example.com;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Balan Vishnu on 22-Mar-17.
 */

public class Utils {
    public static Api getApi() {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.relltech.com/")
                .addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        return retrofit.create(Api.class);

    }
}
