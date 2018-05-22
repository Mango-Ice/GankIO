package com.mangoice.gankio.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Set;

/**
 * Created by MangoIce on 2017/11/15.
 */

public class App extends Application {
    private static Context sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = getApplicationContext();
    }

    public static Context getContext() {
        return sApplicationContext;
    }

}
