package com.lbz.android.logindemo.ui.mian.inject;

import com.lbz.android.logindemo.base.scope.ActivityScope;
import com.lbz.android.logindemo.network.rertofit.UserService;
import com.lbz.android.logindemo.ui.mian.UserContract;
import com.lbz.android.logindemo.ui.mian.UserModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@Module
public class UserModule {

    @ActivityScope
    @Provides
    public UserContract.IUserModel provideUserModel(UserService userService) {
        return new UserModelImpl(userService);
    }
}
