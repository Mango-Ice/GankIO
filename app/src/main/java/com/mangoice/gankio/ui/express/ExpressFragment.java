package com.mangoice.gankio.ui.express;

import android.os.Bundle;

import com.mangoice.gankio.R;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.model.ExpressModel;

import java.util.List;

/**
 * Created by MangoIce on 2018/5/26.
 */
public class ExpressFragment extends BaseFragment<ExpressContract.View, ExpressPresenter> implements ExpressContract.View {

    public static ExpressFragment newInstance() {
        Bundle args = new Bundle();
        ExpressFragment fragment = new ExpressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ExpressPresenter createPresenter() {
        return new ExpressPresenter();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_express;
    }

    @Override
    protected void initRefreshListener() {

    }

    @Override
    protected void initOptions() {

    }

    @Override
    public void update(List<ExpressModel.Data> list) {

    }

    @Override
    public void onLoadFail() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showError(String msg) {

    }
}
