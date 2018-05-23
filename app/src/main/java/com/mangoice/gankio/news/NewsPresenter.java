package com.mangoice.gankio.news;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.main.MainContract;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.ResourceHelper;
import com.mangoice.gankio.utils.TimeUtils;
import com.mangoice.gankio.utils.ToastWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2018/05/22.
 */

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View mView;
    private List<NewsModel.Data> mList = new ArrayList<>();
    private Map<String, String> options = new HashMap<>();

    public NewsPresenter() {

    }

    @Override
    public void attachView(NewsContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    /**
     * 固定下options
     */
    private void setOptions() {
        options.clear();
        options.put("category", Constant.CATEGORY_NEWS_HOT);     //Category
        options.put("refer", String.valueOf(1));
        options.put("count", String.valueOf(Constant.PAGE_SIZE));
        options.put("min_behot_time", String.valueOf(TimeUtils.getNowMills() - 100));
        options.put("last_refresh_sub_entrance_interval", String.valueOf(TimeUtils.getNowMills()));
        options.put("loc_mode", String.valueOf(6));
        options.put("loc_time", String.valueOf(TimeUtils.getNowMills()));
        options.put("latitude", String.valueOf(28.687511709859));
        options.put("longitude", String.valueOf(116.02067822305));
        options.put("city", "Beijing");
        options.put("tt_from", "");
        options.put("lac", "");
        options.put("cid", "");
        options.put("cp", "");
        options.put("iid", "5463251478");
        options.put("device_id", "12345678952");
        options.put("ac", "");
        options.put("channel", "");
        options.put("aid", "");
        options.put("app_name", "");
        options.put("version_code", "");
        options.put("version_name", "");
        options.put("device_platform", "");
        options.put("ab_version", "");
        options.put("ab_client", "");
        options.put("ab_group", "");
        options.put("ab_feature", "");
        options.put("abflag", "");
        options.put("ssmix", "");
        options.put("device_type", "");
        options.put("device_brand", "");
        options.put("language", "");
        options.put("os_api", "");
        options.put("os_version", "");
        options.put("openudid", "123456789d36d6z6");
        options.put("manifest_version_code", "");
        options.put("resolution", "");
        options.put("dpi", "");
        options.put("update_version_code", "");
        options.put("_rticket", "");
    }

    @Override
    public void loadData(String category, int page, final int loadMoreType) {
        Api api = NetManager.getInstance().getNewsApiService();
        setOptions();
        api.getNewsData(options)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull NewsModel newsModel) {
                        if (newsModel.getMessage().contains("fail")) {
                            ToastWrapper.makeShortToast(ResourceHelper.getString(R.string.network_error));
                            return;
                        }
                        if (Constant.GET_DATA_TYPE_NORMAL == loadMoreType) {
                            mList.clear();
                            mList = newsModel.getData();
                            mView.setFirstData(mList, Constant.GET_DATA_TYPE_NORMAL);
                        } else {
                            //加载更多
                            mList.addAll(newsModel.getData());
                            mView.setLoadMoreData(mList);
                        }
                        mView.hideLoading();
                        mView.hideRefresh();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.hideLoading();
                        mView.hideRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideRefresh();
                        mView.hideLoading();
                    }
                });
    }
}
