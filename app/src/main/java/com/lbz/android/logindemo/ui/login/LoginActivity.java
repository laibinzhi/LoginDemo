package com.lbz.android.logindemo.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lbz.android.logindemo.R;
import com.lbz.android.logindemo.base.AppComponent;
import com.lbz.android.logindemo.base.mvp.BaseActivity;
import com.lbz.android.logindemo.ui.login.inject.DaggerLoginComponent;
import com.lbz.android.logindemo.ui.login.inject.LoginModule;
import com.lbz.android.logindemo.ui.mian.UserActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by laibinzhi on 2017/2/21.
 */

public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPresenter> implements LoginContract.ILoginView {


    @Bind(R.id.username_et)
    EditText username_et;

    @Bind(R.id.password_et)
    EditText password_et;

    @Bind(R.id.progressbar)
    ProgressBar progressBar;

    @Bind(R.id.login_btn)
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder().appComponent(appComponent)
                .loginModule(new LoginModule())
                .build().inject(this);
    }

    @OnClick(R.id.login_btn)
    public void onClick(View v) {
       presenter.start();
    }

    @Override
    public String getUsername() {
        return username_et.getText().toString();
    }

    @Override
    public String getPassword() {
        return password_et.getText().toString();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        login_btn.setEnabled(false);
        username_et.setEnabled(false);
        password_et.setEnabled(false);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        login_btn.setEnabled(true);
        username_et.setEnabled(true);
        password_et.setEnabled(true);
    }

    @Override
    public void ToMainActivity() {
        startActivity(new Intent(this, UserActivity.class).putExtra("username",getUsername()));
    }

    @Override
    public void showLoginSuccessful() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
