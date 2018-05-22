package com.mangoice.gankio.main.show_image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.mangoice.gankio.utils.image.ImageUtils;

import java.util.List;

/**
 * Created by MangoIce on 2018/5/20.
 */
public class ImagePagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> mList;

    public ImagePagerAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(mContext);
        photoView.enable();
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageUtils.getInstance().loadImage(mContext, mList.get(position), photoView);
        container.addView(photoView);
        return photoView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setList(List<String> mList) {
        this.mList = mList;
    }
}
