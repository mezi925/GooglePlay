package com.example.mezi925.googleplay.factory;

import android.support.v4.app.Fragment;

import com.example.mezi925.googleplay.ui.fragment.AppFragment;
import com.example.mezi925.googleplay.ui.fragment.CategoryFragment;
import com.example.mezi925.googleplay.ui.fragment.GameFragment;
import com.example.mezi925.googleplay.ui.fragment.HomeFragment;
import com.example.mezi925.googleplay.ui.fragment.HotFragment;
import com.example.mezi925.googleplay.ui.fragment.RecommendFragment;
import com.example.mezi925.googleplay.ui.fragment.SubjectFragment;

/**
 * Created by mezi925 on 2017/2/16.
 * 生产各种fragment的工厂类
 */

public class FragmentFactory {

    private static FragmentFactory mInstance;

    private final static int FRAGMENT_HOME = 0;
    private final static int FRAGMENT_APP = 1;
    private final static int FRAGMENT_GAME = 2;
    private final static int FRAGMENT_SUBJECT = 3;
    private final static int FRAGMENT_RECOMMEND = 4;
    private final static int FRAGMENT_CATEGORY = 5;
    private final static int FRAGMENT_HOT = 6;

    // 私有构造
    private FragmentFactory() {
    }

    public static FragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (FragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new FragmentFactory();
                }
            }
        }
        return mInstance;
    }

    public static Fragment getFragment(int id) {
        // 生产不同类型的fragment
        Fragment fragment = new Fragment();
        switch (id) {
            case FRAGMENT_HOME:
                fragment = new HomeFragment();
                break;

            case FRAGMENT_APP:
                fragment = new AppFragment();
                break;

            case FRAGMENT_GAME:
                fragment = new GameFragment();
                break;

            case FRAGMENT_SUBJECT:
                fragment = new SubjectFragment();
                break;

            case FRAGMENT_RECOMMEND:
                fragment = new RecommendFragment();
                break;

            case FRAGMENT_CATEGORY:
                fragment = new CategoryFragment();
                break;

            case FRAGMENT_HOT:
                fragment = new HotFragment();
                break;
        }
        return fragment;
    }
}
