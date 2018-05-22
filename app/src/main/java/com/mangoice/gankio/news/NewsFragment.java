package com.mangoice.gankio.news;

import android.os.Bundle;
import android.util.Log;

import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.TimeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2017/11/20.
 */

public class NewsFragment extends BaseFragment<NewsContract.View, NewsPresenter> implements NewsContract.View {
    private Map<String, String> options = new HashMap<>();
    private String type;
    private List<NewsModel.Data> mList = new ArrayList<>();

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter();
    }

    @Override
    public String getApiCategroy() {
        return type;
    }

    @Override
    protected boolean isFragmentVisible() {
        return super.isFragmentVisible();
    }

    @Override
    protected void initOptions() {
        if (getArguments() != null) {
            type = getArguments().getString("type");
        }
    }

    public static NewsFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(bundle);
        return fragment;
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


    public void getData(final int type) {
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
                    public void onNext(NewsModel newsModel) {
                        if (Constant.GET_DATA_TYPE_NORMAL == type) {
                            mList.clear();
                            mList = newsModel.getData();

                        } else {
                            //加载更多模式
                            mList.addAll(newsModel.getData());
                        }
                        if (newsModel.getData().size() < Constant.PAGE_SIZE) {
                            isLoadMore = false;
                        }
                        Log.d("NewsFragment :::::::", String.valueOf(mList.get(0).getContent().getTitle()));
                        Log.d("NewsFragment :::::::", String.valueOf(mList.get(1).getContent().getTitle()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("NewsFragment :::::::", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void setFirstData(NewsModel newsModel, int type) {

    }

    @Override
    public void setLoadMoreData(List<NewsModel> list) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showError(String msg) {

    }
}
