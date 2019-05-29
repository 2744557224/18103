package com.example.a27445.myapplication;

import Bean.Data;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url="http://gank.io/";


    @GET("api/data/福利/10/1")
    Observable<Data> getUrlData();
}
