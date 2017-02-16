package com.example.mezi925.googleplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.mezi925.googleplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mezi925 on 2017/2/16.
 * 各个fragment的基类
 */

public abstract class BaseFragment extends Fragment {
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.load_retry)
    Button loadRetry;
    @BindView(R.id.layout_container)
    FrameLayout layoutContainer;
    @BindView(R.id.load_failed_container)
    LinearLayout loadFailedContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_base, null);
        // 绑定视图
        ButterKnife.bind(this, root);
        // 初始化操作
        init();

        return root;
    }

    private void init() {
        startLoadData();
    }

    /**
     * 子类实现该方法加载各自的数据
     */
    public abstract void startLoadData();

    /**
     * 数据加载成功的方法
     */
    public void onDataLoadSuccess() {
        // 隐藏进度条
        progressBar.setVisibility(View.GONE);

        // 加载各个页面的布局
        layoutContainer.addView(onCreateContentView());
    }

    // 创建页面内容的视图，交给子类去实现
    protected abstract View onCreateContentView();

    /**
     * 数据加载失败的方法
     */
    protected void onDataLoadFailed() {
        // 隐藏进度圈
        progressBar.setVisibility(View.GONE);

        // 显示加载失败的布局
        loadFailedContainer.setVisibility(View.VISIBLE);
    }

    /**
     * 重试按钮的封装
     */
    @OnClick(R.id.load_retry)
    public void click() {
        // 隐藏加载失败的布局
        loadFailedContainer.setVisibility(View.GONE);

        // 显示进度圈
        progressBar.setVisibility(View.VISIBLE);

        // 再次开始加载数据
        startLoadData();
    }
}
