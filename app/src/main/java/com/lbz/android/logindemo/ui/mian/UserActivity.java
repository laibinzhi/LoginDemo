package com.lbz.android.logindemo.ui.mian;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lbz.android.logindemo.R;
import com.lbz.android.logindemo.base.AppComponent;
import com.lbz.android.logindemo.base.mvp.BaseActivity;
import com.lbz.android.logindemo.bean.User;
import com.lbz.android.logindemo.ui.mian.inject.DaggerUserComponent;
import com.lbz.android.logindemo.ui.mian.inject.UserModule;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserActivity extends BaseActivity<UserContract.IUserView, UserPresenter> implements UserContract.IUserView {

    @Bind(R.id.show_user_tv)
    TextView textView;

    @Bind(R.id.progressbar)
    ProgressBar progressBar;

    @Bind(R.id.show_layout)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerUserComponent.builder().appComponent(appComponent)
                .userModule(new UserModule())
                .build()
                .inject(this);
    }

    @Override
    public String getUsername() {
        return getIntent().getStringExtra("username");
    }

    @Override
    public void showLoading() {
        relativeLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        relativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUser(User user) {
        if (user != null) {
            textView.setText(user.toString());
        }
    }

    @Override
    public void showGetUserSuccess() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
