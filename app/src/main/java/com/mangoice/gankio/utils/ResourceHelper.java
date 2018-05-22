package com.mangoice.gankio.utils;

import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;

import com.mangoice.gankio.base.App;


/**
 * Created by MangoIce on 2017/11/16.
 */
public class ResourceHelper {

    public static String getString(@StringRes int stringId) {
        return App.getContext().getResources().getString(stringId);
    }

    public static String[] getStringArray(@ArrayRes int arrayId) {
        return App.getContext().getResources().getStringArray(arrayId);
    }

    public static String stringFormat(@StringRes int stringId, Object... objects) {
        String formatString = getString(stringId);
        return String.format(formatString, objects);
    }

    public static int getColor(@ColorRes int colorId) {
        return App.getContext().getResources().getColor(colorId);
    }

    public static float getDimen(@DimenRes int dimenId) {
        return App.getContext().getResources().getDimension(dimenId);
    }

}
