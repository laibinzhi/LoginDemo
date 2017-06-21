package com.lbz.android.logindemo.base.mvp;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public abstract class BasePresenter<V> {

    protected Reference<V> viewRef;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void attachView(V mView) {
        viewRef = new WeakReference<V>(mView);
    }

    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
        cleanDisposable();
    }

    protected V getView() {

        return viewRef.get();
    }

    //RXjava取消注册，以避免内存泄露
    public void cleanDisposable() {
        compositeDisposable.clear();
    }

    //RXjava注册
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

}