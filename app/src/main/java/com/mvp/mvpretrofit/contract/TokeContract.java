package com.mvp.mvpretrofit.contract;

import com.mvp.mvpretrofit.bean.TokeBean;
import com.mvp.mvpretrofit.response.Response;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

public interface TokeContract {

    interface ITokeModel {
        Observable<Response<List<TokeBean>>> getTokeData(Map<String, String> map);

        Observable<Response<List<TokeBean>>> getPostData(Map<String, String> map);
    }
}
