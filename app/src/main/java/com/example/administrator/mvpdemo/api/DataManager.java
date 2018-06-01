package com.example.administrator.mvpdemo.api;

import android.content.Context;

import com.example.administrator.mvpdemo.entity.Book;

import javax.inject.Inject;

import rx.Observable;

/**
 *
 */

public class DataManager {


    public RetrofitService mRetrofitService;

    @Inject
    public DataManager() {
    }


    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }


    public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);
    }



}
