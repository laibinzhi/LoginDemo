package com.lbz.android.logindemo.base;

import android.app.Application;

import com.lbz.android.logindemo.base.module.ApiServiceModule;
import com.lbz.android.logindemo.base.module.AppModule;
import com.lbz.android.logindemo.base.module.HttpModule;
import com.lbz.android.logindemo.network.rertofit.UserService;
import com.lbz.android.logindemo.util.OauthPref;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class, ApiServiceModule.class})
public interface AppComponent {
    Application application();

    UserService userservice();

}
