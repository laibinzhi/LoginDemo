package com.lbz.android.logindemo;

import android.app.Application;
import android.content.Context;

import com.lbz.android.logindemo.base.AppComponent;
import com.lbz.android.logindemo.base.DaggerAppComponent;
import com.lbz.android.logindemo.base.module.ApiServiceModule;
import com.lbz.android.logindemo.base.module.AppModule;
import com.lbz.android.logindemo.base.module.HttpModule;

/**
 * Created by laibinzhi on 2017/6/21.
 */
public class App  extends Application{

    private AppComponent mAppComponent;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .httpModule(new HttpModule())
                .build();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static Context getContext() {
        return context;

    }
}
