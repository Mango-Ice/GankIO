package com.mangoice.gankio.ui.weather;

import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.base.BaseView;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.model.WeatherModel;

import java.util.List;

/**
 * Created by MangoIce on 2018/05/22.
 */

public interface WeatherContract {
    interface View extends BaseView {
        //更新数据
        void update(List<WeatherModel.Value> list);
        //加载失败
        void onLoadFail();
        //showToast
        void showToast(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        String getCityId(String cityName);

        void loadData(String cityId);
    }
}
