package com.example.administrator.mvpdemo.dagger.component;

import com.example.administrator.mvpdemo.dagger.module.RetrofitServiceModule;
import com.example.administrator.mvpdemo.dagger.module.SubscriptionModule;
import com.example.administrator.mvpdemo.function.book.BookActivity;
import com.example.administrator.mvpdemo.function.book.presenter.BookPresenter;

import dagger.Component;

/**
 * Created by steven on 2018/5/31.
 */

@Component(modules = {SubscriptionModule.class, RetrofitServiceModule.class})
public interface BookComponent {

    void inject (BookPresenter bookPresenter);
    void injectActivity(BookActivity activity);

}
