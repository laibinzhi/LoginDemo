package com.lbz.android.logindemo.ui.login;

import android.text.TextUtils;

import com.lbz.android.logindemo.base.mvp.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> {

    @Inject
    LoginPresenter() {
    }

    @Inject
    LoginContract.ILoginModel loginModel;


    public void start() {

        final LoginContract.ILoginView view = getView();
        if (TextUtils.isEmpty(view.getUsername())) {
            view.showLoginFailMsg("用户名为空");
            return;
        }
        if (TextUtils.isEmpty(view.getPassword())) {
            view.showLoginFailMsg("密码为空");
            return;
        }
        view.showLoading();
        Disposable disposable = loginModel.login(view.getUsername(), view.getPassword(), new LoginContract.ILoginModel.OnLoginListener() {
            @Override
            public void loginSuccess() {
                view.hideLoading();
                view.showLoginSuccessful();
                view.ToMainActivity();
            }

            @Override
            public void loginFailed(String msg) {
                view.hideLoading();
                view.showLoginFailMsg(msg);
            }
        });
        addDisposable(disposable);
    }
}
