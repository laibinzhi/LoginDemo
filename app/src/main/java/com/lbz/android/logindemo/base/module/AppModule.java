package com.lbz.android.logindemo.base.module;

import android.app.Application;

import com.lbz.android.logindemo.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@Module
public class AppModule {


    public AppModule(App application) {
        this.mApplication = application;
    }

    private Application mApplication;

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

}
