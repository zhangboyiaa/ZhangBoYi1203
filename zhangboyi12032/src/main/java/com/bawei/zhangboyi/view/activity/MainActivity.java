package com.bawei.zhangboyi.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.zhangboyi.R;
import com.bawei.zhangboyi.base.BaseActivity;
import com.bawei.zhangboyi.base.BasePresenter;
import com.bawei.zhangboyi.view.fragment.HomeFragment;
import com.bawei.zhangboyi.view.fragment.OtherFramgment;
import com.bawei.zhangboyi.view.fragment.ShopingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        list.add(homeFragment);

        OtherFramgment otherFramgment = new OtherFramgment();
        Bundle bundle = new Bundle();
        bundle.putString("key","分类");
        otherFramgment.setArguments(bundle);
        list.add(otherFramgment);

        OtherFramgment otherFramgment1 = new OtherFramgment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("key","发现");
        otherFramgment1.setArguments(bundle1);
        list.add(otherFramgment1);

        ShopingFragment shopingFragment = new ShopingFragment();
        list.add(shopingFragment);

        OtherFramgment otherFramgment2 = new OtherFramgment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key","我的");
        otherFramgment2.setArguments(bundle2);
        list.add(otherFramgment2);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_btua:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radio_btub:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radio_btuc:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.radio_btud:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.radio_btue:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
        radioGroup = findViewById(R.id.radio_group);
    }

    public void tiao(){
        viewPager.setCurrentItem(0);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
