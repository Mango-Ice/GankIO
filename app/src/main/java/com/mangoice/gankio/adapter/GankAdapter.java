package com.mangoice.gankio.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.utils.MyUtils;
import com.mangoice.gankio.utils.TimeUtils;
import com.mangoice.gankio.utils.image.ImageUtils;

import java.util.List;

/**
 * Created by MangoIce on 2018/5/23.
 */
public class GankAdapter extends BaseMultiItemQuickAdapter<GankModel.ResultsBean, BaseViewHolder> {
    private Context mContext;


    public GankAdapter(List<GankModel.ResultsBean> data, Context context) {
        super(data);
        this.mContext = context;
        addItemType(Constant.ITEM_TYPE_GANK_TEXT, R.layout.item_gank_rv);
        addItemType(Constant.ITEM_TYPE_GANK_IMAGE, R.layout.item_gank_rv);
    }

    @Override
    protected void convert(BaseViewHolder holder, GankModel.ResultsBean bean) {
        switch (holder.getItemViewType()) {
            case Constant.ITEM_TYPE_GANK_TEXT:
                holder.setText(R.id.tv_title, bean.getDesc());
                holder.setText(R.id.tv_author, bean.getWho());
                holder.setText(R.id.tv_time, TimeUtils.getFriendlyTimeSpanByNow(MyUtils.formatDateFromStr(bean.getPublishedAt())));

                if (bean.getImages() != null && bean.getImages().size() > 0) {
                    //显示图片
                    holder.getView(R.id.iv_cover).setVisibility(View.VISIBLE);
                    ImageUtils.getInstance()
                            .loadImage(mContext,
                                    bean.getImages().get(0),
                                    (ImageView) holder.getView(R.id.iv_cover));
                } else {
                    //隐藏图片
                    holder.getView(R.id.iv_cover).setVisibility(View.GONE);
                }
                break;
            case Constant.ITEM_TYPE_GANK_IMAGE:
                break;
        }
    }
}
