package com.bawei.zhangboyi.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.zhangboyi.R;
import com.bawei.zhangboyi.base.BaseFragment;
import com.bawei.zhangboyi.contract.IShopingContract;
import com.bawei.zhangboyi.model.ShopingModel;
import com.bawei.zhangboyi.model.bean.ShopingBean;
import com.bawei.zhangboyi.presenter.ShopingPresenter;
import com.bawei.zhangboyi.view.activity.MainActivity;
import com.bawei.zhangboyi.view.adapter.MyAdapter;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:
 */
public class ShopingFragment extends BaseFragment<ShopingPresenter> implements IShopingContract.IView {

    private GridView gridView;
    private Button button;
    private ImageView imageView;

    @Override
    protected ShopingPresenter providePresenter() {
        return new ShopingPresenter();
    }

    @Override
    protected void initView(View inflate) {
        imageView = inflate.findViewById(R.id.shoping_image);
        button = inflate.findViewById(R.id.buu);
        gridView = inflate.findViewById(R.id.grid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.tiao();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shoping;
    }

    @Override
    protected void initData() {

        presenter.getShopingData();
    }

    @Override
    public void onShopingSuccsess(ShopingBean shopingBean) {
        Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
        gridView.setAdapter(new MyAdapter(shopingBean.getShopGridData()));
    }

    @Override
    public void onShopingFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
    }
}
