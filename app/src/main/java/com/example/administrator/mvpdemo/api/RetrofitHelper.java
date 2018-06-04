package com.example.administrator.mvpdemo.api;

import android.content.Context;

import com.example.administrator.mvpdemo.BaseAplication;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */

public class RetrofitHelper {

    private Context mCntext;
    private static final int DEFAULT_TIMEOUT = 5;// 默认超时时长
//    OkHttpClient client = new OkHttpClient();
    private static  final String CACHE_NAME="mvpdemo";


    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());

    private static RetrofitHelper instance = null;

    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context);
        }
        return instance;
    }
    private RetrofitHelper(Context mContext){
        mCntext = mContext;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//连接超时

        //设置日志
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);//设置日志级别

        //设置缓存目录
        File cacheFile = new File(BaseAplication.getContext().getExternalCacheDir(), CACHE_NAME);
        //生成缓存，50M
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);


        //添加进来
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(new CacheInterceptor()).cache(cache);


        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(builder.build())
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }




}
