package com.lbz.android.logindemo.ui.mian.inject;

import com.lbz.android.logindemo.base.AppComponent;
import com.lbz.android.logindemo.base.scope.ActivityScope;
import com.lbz.android.logindemo.ui.mian.UserActivity;

import dagger.Component;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {

    void inject(UserActivity activity);

}