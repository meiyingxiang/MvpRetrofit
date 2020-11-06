package com.mvp.mvpretrofit;


import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mvp.mvpretrofit.base.activity.BaseActivity;
import com.mvp.mvpretrofit.bean.TokeBean;
import com.mvp.mvpretrofit.presenter.TokePresenter;
import com.mvp.mvpretrofit.view.TokeView;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity<TokeView, TokePresenter> implements TokeView {

    LinearLayout listMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listMode = findViewById(R.id.listMode);
        getPresenter().getTokeData(new HashMap<>());
    }

    @Override
    public TokeView createView() {
        return this;
    }

    @Override
    public TokePresenter createPresenter() {
        return new TokePresenter();
    }

    @Override
    public void onSuccessTokenData(List<TokeBean> tokeBeans) {
        if (tokeBeans != null) {
            Log.e("Frank", "onSuccessTokenData: tokeBeans=" + tokeBeans.size());
            for (int i = 0; i < tokeBeans.size(); i++) {
                TokeBean tokeBean = tokeBeans.get(i);
                if (tokeBean != null) {
                    String thumbnail = tokeBean.getThumbnail();
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    Glide.with(MainActivity.this)
                            .load(thumbnail)
                            .into(imageView);
                    listMode.addView(imageView);
                }
            }
        }
    }

    @Override
    public void onFail(String msg) {

    }
}
