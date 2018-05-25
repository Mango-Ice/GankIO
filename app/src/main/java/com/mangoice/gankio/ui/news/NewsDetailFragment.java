package com.mangoice.gankio.ui.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.GankAdapter;
import com.mangoice.gankio.adapter.NewsAdapter;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.ui.detail.DetailActivity;
import com.mangoice.gankio.ui.home.MainDetailFragment;
import com.mangoice.gankio.ui.home.show_image.ShowImageActivity;
import com.mangoice.gankio.utils.ToastWrapper;
import com.mangoice.gankio.view.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MangoIce on 2018/5/25.
 */
public class NewsDetailFragment extends BaseFragment<NewsContract.View, NewsPresenter> implements NewsContract.View {
    @BindView(R.id.news_fragment_rv)
    RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;
    private String type;
    private int page = 1;
    private List<NewsModel.Data> mList = new ArrayList<>();

    public static NewsDetailFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected void initRefreshListener() {
        page = 1;
        presenter.loadData(type, page, Constant.GET_DATA_TYPE_NORMAL);
    }

    @Override
    protected void initOptions() {
        if (getArguments() != null) {
            type = getArguments().getString("type");
        }

        mNewsAdapter = new NewsAdapter(R.layout.item_news_rv, mList, getContext());

        mRecyclerView.setLayoutManager(setLayoutManager());
        mRecyclerView.setAdapter(mNewsAdapter);
        mNewsAdapter.setEnableLoadMore(true);
        mNewsAdapter.setPreLoadNumber(1);
        mNewsAdapter.setLoadMoreView(new CustomLoadMoreView());
        mNewsAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.loadData(type, page, Constant.GET_DATA_TYPE_LOAD_MORE);
                page++;
            }
        }, mRecyclerView);
        mNewsAdapter.setEmptyView(R.layout.empty_view);
        mNewsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("type", "news");
                intent.putExtra("entity", mList.get(position).getContent());
                startActivity(intent);
            }
        });
        //加载第一次数据
        presenter.loadData(type, page, Constant.GET_DATA_TYPE_NORMAL);
        page++;

    }

    private RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @Override
    public void setFirstData(List<NewsModel.Data> list, int type) {
        mNewsAdapter.addData(list);
    }

    @Override
    public void setLoadMoreData(List<NewsModel.Data> list) {
        mNewsAdapter.setNewData(list);
    }

    @Override
    public void onLoadFail() {
        mNewsAdapter.loadMoreFail();
    }

    @Override
    public void showToast(String msg) {
        ToastWrapper.makeShortToast(msg);
    }

    @Override
    public void showError(String msg) {
        Log.d("NewsDetailFragment>>>>>", msg);
    }
}
