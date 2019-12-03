package com.bawei.zhangboyi.base;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:
 */
public abstract class BasePresenter<V> {

    protected V view;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    //attach方法的作用：把IView传给P层
    public void attch(V view){
        this.view = view;
    }

    // TODO: 2019/12/3 解决内存泄漏 （ps：把activity置空）
    public void detach(){
        view = null;
    }
}
