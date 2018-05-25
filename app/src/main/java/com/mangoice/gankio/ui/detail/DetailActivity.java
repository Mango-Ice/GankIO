package com.mangoice.gankio.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.mangoice.gankio.R;
import com.mangoice.gankio.base.BaseActivity;
import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.utils.ToastWrapper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by MangoIce on 2018/5/8.
 */

public class DetailActivity extends BaseActivity {
    @BindView(R.id.webview) WebView mWebView;
    private Unbinder mUnbinder;
    private View mView;
    private View customView;
    private GankModel.ResultsBean resultsBean;
    private String url;
    private FrameLayout fullscreenContainer;
    private WebChromeClient.CustomViewCallback customViewCallback;
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


    @Override
    protected void initOptions() {
        mUnbinder = ButterKnife.bind(this);

        resultsBean = (GankModel.ResultsBean) getIntent().getSerializableExtra("entity");
        url = resultsBean.getUrl();
        showLoading();
        if (url.isEmpty()) {
            ToastWrapper.makeShortToast("The Web Address is error");
            return;
        }
        initWebView();
        mWebView.loadUrl(url);
    }

    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();
        //支持js脚本
        webSettings.setJavaScriptEnabled(true);
        //支持缩放
        webSettings.setSupportZoom(true);
        //支持内容重新布局
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //多窗口
        webSettings.supportMultipleWindows();
        //当webview调用requestFocus时为webview设置节点
        webSettings.setNeedInitialFocus(true);
        //设置支持缩放
        //webSettings.setBuiltInZoomControls(false);
        //suofang
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webSettings.setLoadsImagesAutomatically(true);

        //支持通过JS打开新窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //缓存配置
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 开启H5(APPCache)缓存功能
        webSettings.setAppCacheEnabled(true);
        // 开启 DOM storage 功能
        webSettings.setDomStorageEnabled(true);
        // 应用可以有数据库
        webSettings.setDatabaseEnabled(true);
        // 可以读取文件缓存(manifest生效)
        webSettings.setAllowFileAccess(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url == null) return false;
                //判断是否为重定向
                WebView.HitTestResult hit = view.getHitTestResult();

                try {
                    if(url.startsWith("miaopai://") //秒拍
                            || url.startsWith("bilibili://")   //bilibili
                            || url.startsWith("snssdk1128://")  //抖音
                            ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    return true;
                }

                view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    //网页加载完成
                    hideLoading();
                }
            }

            @Nullable
            @Override
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(DetailActivity.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                return frameLayout;
            }

            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
               showCustomView(view, callback);
            }

            @Override
            public void onHideCustomView() {
               hideCustomView();
            }
        });
    }

    private void showCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        if (view != null) {
            callback.onCustomViewHidden();
            return;
        }
        DetailActivity.this.getWindow().getDecorView();

        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        fullscreenContainer = new FullscreenHolder(DetailActivity.this);
        fullscreenContainer.addView(view, COVER_SCREEN_PARAMS);
        decor.addView(fullscreenContainer, COVER_SCREEN_PARAMS);
        customView = view;
        setStatusBarVisibility(false);
        customViewCallback = callback;
    }

    private void hideCustomView() {
        if (customView == null) {
            return;
        }

        setStatusBarVisibility(true);
        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        decor.removeView(fullscreenContainer);
        fullscreenContainer = null;
        customView = null;
        customViewCallback.onCustomViewHidden();
        mWebView.setVisibility(View.VISIBLE);
    }


    private void setStatusBarVisibility(boolean visible) {
        int flag = visible ? 0 : WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(android.R.color.black));
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return true;
        }
    }

    @Override
    protected String initToolbarTitle() {
        return "详情";
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected View initContentView() {
        mView = View.inflate(this, R.layout.activity_detail, null);
        return mView;
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        if (customView != null) {
//            hideCustomView();
//        } else if (mWebView.canGoBack()) {
//            mWebView.goBack();
//        } else {
//            finish();
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && customView != null) {
//            hideCustomView();
//            return true;
//        } else
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        } else {
            finish();
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    @Override
    protected void onDestroy() {
        //清除缓存
        mWebView.clearCache(true);
        //清除历史记录
        mWebView.clearHistory();
        mWebView.destroy();
        mUnbinder.unbind();
        super.onDestroy();
    }
}