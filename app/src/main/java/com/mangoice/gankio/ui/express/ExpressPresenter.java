package com.mangoice.gankio.ui.express;


import android.support.annotation.NonNull;

import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.ExpressModel;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.WeatherModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.ResourceHelper;
import com.mangoice.gankio.utils.ToastWrapper;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2018/5/26.
 */
public class ExpressPresenter implements ExpressContract.Presenter {
    private ExpressContract.View mView;

    @Override
    public Map<String, String> getExpressTypeAndCode() {

        return null;
    }

    @Override
    public void loadData(String type, String postId) {
        Api api = NetManager.getInstance().getExpressApiService();
        api.getExpressData(type, postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExpressModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ExpressModel expressModel) {
                        if (!expressModel.getStatus().equals("200")) {
                            ToastWrapper.makeShortToast(ResourceHelper.getString(R.string.network_error));
                            return;
                        }
                        mView.update(expressModel.getData());
                        mView.hideLoading();
                        mView.hideRefresh();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.showError(e.toString());
                        mView.onLoadFail();
                        mView.hideLoading();
                        mView.hideRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideRefresh();
                        mView.hideLoading();
                    }
                });
    }

    @Override
    public void attachView(ExpressContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
