package com.mangoice.gankio.ui.home;

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
        void setFirstData(List<GankModel.ResultsBean> list, int type);
        //底部加载更多
        void setLoadMoreData(List<GankModel.ResultsBean> list);
        //加载失败
        void onLoadFail();
        //showToast
        void showToast(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData(String category, int pageSize, int page, int loadMoreType);
    }
}
