package com.example.administrator.mvpdemo.service.manager;

import android.content.Context;

import com.example.administrator.mvpdemo.api.RetrofitHelper;
import com.example.administrator.mvpdemo.api.RetrofitService;
import com.example.administrator.mvpdemo.service.entity.Book;

import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).create(RetrofitService.class);
    }
    public  Observable<Book> getSearchBooks(String name,String tag,int start,int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);
    }
}
