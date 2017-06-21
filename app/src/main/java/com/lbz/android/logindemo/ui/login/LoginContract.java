package com.lbz.android.logindemo.ui.login;

import io.reactivex.disposables.Disposable;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public interface LoginContract {

    interface ILoginModel {

        Disposable login(String username, String password, OnLoginListener onLoginListener);

        interface OnLoginListener {
            void loginSuccess();

            void loginFailed(String msg);
        }
    }

    interface ILoginView {

        String getUsername();

        String getPassword();

        void showLoading();

        void hideLoading();

        void ToMainActivity();

        void showLoginSuccessful();

        void showLoginFailMsg(String msg);
    }
}
