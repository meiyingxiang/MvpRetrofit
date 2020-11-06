package com.mvp.mvpretrofit.request;

import com.mvp.mvpretrofit.bean.TokeBean;
import com.mvp.mvpretrofit.response.Response;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Request {
    String BASE_URL = "https://api.apiopen.top/";

    //如果是post请求换成post请求,可创建多个
    @GET("getJoke?page=1&count=2&type=video")
    Observable<Response<List<TokeBean>>> getListData(@QueryMap Map<String, String> map);

    @POST(".")
    Observable<Response<List<TokeBean>>> getTokeData(@QueryMap Map<String, String> map);
}
