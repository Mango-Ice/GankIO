package com.mangoice.gankio.ui.weather;

import android.support.annotation.NonNull;

import com.mangoice.gankio.base.App;
import com.mangoice.gankio.model.WeatherAddressModel;
import com.mangoice.gankio.model.WeatherModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.MyUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2018/5/25.
 */
public class WeatherPresenter implements WeatherContract.Presenter {
    private WeatherContract.View mView;

    @Override
    public String getCityId(String cityName) {
        WeatherAddressModel model = MyUtils.getJsonFromAssets("Meizu_cities.json", App.getContext());
        for (WeatherAddressModel.Cities ci : model.getCities()) {
            if (ci.getCity().equals(cityName)) {
                return ci.getCityid();
            }
        }
        return null;
    }

    @Override
    public void loadData(String cityId) {
        Api api = NetManager.getInstance().getWeatherApiService();
        api.getWeatherData(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WeatherModel weatherModel) {
                        mView.update(weatherModel.getValue());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onLoadFail();
                        mView.showError(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(WeatherContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
