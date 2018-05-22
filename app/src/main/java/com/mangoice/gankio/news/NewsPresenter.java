package com.mangoice.gankio.news;

import com.mangoice.gankio.main.MainContract;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.NewsModel;

import java.util.List;

/**
 * Created by MangoIce on 2018/05/22.
 */

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View mView;
    private List<NewsModel> mList;

    public NewsPresenter() {

    }

    @Override
    public void loadFirstData(String category, int pageSize, int page) {

    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public void attachView(NewsContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
