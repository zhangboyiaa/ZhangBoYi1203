package com.bawei.zhangboyi.view.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangboyi.R;
import com.bawei.zhangboyi.model.bean.ShopingBean;
import com.bawei.zhangboyi.utile.Netutile;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:
 */
public class MyAdapter extends BaseAdapter {

    List<ShopingBean.ShopGridDataBean> list = new ArrayList<>();

    public MyAdapter(List<ShopingBean.ShopGridDataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(parent.getContext(), R.layout.item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.grid_image);
            holder.title = convertView.findViewById(R.id.grid_title);
            holder.price = convertView.findViewById(R.id.grid_price);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ShopingBean.ShopGridDataBean shopGridDataBean = list.get(position);

        holder.title.setText(shopGridDataBean.getTitle());
        holder.price.setText(shopGridDataBean.getPrice());

        final ViewHolder holder1 = holder;

        Netutile.getInstance().doGetPhoto(shopGridDataBean.getImageurl(), new Netutile.MyCallBack() {
            @Override
            public void ondoGetSuccsess(String json) {

            }

            @Override
            public void ondoGetPhotoSuccsess(Bitmap bitmap) {
                holder1.imageView.setImageBitmap(bitmap);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView title,price;
    }
}
