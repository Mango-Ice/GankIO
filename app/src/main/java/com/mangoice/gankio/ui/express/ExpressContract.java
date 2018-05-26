package com.mangoice.gankio.ui.express;

import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.base.BaseView;
import com.mangoice.gankio.model.ExpressModel;
import com.mangoice.gankio.model.WeatherModel;
import com.mangoice.gankio.ui.weather.WeatherContract;

import java.util.List;
import java.util.Map;

/**
 * Created by MangoIce on 2018/5/26.
 */
public class ExpressContract {
    interface View extends BaseView {
        //更新数据
        void update(List<ExpressModel.Data> list);
        //加载失败
        void onLoadFail();
        //showToast
        void showToast(String msg);
    }

    interface Presenter extends BasePresenter<ExpressContract.View> {
        Map<String, String> getExpressTypeAndCode();

        void loadData(String type, String postId);
    }
}
