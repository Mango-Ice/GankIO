package com.mangoice.gankio.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.mangoice.gankio.model.WeatherAddressModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MangoIce on 2018/5/8.
 */

public class MyUtils {
    /**
     * 根据指定格式字符串返回日期
     *
     * @param dateStr
     * @return
     */
    public static Date formatDateFromStr(final String dateStr) {
        Date date = new Date();
        if (!TextUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
            try {
                date = sdf.parse(dateStr);
            } catch (Exception e) {
                System.out.print("Error,format Date error");
            }
        }
        return date;
    }

    /**
     * 获取Assets下面的Json文件并解析
     */
    public static WeatherAddressModel getJsonFromAssets(String fileName, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName),"utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Json To Object
        Gson gson = new Gson();
        return gson.fromJson(stringBuilder.toString(), WeatherAddressModel.class);
    }
}
