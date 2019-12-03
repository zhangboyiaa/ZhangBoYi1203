package com.bawei.zhangboyi.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置id
        setContentView(layoutId());
        //设置视图
        initView();
        //设置数据
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();
}
