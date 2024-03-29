package com.bawei.zhangboyi.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:fragment基类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置视图id
        View inflate = inflater.inflate(layoutId(), container, false);
        presenter = providePresenter();
        presenter.attch(this);
        initView(inflate);
        return inflate;
    }

    protected abstract P providePresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置数据
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
