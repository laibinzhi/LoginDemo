package com.lbz.android.logindemo.ui.mian;



import com.lbz.android.logindemo.bean.User;
import com.lbz.android.logindemo.network.rertofit.UserService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public class UserModelImpl implements UserContract.IUserModel {

    private UserService userService;

    public UserModelImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Disposable getUser(String username,final OnGetUserListener onGetUserListener) {
        return userService.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(@NonNull User user) throws Exception {
                        onGetUserListener.loginSuccess(user);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        onGetUserListener.loginFailed(throwable.toString());
                    }
                });


    }
}
