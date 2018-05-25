package com.mangoice.gankio.base;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mangoice.gankio.R;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.utils.MyUtils;
import com.mangoice.gankio.utils.TimeUtils;
import com.mangoice.gankio.utils.image.ImageUtils;

import java.util.List;

/**
 * Created by MangoIce on 2017/11/22.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {
    private Context mCotext;
    private List<GankModel.ResultsBean> mList;
    private int mItemType;
    private OnBaseClickListener onBaseClickListener;

    public BaseAdapter(Context context, List<GankModel.ResultsBean> mList, int itemType) {
        this.mCotext = context;
        this.mList = mList;
        this.mItemType = itemType;
    }

    public interface OnBaseClickListener {
        void onClick(int position, GankModel.ResultsBean data);
    }

    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (mItemType == Constant.ITEM_TYPE_GANK_TEXT) {
            view = LayoutInflater.from(mCotext).inflate(R.layout.item_gank_rv, parent, false);
        } else {
            view = LayoutInflater.from(mCotext).inflate(R.layout.item_gank_girl_rv, parent, false);
        }
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, final int position) {
        final GankModel.ResultsBean resultsBean = mList.get(position);
        if (mItemType == Constant.ITEM_TYPE_GANK_TEXT) {
            holder.tv_author.setText((String) resultsBean.getWho());
            holder.tv_title.setText(resultsBean.getDesc());
            holder.tv_time.setText(TimeUtils.getFriendlyTimeSpanByNow(MyUtils.formatDateFromStr(resultsBean.getPublishedAt())));
            if (resultsBean.getImages() != null && resultsBean.getImages().size() > 0) {
                //显示图片
                holder.imageView.setVisibility(View.VISIBLE);
                ImageUtils.getInstance()
                        .loadImage(mCotext,
                                resultsBean.getImages().get(0),
                                holder.imageView);
            } else {
                //隐藏图片
                holder.imageView.setVisibility(View.GONE);
            }
        } else if (mItemType == Constant.ITEM_TYPE_GANK_IMAGE) {
            ViewGroup.LayoutParams lp = holder.cardView.getLayoutParams();
            lp.height = (int) (Math.random() * 300 + 500);
            holder.cardView.setLayoutParams(lp);
            holder.imageViewGirl.setTag(R.id.iv_girl, resultsBean.getUrl());
            ImageUtils.getInstance()
                    .loadImage(mCotext,
                            resultsBean.getUrl(),
                            holder.imageViewGirl);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onBaseClickListener) {
                    onBaseClickListener.onClick(position, resultsBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView imageViewGirl;
        TextView tv_author;
        TextView tv_title;
        TextView tv_time;
        CardView cardView;
        View view;

        BaseViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.iv_cover);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_time = itemView.findViewById(R.id.tv_time);
            imageViewGirl = itemView.findViewById(R.id.iv_girl);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
