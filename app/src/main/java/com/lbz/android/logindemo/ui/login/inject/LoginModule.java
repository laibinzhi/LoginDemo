package com.lbz.android.logindemo.ui.login.inject;

import com.lbz.android.logindemo.base.scope.ActivityScope;
import com.lbz.android.logindemo.network.rertofit.UserService;
import com.lbz.android.logindemo.ui.login.LoginContract;
import com.lbz.android.logindemo.ui.login.LoginModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@Module
public class LoginModule {

    @ActivityScope
    @Provides
    public LoginContract.ILoginModel provideLoginModel(UserService userService) {
        return new LoginModelImpl(userService);
    }
}
