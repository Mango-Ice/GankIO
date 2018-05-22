package com.mangoice.gankio.base;

/**
 * Created by MangoIce on 2017/11/16.
 */

public interface BaseView {

    //显示下拉刷新
    void showRefresh();
    //隐藏下拉刷新
    void hideRefresh();
    //显示加载动画
    void showLoading();
    //隐藏加载动画
    void hideLoading();
    //显示错误信息
    void showError(String msg);
}
