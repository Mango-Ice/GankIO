package com.mangoice.gankio.ui.home;



import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.FragmentPagerAdapter;
import com.mangoice.gankio.base.BaseActivity;
import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.ui.express.ExpressFragment;
import com.mangoice.gankio.ui.news.NewsFragment;
import com.mangoice.gankio.ui.weather.WeatherFragment;
import com.mangoice.gankio.utils.BottomNavigationHelper;
import com.mangoice.gankio.utils.ResourceHelper;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomView;
    private FragmentPagerAdapter mPagerAdapter;
    private Fragment currentFragment = new Fragment();
    private boolean isToolbarShow = true;
    private String currentToolbarName;

    @Override
    protected void initOptions() {
        initFragment();
        //通过反射去掉BottomNavigation显示效果
        BottomNavigationHelper.disableShiftMode(mBottomView);
        mBottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        currentToolbarName = null;
                        setToolbarShow(true);
                        updateOptionsMenu(menu);
                        showHideFragment(mPagerAdapter.getItem(0));
                        return true;
                    case R.id.navigation_news:
                        currentToolbarName = null;
                        setToolbarShow(true);
                        updateOptionsMenu(menu);
                        showHideFragment(mPagerAdapter.getItem(1));
                        return true;
                    case R.id.navigation_weather:
                        currentToolbarName = "北京";
                        setToolbarShow(true);
                        updateOptionsMenu(menu);
                        showHideFragment(mPagerAdapter.getItem(2));
                        return true;
                    case R.id.navigation_express:
                        currentToolbarName = "快递查询";
                        setToolbarShow(true);
                        updateOptionsMenu(menu);
                        showHideFragment(mPagerAdapter.getItem(3));
                        return true;
                    case R.id.navigation_me:
                        return true;
                }
                return false;
            }
        });
    }

    private void showHideFragment(Fragment showFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (!showFragment.isAdded()) {
            if (currentFragment != null) {
                ft.hide(currentFragment);
            }
            ft.add(R.id.fragment, showFragment);
        } else {
            ft.hide(currentFragment).show(showFragment);
        }
        currentFragment = showFragment;
        ft.commit();
    }

    private void initFragment() {
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(MainFragment.newInstance(), "主页");
        mPagerAdapter.addFragment(NewsFragment.newInstance(), "头条");
        mPagerAdapter.addFragment(WeatherFragment.newInstance(), "天气");
        mPagerAdapter.addFragment(ExpressFragment.newInstance(), "快递");
        showHideFragment(mPagerAdapter.getItem(0));
    }

    @Override
    protected String initToolbarTitle() {
        if (isToolbarShow && currentToolbarName != null) {
            return currentToolbarName;
        } else {
            return ResourceHelper.getString(R.string.app_name);
        }
    }

    public void setToolbarShow(boolean isShow) {
        if (isShow) {
            isToolbarShow = true;
        } else {
            isToolbarShow = false;
        }
        setToolbar();
    }

    @Override
    protected View initContentView() {
        return View.inflate(this, R.layout.activity_main, null);
    }

    @Override
    protected void updateOptionsMenu(Menu menu) {
        super.updateOptionsMenu(menu);
        if (currentToolbarName != null) {
            menu.findItem(R.id.action_search).setVisible(false);
            menu.findItem(R.id.action_download).setVisible(false);
            menu.findItem(R.id.action_collect).setVisible(false);
            menu.findItem(R.id.action_share).setVisible(true);
            menu.findItem(R.id.action_city_manager).setVisible(true);
        } else {
            menu.findItem(R.id.action_search).setVisible(true);
            menu.findItem(R.id.action_download).setVisible(false);
            menu.findItem(R.id.action_collect).setVisible(false);
            menu.findItem(R.id.action_share).setVisible(false);
            menu.findItem(R.id.action_city_manager).setVisible(false);
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void setToolbarDisplayEnabled() {
        //关闭返回按钮
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}
