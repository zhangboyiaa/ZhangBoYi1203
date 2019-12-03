package com.bawei.zhangboyi.presenter;

import com.bawei.zhangboyi.base.BasePresenter;
import com.bawei.zhangboyi.contract.IShopingContract;
import com.bawei.zhangboyi.model.ShopingModel;
import com.bawei.zhangboyi.model.bean.ShopingBean;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:
 */
public class ShopingPresenter extends BasePresenter<IShopingContract.IView> implements IShopingContract.IPresenter {

    private ShopingModel shopingModel;

    @Override
    protected void initModel() {
        shopingModel = new ShopingModel();
    }

    @Override
    public void getShopingData() {
        // TODO: 2019/11/30 不直接联网，要调用 m 层的方法
        shopingModel.getShopingData(new IShopingContract.IModel.IModelCallBack() {
            @Override
            public void onShopingSuccsess(ShopingBean shopingBean) {
                view.onShopingSuccsess(shopingBean);
            }

            @Override
            public void onShopingFailure(Throwable throwable) {
                view.onShopingFailure(throwable);
            }
        });
    }
}
