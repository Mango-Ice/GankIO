package com.mangoice.gankio.utils.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by MangoIce on 2018/5/8.
 */

public class ImageUtils {
    private static ImageUtils mImageUtils;

    private ImageUtils() {

    }

    public static ImageUtils getInstance() {
        if (mImageUtils == null) {
            synchronized (ImageUtils.class) {
                if (mImageUtils == null) {
                    mImageUtils = new ImageUtils();
                }
            }
        }
        return mImageUtils;
    }

    public void loadImage(Context context, Object path, ImageView targetImageView) {

        Glide.with(context)
                .load(path)
                .into(targetImageView);
    }

}
