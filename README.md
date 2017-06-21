# LoginDemo
Mvp+RxJava2+Retrofit2+Dagger2写的项目：<br />
1.关于mvp，可以参考https://github.com/googlesamples/android-architecture 的例子，有纯mvp,有mvp-clean,mvp-rxjava,mvvm等。<br />
2.RxJava要注意其生命周期，内存泄漏的问题。如下代码<br />
```Java
public abstract class BasePresenter<V> {

    protected Reference<V> viewRef;//弱引用

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

    //RXjava在具体presenter中通过retrofit结合Rxjava返回的Disposable
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

}
```
3.dagger2能解决mvp模式下activity或者fragment和presenter和present对于model的耦合性


