package com.lbz.android.logindemo.ui.mian;

import com.lbz.android.logindemo.bean.User;

import io.reactivex.disposables.Disposable;

/**
 * Created by laibinzhi on 2017/6/21.
 */
public interface UserContract {

    interface IUserModel {

        Disposable getUser(String username, OnGetUserListener onGetUserListener);

        interface OnGetUserListener {
            void loginSuccess(User user);

            void loginFailed(String msg);
        }
    }

    interface IUserView {

        String getUsername();

        void showLoading();

        void hideLoading();

        void showUser(User user);

        void showGetUserSuccess();

        void showLoginFailMsg(String msg);
    }

}
