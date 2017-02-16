package com.example.mezi925.googleplay.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by mezi925 on 2017/2/16.
 * activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 获取布局的资源id
        setContentView(getLayoutResourceId());

        // 绑定控件
        ButterKnife.bind(this);

        // 初始化事件
        init();
    }

    public void init() {
    }

    // 子类必须实现
    public abstract int getLayoutResourceId();
}
