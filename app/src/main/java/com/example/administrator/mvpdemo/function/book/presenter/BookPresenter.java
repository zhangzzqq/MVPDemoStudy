package com.example.administrator.mvpdemo.function.book.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.administrator.mvpdemo.api.RetrofitService;
import com.example.administrator.mvpdemo.dagger.component.DaggerBookComponent;
import com.example.administrator.mvpdemo.entity.Book;
import com.example.administrator.mvpdemo.function.book.view.BookView;
import com.example.administrator.mvpdemo.function.book.view.View;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 *
 */

public class BookPresenter implements Presenter {

 //    private DataManager manager;
//    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private BookView mBookView;
    private Book mBook;

    @Inject
    CompositeSubscription mCompositeSubscription;

//    @Inject
//     DataManager manager;

    @Inject
    RetrofitService mRetrofitService;



//    public BookPresenter(Context mContext) {
//        this.mContext = mContext;
//    }



    @Inject
    public BookPresenter() {
        DaggerBookComponent.create().inject(this);
    }


    @Override
    public void onCreate() {

//        manager = new DataManager(mContext);

//        DaggerBookComponent.create().inject(this);

//        mCompositeSubscription = new CompositeSubscription();

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mBookView = (BookView) view;

    }

    @Override
    public void attachIncomingIntent(Intent intetn) {

    }

    public void getSearchBooks(String name, String tag, int start, int count) {
//        mCompositeSubscription.add(manager.getSearchBooks(name, tag, start, count)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Book>() {
//                    @Override
//                    public void onCompleted() {
//                        if (mBook != null) {
//                            mBookView.onSuccess(mBook);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        mBookView.onError("请求失败！！");
//                    }
//
//                    @Override
//                    public void onNext(Book book) {
//                        mBook = book;
//                    }
//                })
//        );

//mRetrofitService.getSearchBooks(name,tag,start,count)

        mCompositeSubscription.add(mRetrofitService.getSearchBooks(name, tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (mBook != null) {
                            mBookView.onSuccess(mBook);

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mBookView.onError("请求失败！！");

                    }

                    @Override
                    public void onNext(Book book) {
                        mBook = book;
                    }
                })
        );


    }


}
