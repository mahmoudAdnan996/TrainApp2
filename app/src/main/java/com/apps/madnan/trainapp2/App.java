package com.apps.madnan.trainapp2;

import android.app.Application;

import com.apps.madnan.trainapp2.service.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.apps.madnan.trainapp2.service.Constants.BASE_URL;


/**
 * Created by mahmoud adnan on 9/26/2017.
 */

public class App extends Application {

    public static Service service;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);
    }
}
