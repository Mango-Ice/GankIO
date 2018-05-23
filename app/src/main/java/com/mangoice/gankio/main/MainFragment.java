package com.mangoice.gankio.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.GankAdapter;
import com.mangoice.gankio.base.BaseAdapter;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.detail.DetailActivity;
import com.mangoice.gankio.main.show_image.ShowImageActivity;
import com.mangoice.gankio.model.GankModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MangoIce on 2017/11/20.
 */

public class MainFragment extends BaseFragment<MainContract.View, MainPresenter> implements MainContract.View {
    private GankAdapter mGankAdapter;
    private String type;
    private int page = 1;
    private List<GankModel.ResultsBean> list = new ArrayList<>();

    @Override
    protected void initOptions() {
        if (getArguments() != null) {
            type = getArguments().getString("type");
        }
        presenter.loadData(type, Constant.PAGE_SIZE, page, Constant.GET_DATA_TYPE_NORMAL);
        page++;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_base;
    }

    public static MainFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            //更新界面数据，如果数据还在下载中，就显示加载框
            //notifyDataSetChanged();
            //if (mRefreshState == STATE_REFRESHING) {
             //   mRefreshListener.onRefreshing();
            //}
        } else {

            //关闭加载框
            //mRefreshListener.onRefreshFinish();
        }
    }

    @Override
    protected boolean isFragmentVisible() {
        return super.isFragmentVisible();
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        mGankAdapter = new GankAdapter(list, mContext);
        mGankAdapter.setEnableLoadMore(true);
        mGankAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        return mGankAdapter;
    }

    @Override
    public String getApiCategroy() {
        return type;
    }

//    @Override
//    protected RecyclerView.LayoutManager initLayoutManager() {
//        if (type.equals(Constant.CATEGORY_GIRL)) {
//            return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        }
//        return super.initLayoutManager();
//    }

    @Override
    protected int initItemType() {
        if (type.equals(Constant.CATEGORY_GIRL)) {
            return Constant.ITEM_TYPE_GANK_IMAGE;
        }
        return super.initItemType();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setFirstData(List<GankModel.ResultsBean> list, int type) {
        mGankAdapter.addData(list);
    }

    @Override
    public void setLoadMoreData(List<GankModel.ResultsBean> list) {

    }

    @Override
    public void showToast(String msg) {

    }


    @Override
    protected void initItemListener() {
//        mBaseAdapter.setOnBaseClickListener(new BaseAdapter.OnBaseClickListener() {
//            @Override
//            public void onClick(int position, GankModel.ResultsBean data) {
//                if (type.equals(Constant.CATEGORY_GIRL)) {
//                    Intent intent = new Intent(mContext, ShowImageActivity.class);
//                    //传入参数，图片URL地址
//                    ArrayList<String> listPics = new ArrayList<String>();
//                    for (int i = 0; i < mList.size(); i++) {
//                        listPics.add(mList.get(i).getUrl());
//                    }
//                    intent.putStringArrayListExtra("picList", listPics);
//                    intent.putExtra("position", position);
//                    intent.putExtra("page", mPage);
//                    startActivity(intent);
//                } else {
//                    Intent intent = new Intent(mContext, DetailActivity.class);
//                    intent.putExtra("entity", data);
//                    startActivity(intent);
//                }
//            }
//        });
    }
}
