package com.bawei.zhangboyi.state;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:
 */
public class NetState {

    private static NetState netState = new NetState();

    public static NetState getInstance() {
        return netState;
    }

    private NetState(){

    }

    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isMobile(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }else {
            return false;
        }
    }
}
