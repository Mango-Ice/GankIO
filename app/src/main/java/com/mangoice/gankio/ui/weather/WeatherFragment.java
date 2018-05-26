package com.mangoice.gankio.ui.weather;

import android.os.Bundle;
import android.util.Log;

import com.mangoice.gankio.R;
import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.model.WeatherModel;
import com.mangoice.gankio.ui.home.MainActivity;


import java.util.List;
import java.util.Objects;

/**
 * Created by MangoIce on 2018/5/25.
 */
public class WeatherFragment extends BaseFragment<WeatherContract.View, WeatherPresenter> implements WeatherContract.View {
    private String cityId;

    public static WeatherFragment newInstance() {
        Bundle args = new Bundle();
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public WeatherPresenter createPresenter() {
        return new WeatherPresenter();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initRefreshListener() {

    }

    @Override
    protected void initOptions() {
        cityId = presenter.getCityId("北京");
        presenter.loadData(cityId);
    }

    @Override
    public void update(List<WeatherModel.Value> list) {
        Log.d("WeatherFragment>>>>>>>", list.get(0).getRealtime().getWeather());
    }

    @Override
    public void onLoadFail() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showError(String msg) {
        Log.d("WeatherFragment>>>>>>>", msg);
    }
}
