package com.example.administrator.mvpdemo.dagger.module;

import com.example.administrator.mvpdemo.BaseAplication;
import com.example.administrator.mvpdemo.api.RetrofitHelper;
import com.example.administrator.mvpdemo.api.RetrofitService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steven on 2018/6/1.
 */

@Module
public class RetrofitServiceModule {

    @Provides
    public RetrofitService getServer(){

        return RetrofitHelper.getInstance(BaseAplication.getContext()).getServer();
    }
}
