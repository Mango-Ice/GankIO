package com.mangoice.gankio.news;

import com.mangoice.gankio.base.BasePresenter;
import com.mangoice.gankio.base.BaseView;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.NewsModel;

import java.util.List;

/**
 * Created by MangoIce on 2018/05/22.
 */

public interface NewsContract {
    interface View extends BaseView {
        //首次加载数据
        void setFirstData(NewsModel newsModel, int type);
        //底部加载更多
        void setLoadMoreData(List<NewsModel> list);
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
