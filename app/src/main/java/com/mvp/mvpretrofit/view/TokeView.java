package com.mvp.mvpretrofit.view;

import com.mvp.mvpretrofit.base.view.BaseView;
import com.mvp.mvpretrofit.bean.TokeBean;

import java.util.List;

public interface TokeView extends BaseView {

    void onSuccessTokenData(List<TokeBean> tokeBeans);

    void onFail(String msg);

}
