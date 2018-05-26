package com.mangoice.gankio.net;


import com.mangoice.gankio.model.ExpressModel;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.model.WeatherModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by MangoIce on 2018/5/7.
 */

public interface Api {
    @GET("data/{category}/{pageSize}/{page}")
    Observable<GankModel> getGankData(@Path("category") String category
                                         , @Path("pageSize") int pageSize
                                         , @Path("page") int page);

    @GET("v51/")
    Observable<NewsModel> getNewsData(@QueryMap Map<String, String> options);

    @GET("listWeather")
    Observable<WeatherModel> getWeatherData(@Query("cityIds") String id);

    @GET("query")
    Observable<ExpressModel> getExpressData(@Query("type") String type, @Query("postid") String postId);
}
