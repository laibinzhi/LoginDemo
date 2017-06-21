package com.lbz.android.logindemo.ui.login.inject;

import com.lbz.android.logindemo.base.AppComponent;
import com.lbz.android.logindemo.base.scope.ActivityScope;
import com.lbz.android.logindemo.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {

    void inject(LoginActivity activity);

}