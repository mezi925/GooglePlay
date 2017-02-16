package com.example.mezi925.googleplay;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.example.mezi925.googleplay.adapter.MainPagerAdapter;
import com.example.mezi925.googleplay.ui.activity.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        super.init();
        initActionBar();
        String[] titles = getResources().getStringArray(R.array.main_titles);

        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),
                titles));
        // 关联viewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initActionBar() {
        // 设置toolBar替换actionBar
        setSupportActionBar(mToolBar);

        ActionBar supportActionBar = getSupportActionBar();

        supportActionBar.setDisplayHomeAsUpEnabled(true);   // 设置返回按钮是否可见

        // 打开drawerLayout的开关
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, R.string.open, R.string.close);

        // 同步drawerLayout的状态，根据开关显示不同的图片，关则显示抽屉图片，打开则显示返回按钮的图片
        actionBarDrawerToggle.syncState();

        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

}
