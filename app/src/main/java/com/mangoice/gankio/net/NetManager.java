package com.mangoice.gankio.net;

import com.mangoice.gankio.common.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MangoIce on 2018/5/7.
 */

public class NetManager {
    private static NetManager mNetManager;

    private NetManager() {

    }

    public static NetManager getInstance() {
        if (mNetManager == null) {
            synchronized (NetManager.class) {
                if (mNetManager == null) {
                    mNetManager = new NetManager();
                }
            }
        }
        return mNetManager;
    }

    public Api getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.GANK_URL)
                .client(httpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        return api;
    }

    public Api getNewsApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.NEWS_URL)
                .client(httpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        return api;
    }

    public Api getWeatherApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.WEATHER_URL)
                .client(httpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        return api;
    }

    public Api getExpressApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.EXPRESS_URL)
                .client(httpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        return api;
    }

    private static OkHttpClient httpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }


}
