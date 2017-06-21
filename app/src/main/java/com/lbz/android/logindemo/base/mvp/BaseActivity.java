package com.lbz.android.logindemo.base.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lbz.android.logindemo.App;
import com.lbz.android.logindemo.base.AppComponent;

import javax.inject.Inject;


/**
 * Created by laibinzhi on 2017/2/21.
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {

    @Inject
    protected P presenter;

    protected App mApplication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (App) getApplication();
        setupActivityComponent(mApplication.getAppComponent());
        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
        this.presenter = null;
        this.mApplication = null;
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

}
