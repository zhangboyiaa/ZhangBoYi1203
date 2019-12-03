package com.bawei.zhangboyi.contract;

import com.bawei.zhangboyi.model.bean.ShopingBean;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:接口契约类
 */
public interface IShopingContract {

    //p层通知v层
    interface IView{
        void onShopingSuccsess(ShopingBean shopingBean);

        void onShopingFailure(Throwable throwable);
    }

    interface IPresenter{
        void getShopingData();
    }

    //m层通知p
    interface IModel{
        void getShopingData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onShopingSuccsess(ShopingBean shopingBean);

            void onShopingFailure(Throwable throwable);
        }
    }
}
