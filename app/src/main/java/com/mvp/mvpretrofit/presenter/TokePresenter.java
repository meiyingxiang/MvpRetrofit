package com.mvp.mvpretrofit.presenter;

import android.util.Log;

import com.mvp.mvpretrofit.base.presenter.BasePresenter;
import com.mvp.mvpretrofit.bean.TokeBean;
import com.mvp.mvpretrofit.model.TokeModel;
import com.mvp.mvpretrofit.response.ResponseTransformer;
import com.mvp.mvpretrofit.schedulers.SchedulerProvider;
import com.mvp.mvpretrofit.view.TokeView;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class TokePresenter extends BasePresenter<TokeView> {

    private CompositeDisposable mCompositeDisposable;
    private TokeModel tokeModel;
    private SchedulerProvider provider;

    public TokePresenter() {
        mCompositeDisposable = new CompositeDisposable();
        tokeModel = new TokeModel();
        provider = SchedulerProvider.getInstance();
    }

    public void getTokeData(Map<String, String> map) {
        tokeModel.getTokeData(map)
                .compose(ResponseTransformer.handleResult())
                .compose(provider.applyScheduler())
                .subscribe(new Observer<List<TokeBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
                            mCompositeDisposable.add(d);
                        }
                    }

                    @Override
                    public void onNext(List<TokeBean> tokeBeans) {
                        if (getView() != null) {
                            getView().onSuccessTokenData(tokeBeans);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Frank", "onError: e=" + e.toString());
                        if (getView() != null) {
                            getView().onFail(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
