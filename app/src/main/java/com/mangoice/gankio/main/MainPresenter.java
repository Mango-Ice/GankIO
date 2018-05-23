package com.mangoice.gankio.main;

import android.support.annotation.NonNull;

import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.ResourceHelper;
import com.mangoice.gankio.utils.ToastWrapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2017/11/26.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private List<GankModel.ResultsBean> mList = new ArrayList<>();

    public MainPresenter() {

    }

    @Override
    public void loadData(String category, int pageSize, int page, final int loadMoreType) {
        Api api = NetManager.getInstance().getApiService();
        api.getGankData(category, Constant.PAGE_SIZE, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GankModel gankModel) {
                        if (gankModel.getError()) {
                            ToastWrapper.makeShortToast(ResourceHelper.getString(R.string.network_error));
                            return;
                        }
                        if (Constant.GET_DATA_TYPE_NORMAL == loadMoreType) {
                            mList.clear();
                            mList = gankModel.getResults();
                            mView.setFirstData(mList, Constant.GET_DATA_TYPE_NORMAL);
                            mView.hideLoading();
                            mView.hideRefresh();
                        } else {
                            //加载更多
                            mList.addAll(gankModel.getResults());
                            mView.setLoadMoreData(mList);
                            mView.hideLoading();
                            mView.hideRefresh();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
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
    public void attachView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
