package com.mangoice.gankio.main;

import android.support.annotation.NonNull;

import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.ResourceHelper;
import com.mangoice.gankio.utils.ToastWrapper;

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
    private List<GankModel> mList;

    public MainPresenter() {

    }

    @Override
    public void loadFirstData(String category, int pageSize, int page) {

    }

    @Override
    public void loadMoreData() {

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
