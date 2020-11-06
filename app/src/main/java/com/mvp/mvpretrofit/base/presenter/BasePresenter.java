package com.mvp.mvpretrofit.base.presenter;

import com.mvp.mvpretrofit.base.view.BaseView;

public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public V getView() {
        return view;
    }

    /**
     * 绑定View
     *
     * @param view
     */
    public void attachView(V view) {
        this.view = view;
    }

    /**
     * 解除绑定
     */
    public void detachView() {
        view = null;
    }

}
