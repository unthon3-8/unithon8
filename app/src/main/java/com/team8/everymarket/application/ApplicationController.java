package com.team8.everymarket.application;


import android.app.Application;
import com.team8.everymarket.network.NetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ichaeeun on 2017. 2. 4..
 */


public class ApplicationController extends Application {

    private static ApplicationController instance;

    private static String baseUrl = "http://192.168.43.182:3000";

    private NetworkService networkService;

    public static ApplicationController getInstance() {
        return instance;
    }

    public NetworkService getNetworkService() {
        return networkService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;

        buildService();
    }

    public void buildService() {

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
    }


}
