package com.mangoice.gankio.main;

import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.base.BaseView;
import com.mangoice.gankio.model.GankModel;

import java.util.List;

/**
 * Created by MangoIce on 2017/11/26.
 */

public interface MainContract {
    interface View extends BaseView {
        //首次加载数据
        void setFirstData(GankModel gankModel, int type);
        //底部加载更多
        void setLoadMoreData(List<GankModel> list);
        //showToast
        void showToast(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        //加载首次数据
        void loadFirstData(String category, int pageSize, int page);
        //加载更多数据
        void loadMoreData();
    }
}
