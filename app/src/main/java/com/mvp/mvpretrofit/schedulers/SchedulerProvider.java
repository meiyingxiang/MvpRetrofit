package com.mvp.mvpretrofit.schedulers;

import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 线程管理者
 */
public class SchedulerProvider implements BaseSchedulerProvider {

    private static SchedulerProvider instance;

    private SchedulerProvider() {
    }

    public static synchronized SchedulerProvider getInstance() {
        if (instance == null) {
            instance = new SchedulerProvider();
        }
        return instance;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    /**
     * Observable切换到主线程
     * 能够发射0或n个数据，并以成功或错误事件终止
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> ObservableTransformer<T, T> applyScheduler() {
        return observable -> observable.subscribeOn(io())
                .observeOn(ui());
    }

    /**
     * Flowable 切换到主线程
     * 能够发射0或n个数据，并以成功或错误事件终止。 支持Backpressure，可以控制数据源发射的速度。
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> FlowableTransformer<T, T> flowableToMain() {
        return upstream -> upstream.subscribeOn(io())
                .observeOn(ui());
    }


    /**
     * Maybe 切换到主线程
     * 能够发射0或者1个数据，要么成功，要么失败。有点类似于Optional
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> MaybeTransformer<T, T> maybeToMain() {
        return upstream -> upstream.subscribeOn(io())
                .observeOn(ui());
    }

/*
* Observable<T> 	能够发射0或n个数据，并以成功或错误事件终止。
Flowable<T> 	能够发射0或n个数据，并以成功或错误事件终止。 支持Backpressure，可以控制数据源发射的速度。
Single<T> 	只发射单个数据或错误事件。
Completable 	它从来不发射数据，只处理 onComplete 和 onError 事件。可以看成是Rx的Runnable。
Maybe<T> 	能够发射0或者1个数据，要么成功，要么失败。有点类似于Optional

* 一共有5种观察者类型
*
*
* */
}
