package com.mangoice.gankio.base;

/**
 * Created by MangoIce on 2017/11/17.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
