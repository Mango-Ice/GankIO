package com.mangoice.gankio.news;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.GankAdapter;
import com.mangoice.gankio.adapter.NewsAdapter;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.TimeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2017/11/20.
 */

public class NewsFragment extends BaseFragment<NewsContract.View, NewsPresenter> implements NewsContract.View {

    private String type;
    private List<NewsModel.Data> mList = new ArrayList<>();
    private NewsAdapter mNewsAdapter;
    private int page = 1;

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter();
    }

    @Override
    public String getApiCategroy() {
        return type;
    }

    @Override
    protected boolean isFragmentVisible() {
        return super.isFragmentVisible();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_base;
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        mNewsAdapter = new NewsAdapter(R.layout.item_news_rv, mList, mContext);
        mNewsAdapter.setEnableLoadMore(true);
        mNewsAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        return mNewsAdapter;
    }

    @Override
    protected void initOptions() {
        if (getArguments() != null) {
            type = getArguments().getString("type");
        }
        presenter.loadData(type, page, Constant.GET_DATA_TYPE_NORMAL);
        page++;
    }

    public static NewsFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setFirstData(List<NewsModel.Data> list, int type) {
        mNewsAdapter.addData(list);
    }


    @Override
    public void setLoadMoreData(List<NewsModel.Data> list) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showError(String msg) {

    }
}
