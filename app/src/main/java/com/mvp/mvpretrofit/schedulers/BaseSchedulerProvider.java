package com.mvp.mvpretrofit.schedulers;

import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/**
 * 基础线程
 */
public interface BaseSchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();


    <T> ObservableTransformer<T, T> applyScheduler();

    <T> FlowableTransformer<T, T> flowableToMain();

    <T> MaybeTransformer<T, T> maybeToMain();
}
