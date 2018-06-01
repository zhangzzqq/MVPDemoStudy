package com.example.administrator.mvpdemo.dagger.module;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by steven on 2018/5/31.
 */

@Module
public class SubscriptionModule {

    @Provides
    public CompositeSubscription provideSubscription(){
        return new CompositeSubscription();
    }


}
