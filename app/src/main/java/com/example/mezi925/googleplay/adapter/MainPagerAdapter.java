package com.example.mezi925.googleplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mezi925.googleplay.factory.FragmentFactory;

/**
 * Created by mezi925 on 2017/2/16.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {


    private String[] mTitle;

    public MainPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.mTitle = titles;
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public Fragment getItem(int position) {
        // 返回指定位置的fragment
        return FragmentFactory.getInstance().getFragment(position);
    }

    /**
     * 返回tabLayout对应位置的标题
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
