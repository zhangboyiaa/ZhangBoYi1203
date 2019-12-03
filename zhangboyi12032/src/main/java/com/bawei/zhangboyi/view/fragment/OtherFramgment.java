package com.bawei.zhangboyi.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.zhangboyi.R;
import com.bawei.zhangboyi.base.BaseFragment;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:other
 */
public class OtherFramgment extends BaseFragment {

    private TextView textView;

    @Override
    protected void initView(View inflate) {
        textView = inflate.findViewById(R.id.text_name);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_other;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String key = arguments.getString("key");
        textView.setText(key);
    }
}
