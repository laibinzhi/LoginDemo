package com.lbz.android.logindemo.ui.mian;


import com.lbz.android.logindemo.base.mvp.BasePresenter;
import com.lbz.android.logindemo.bean.User;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public class UserPresenter extends BasePresenter<UserContract.IUserView> {

    @Inject
    UserPresenter() {
    }

    @Inject
    UserContract.IUserModel userModel;


    public void start() {

        final UserContract.IUserView view = getView();

        view.showLoading();

        Disposable disposable = userModel.getUser(view.getUsername(), new UserContract.IUserModel.OnGetUserListener() {
            @Override
            public void loginSuccess(User user) {
                view.hideLoading();
                view.showGetUserSuccess();
                view.showUser(user);
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
