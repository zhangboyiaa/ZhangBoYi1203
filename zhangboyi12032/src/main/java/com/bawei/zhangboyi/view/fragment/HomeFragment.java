package com.bawei.zhangboyi.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangboyi.R;
import com.bawei.zhangboyi.base.BaseFragment;
import com.bawei.zhangboyi.state.NetState;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:
 */
public class HomeFragment extends BaseFragment {

    private TextView textView;
    private ImageView imageView;
    private TextView textView1;

    @Override
    protected void initView(View inflate) {
        imageView = inflate.findViewById(R.id.home_image);
        textView = inflate.findViewById(R.id.home_text);
        textView1 = inflate.findViewById(R.id.textaa);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        if (NetState.getInstance().hasNet(getActivity())){
            textView1.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
        }else {
            textView1.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
