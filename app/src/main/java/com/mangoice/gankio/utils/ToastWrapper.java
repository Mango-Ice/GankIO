package com.mangoice.gankio.utils;

import android.widget.Toast;

import com.mangoice.gankio.base.App;

/**
 * Created by MangoIce on 2017/11/16.
 */
public class ToastWrapper {
    private static Toast toast = Toast.makeText(App.getContext(), "", Toast.LENGTH_LONG);
    private static boolean isShowing = false;
    private static String lastToastContent = "";

    private static int shortDuration = 1000;
    private static int longDuration = 2000;

    // 显示短提示
    public static void makeShortToast(String content) {
        makeToast(content, shortDuration);
    }

    // 显示短提示
    public static void makeShortToast(int stringId) {
        makeShortToast(ResourceHelper.getString(stringId));
    }

    // 显示短提示
    public static void makeShortToast(int stringId, Object... objects) {
        String content = ResourceHelper.stringFormat(stringId, objects);
        makeShortToast(content);
    }

    // 显示长提示
    public static void makeLongToast(String content) {
        makeToast(content, longDuration);
    }

    private static void makeToast(String content, int duration) {
        Toast.makeText(App.getContext(),content,duration).show();
    }

    // 显示长提示
    public static void makeLongToast(int stringId) {
        makeLongToast(ResourceHelper.getString(stringId));
    }

    // 显示长提示
    public static void makeLongToast(int stringId, Object... objects) {
        String content = ResourceHelper.stringFormat(stringId, objects);
        makeLongToast(content);
    }
}
