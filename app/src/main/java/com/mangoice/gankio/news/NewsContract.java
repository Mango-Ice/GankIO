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
        void setFirstData(List<NewsModel.Data> list, int type);
        //底部加载更多
        void setLoadMoreData(List<NewsModel.Data> list);
        //showToast
        void showToast(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData(String category, int page, int loadMoreType);
    }
}
