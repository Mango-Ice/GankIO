package com.mangoice.gankio.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.mangoice.gankio.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.loading_view) AVLoadingIndicatorView mLoading;
    LinearLayout mRootView;
    private Unbinder mUnbinder;
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mRootView = findViewById(R.id.root_view);
        //具体的布局由子类实现
        mRootView.addView(initContentView());
        mUnbinder = ButterKnife.bind(this);
        //加载Toolbar
        initToolbar();

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }

        //加载子类逻辑
        initOptions();
    }

    /**
     * 子类完成具体的逻辑操作
     */
    protected abstract void initOptions();

    /**
     * 加载Toolbar
     */
    public void initToolbar() {
        if (initToolbarTitle() == null) {
            mToolbar.setVisibility(View.GONE);
        } else {
            mToolbar.setTitle(initToolbarTitle());
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setToolbarDisplayEnabled();
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }

    /**
     * 加载Toolbar标题
     * @return
     */
    protected abstract String initToolbarTitle();

    /**
     * 设置Toolbar返回按钮是否开启
     */
    protected void setToolbarDisplayEnabled() {

    }

    /**
     * 加载Menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base, menu);
        updateOptionsMenu(menu);
        return true;
    }

    /**
     * 子类有需求可更改Menu
     * @param menu
     */
    protected void updateOptionsMenu(Menu menu) {

    }

    /**
     * 设置Presenter
     */
    protected abstract T createPresenter();

    /**
     * 子类实现具体的布局
     * @return
     */
    protected abstract View initContentView();

    /**
     * 显示加载动画
     */
    public void showLoading(){
        mLoading.smoothToShow();
    }

    /**
     * 隐藏加载动画
     */
    public void hideLoading(){
        mLoading.smoothToHide();
    }

    /**
     * 分享
     *
     * @param type
     */
    public void startShare(String type, String content) {
        Intent share_intent = new Intent();
        share_intent.setAction(Intent.ACTION_SEND);
        share_intent.setType(type);
        share_intent.putExtra(Intent.EXTRA_TEXT, content);
        share_intent = Intent.createChooser(share_intent, "分享");
        startActivity(share_intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
