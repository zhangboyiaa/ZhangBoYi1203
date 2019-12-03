package com.bawei.zhangboyi.model;

import android.graphics.Bitmap;

import com.bawei.zhangboyi.contract.IShopingContract;
import com.bawei.zhangboyi.model.bean.ShopingBean;
import com.bawei.zhangboyi.utile.Netutile;
import com.google.gson.Gson;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:Model类
 */
public class ShopingModel implements IShopingContract.IModel {

    @Override
    public void getShopingData(final IModelCallBack iModelCallBack) {
        String url = "http://blog.zhaoliang5156.cn/api/mall/mall.json";
        Netutile.getInstance().doGet(url, new Netutile.MyCallBack() {
            @Override
            public void ondoGetSuccsess(String json) {
                ShopingBean shopingBean = new Gson().fromJson(json, ShopingBean.class);

                iModelCallBack.onShopingSuccsess(shopingBean);
            }

            @Override
            public void ondoGetPhotoSuccsess(Bitmap bitmap) {

            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallBack.onShopingFailure(throwable);
            }
        });
    }
}
