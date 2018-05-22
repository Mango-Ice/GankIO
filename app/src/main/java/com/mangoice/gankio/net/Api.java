package com.mangoice.gankio.net;


import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.NewsModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

}
