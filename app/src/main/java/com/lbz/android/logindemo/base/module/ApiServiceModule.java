package com.lbz.android.logindemo.base.module;

import com.lbz.android.logindemo.network.rertofit.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@Module
public class ApiServiceModule {

    @Singleton
    @Provides
    HttpUrl provideBaseUrl() {
        return HttpUrl.parse("http://demo.eliteu.cn/");
    }

    @Singleton
    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

}
