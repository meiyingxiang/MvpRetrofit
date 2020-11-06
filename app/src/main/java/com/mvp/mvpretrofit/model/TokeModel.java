package com.mvp.mvpretrofit.model;

import com.mvp.mvpretrofit.bean.TokeBean;
import com.mvp.mvpretrofit.contract.TokeContract;
import com.mvp.mvpretrofit.net.NetWorkManager;
import com.mvp.mvpretrofit.request.Request;
import com.mvp.mvpretrofit.response.Response;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

public class TokeModel implements TokeContract.ITokeModel {

    private Request request;

    public TokeModel() {
        NetWorkManager.getInstall().init();
        request = NetWorkManager.getRequest();
    }

    @Override
    public Observable<Response<List<TokeBean>>> getTokeData(Map<String, String> map) {
        return request.getListData(map);
    }

    @Override
    public Observable<Response<List<TokeBean>>> getPostData(Map<String, String> map) {
        return request.getTokeData(map);
    }
}
