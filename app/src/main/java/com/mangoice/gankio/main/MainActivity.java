package com.mangoice.gankio.main;



import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.FragmentPagerAdapter;
import com.mangoice.gankio.base.BaseActivity;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.news.NewsFragment;
import com.mangoice.gankio.utils.BottomNavigationHelper;
import com.mangoice.gankio.utils.ResourceHelper;

import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainContract.View, MainPresenter> implements MainContract.View {
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tabs) TabLayout mTabLayout;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomView;
    private FragmentPagerAdapter mPagerAdapter;

    private void initHomeViewPager() {
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.cleanAll();
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_ALL), "全部");
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_ANDROID), Constant.CATEGORY_ANDROID);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_IOS), Constant.CATEGORY_IOS);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_FRONT_END), Constant.CATEGORY_FRONT_END);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_VIDEO), Constant.CATEGORY_VIDEO);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_EXPAND_RESOURCE), Constant.CATEGORY_EXPAND_RESOURCE);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_RECOMMEND), Constant.CATEGORY_RECOMMEND);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_APP), Constant.CATEGORY_APP);
        mPagerAdapter.addFragment(MainFragment.newInstance(Constant.CATEGORY_GIRL), Constant.CATEGORY_GIRL);
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initNewsViewPager() {
        mPagerAdapter.cleanAll();
        mPagerAdapter.addFragment(NewsFragment.newInstance(Constant.CATEGORY_NEWS_HOT), "热点");
        mPagerAdapter.addFragment(NewsFragment.newInstance(Constant.CATEGORY_NEWS_VIDEO), "视频");
        mPagerAdapter.addFragment(NewsFragment.newInstance(Constant.CATEGORY_NEWS_SOCIETY), "社会");
        mPagerAdapter.addFragment(NewsFragment.newInstance(Constant.CATEGORY_NEWS_ENTERTAINMENT), "娱乐");
        mPagerAdapter.addFragment(NewsFragment.newInstance(Constant.CATEGORY_NEWS_QA), "问答");
        mPagerAdapter.addFragment(NewsFragment.newInstance(Constant.CATEGORY_NEWS_TECH), "科技");
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    protected void initOptions() {

        initHomeViewPager();
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
        BottomNavigationHelper.disableShiftMode(mBottomView);
        mBottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        initHomeViewPager();
                        mViewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_news:
                        initNewsViewPager();
//                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                        ft.replace(R.id.fragment, mPagerAdapter.getItem(0));
//                        ft.commit();
                        NewsFragment.newInstance(Constant.CATEGORY_NEWS_HOT).getData(Constant.GET_DATA_TYPE_NORMAL);
                        //mViewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_me:
                        mViewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected String initToolbarTitle() {
        return ResourceHelper.getString(R.string.app_name);
    }

    @Override
    protected View initContentView() {
        View view = View.inflate(this, R.layout.activity_main, null);
        return view;
    }

    @Override
    protected void updateOptionsMenu(Menu menu) {
        super.updateOptionsMenu(menu);
        menu.findItem(R.id.action_download).setVisible(false);
        menu.findItem(R.id.action_collect).setVisible(false);
        menu.findItem(R.id.action_share).setVisible(false);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void setToolbarDisplayEnabled() {
        //关闭返回按钮
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setFirstData(GankModel gankModel, int type) {

    }

    @Override
    public void setLoadMoreData(List<GankModel> list) {

    }

    @Override
    public void showToast(String msg) {

    }
}
