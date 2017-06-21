package com.lbz.android.logindemo.ui.login;


import com.lbz.android.logindemo.bean.AuthResponse;
import com.lbz.android.logindemo.network.rertofit.UserService;
import com.lbz.android.logindemo.util.OauthPref;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public class LoginModelImpl implements LoginContract.ILoginModel {

    private UserService userService;

    public LoginModelImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Disposable login(String username, String password, final OnLoginListener onLoginListener) {
        return userService.login("password", "", username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AuthResponse>() {
                    @Override
                    public void accept(@NonNull AuthResponse authResponse) throws Exception {
                        if (authResponse.isSuccess()) {
                            onLoginListener.loginSuccess();
                            OauthPref.getInstance().setOauthPref(authResponse);
                        } else {
                            onLoginListener.loginFailed(getFailMsg(authResponse.code));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        onLoginListener.loginFailed(throwable.toString());

                    }
                });

    }

    public String getFailMsg(int code) {
        String msg = "";
        switch (code) {
            case 1:
                msg = "用户名为空";
                break;
            case 2:
                msg = "密码为空";
                break;
            case 400:
                msg = "密码错误";
                break;
            case 404:
                msg = "账号不存在";
                break;
            default:
                msg = "其他登录错误";
                break;
        }

        return msg;
    }
}
