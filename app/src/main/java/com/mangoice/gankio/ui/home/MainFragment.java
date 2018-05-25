package com.mangoice.gankio.ui.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.PagerAdapter;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.Channel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MangoIce on 2017/11/20.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<Channel> channels = new ArrayList<>();

    @Override
    protected void initOptions() {
        channels.add(new Channel(Constant.CATEGORY_ALL, "全部"));
        channels.add(new Channel(Constant.CATEGORY_ANDROID, "Android"));
        channels.add(new Channel(Constant.CATEGORY_IOS, "Ios"));
        channels.add(new Channel(Constant.CATEGORY_FRONT_END, "前端"));
        channels.add(new Channel(Constant.CATEGORY_VIDEO, "休息视频"));
        channels.add(new Channel(Constant.CATEGORY_EXPAND_RESOURCE, "拓展资源"));
        channels.add(new Channel(Constant.CATEGORY_RECOMMEND, "瞎推荐"));
        channels.add(new Channel(Constant.CATEGORY_APP, "APP"));
        channels.add(new Channel(Constant.CATEGORY_GIRL, "福利"));
        mPagerAdapter = new PagerAdapter(getChildFragmentManager(), channels);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initRefreshListener() {

    }
}
