package com.mangoice.gankio.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.GankAdapter;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.ui.detail.DetailActivity;
import com.mangoice.gankio.ui.home.show_image.ShowImageActivity;
import com.mangoice.gankio.utils.ToastWrapper;
import com.mangoice.gankio.view.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MangoIce on 2018/5/24.
 */
public class MainDetailFragment extends BaseFragment<MainContract.View, MainPresenter> implements MainContract.View {
    @BindView(R.id.home_fragment_rv) RecyclerView mRecyclerView;
    private GankAdapter mGankAdapter;
    private String type;
    private int page = 1;
    private List<GankModel.ResultsBean> mList = new ArrayList<>();

    public static MainDetailFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        MainDetailFragment fragment = new MainDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home_detail;
    }

    @Override
    protected void initRefreshListener() {
        page = 1;
        presenter.loadData(type, Constant.PAGE_SIZE, page, Constant.GET_DATA_TYPE_NORMAL);
    }

    @Override
    protected void initOptions() {
        if (getArguments() != null) {
            type = getArguments().getString("type");
        }

        mGankAdapter = new GankAdapter(mList, getContext());

        mRecyclerView.setLayoutManager(setLayoutManager());
        mRecyclerView.setAdapter(mGankAdapter);
        mGankAdapter.setEnableLoadMore(true);
        mGankAdapter.setPreLoadNumber(1);
        mGankAdapter.setLoadMoreView(new CustomLoadMoreView());
        mGankAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.loadData(type, Constant.PAGE_SIZE, page, Constant.GET_DATA_TYPE_LOAD_MORE);
                page++;
            }
        }, mRecyclerView);
        mGankAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getItemViewType(position) == Constant.ITEM_TYPE_GANK_IMAGE) {
                    Intent intent = new Intent(mContext, ShowImageActivity.class);
                    //传入参数，图片URL地址
                    ArrayList<String> listPics = new ArrayList<>();
                    for (int i = 0; i < mList.size(); i++) {
                        listPics.add(mList.get(i).getUrl());
                    }
                    intent.putStringArrayListExtra("picList", listPics);
                    intent.putExtra("position", position);
                    intent.putExtra("page", page);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("entity", mList.get(position));
                    startActivity(intent);
                }
            }
        });
        //加载第一次数据
        presenter.loadData(type, Constant.PAGE_SIZE, page, Constant.GET_DATA_TYPE_NORMAL);
        page++;

    }

    private RecyclerView.LayoutManager setLayoutManager() {
        if (type.equals(Constant.CATEGORY_GIRL)) {
            return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        }
        return new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    }


    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();

    }

    @Override
    public void setFirstData(List<GankModel.ResultsBean> list, int type) {
        mGankAdapter.addData(list);
    }

    @Override
    public void setLoadMoreData(List<GankModel.ResultsBean> list) {
        mGankAdapter.setNewData(list);
    }

    @Override
    public void onLoadFail() {
        mGankAdapter.loadMoreFail();
    }

    @Override
    public void showToast(String msg) {
        ToastWrapper.makeShortToast(msg);
    }

    @Override
    public void showError(String msg) {
        Log.d("MainDetailFragment>>>>>", msg);
    }
}
