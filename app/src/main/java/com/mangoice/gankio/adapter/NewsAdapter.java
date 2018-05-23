package com.mangoice.gankio.adapter;

<<<<<<< Updated upstream
/**
 * Created by MangoIce on 2018/5/23.
 */
public class NewsAdapter {
=======
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.NewsModel;
import com.mangoice.gankio.utils.TimeUtils;

import java.util.List;

/**
 * Created by MangoIce on 2018/5/23.
 */
public class NewsAdapter extends BaseQuickAdapter<NewsModel.Data, BaseViewHolder> {
    private Context mContext;

    public NewsAdapter(int layoutResId, @Nullable List<NewsModel.Data> data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
        //addItemType(Constant.ITEM_TYPE_NEWS_TEXT, R.layout.item_news_rv);
       // addItemType(Constant.ITEM_TYPE_NEWS_IMAGE, R.layout.item_news_rv);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsModel.Data bean) {

        holder.setText(R.id.tv_news_title, bean.getContent().getTitle());
        holder.setText(R.id.tv_media_name, bean.getContent().getMediaName());
        holder.setText(R.id.tv_time, TimeUtils.getFriendlyTimeSpanByNow(TimeUtils.millis2String(bean.getContent().getPublishTime())));

    }
>>>>>>> Stashed changes
}
