package com.mangoice.gankio.ui.news;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.NewsAdapter;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MangoIce on 2017/11/20.
 */

public class NewsFragment extends BaseFragment {

    private String type;
    private List<NewsModel.Data> mList = new ArrayList<>();
    private NewsAdapter mNewsAdapter;
    private int page = 1;

    @Override
    public NewsPresenter createPresenter() {
        return null;
    }


    @Override
    protected boolean isFragmentVisible() {
        return super.isFragmentVisible();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initRefreshListener() {

    }


    @Override
    protected void initOptions() {
        if (getArguments() != null) {
            type = getArguments().getString("type");
        }
    }

    public static NewsFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
