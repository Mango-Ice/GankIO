package com.mangoice.gankio.ui.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.HomePagerAdapter;
import com.mangoice.gankio.adapter.NewsPagerAdapter;
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

public class NewsFragment extends BaseFragment {
    @BindView(R.id.news_tabs)
    TabLayout mTabLayout;
    @BindView(R.id.news_view_pager)
    ViewPager mViewPager;
    private NewsPagerAdapter mPagerAdapter;
    private List<Channel> channels = new ArrayList<>();

    @Override
    protected void initOptions() {
        channels.add(new Channel(Constant.CATEGORY_NEWS_HOT, "热点"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_VIDEO, "视频"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_SOCIETY, "社会"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_ENTERTAINMENT, "娱乐"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_QA, "问答"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_TECH, "科技"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_CAR, "汽车"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_SPORT, "体育"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_FINANCE, "财经"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_MILITARY, "军事"));
        channels.add(new Channel(Constant.CATEGORY_NEWS_WORLD, "国际"));
        channels.add(new Channel(Constant.CATEGORY_ESSAY_JOKE, "段子"));
        channels.add(new Channel(Constant.CATEGORY_IMAGE_FUNNY, "趣图"));
        mPagerAdapter = new NewsPagerAdapter(getChildFragmentManager(), channels);
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
        return R.layout.fragment_news;
    }

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
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
