package com.example.administrator.mvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by steven on 2018/6/1.
 */
public class BaseAplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    public static Context getContext() {

        return mContext;
    }
}
