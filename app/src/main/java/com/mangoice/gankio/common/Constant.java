package com.mangoice.gankio.common;

/**
 * Created by MangoIce on 2017/11/18.
 */

public class Constant {
    //Api
    public static final String GANK_URL = "http://gank.io/api/";  //Gank.io
    public static final String NEWS_URL = "http://is.snssdk.com/api/news/feed/";  //头条

    //Gank.io
    public static final String CATEGORY_ALL = "all";
    public static final String CATEGORY_ANDROID = "Android";
    public static final String CATEGORY_IOS = "iOS";
    public static final String CATEGORY_FRONT_END = "前端";
    public static final String CATEGORY_VIDEO = "休息视频";
    public static final String CATEGORY_EXPAND_RESOURCE = "拓展资源";
    public static final String CATEGORY_RECOMMEND = "瞎推荐";
    public static final String CATEGORY_APP = "App";
    public static final String CATEGORY_GIRL = "福利";

    //今日头条
    public static final String CATEGORY_NEWS_HOT = "news_hot";
    public static final String CATEGORY_NEWS_VIDEO = "video";
    public static final String CATEGORY_NEWS_SOCIETY = "news_society";
    public static final String CATEGORY_NEWS_ENTERTAINMENT = "news_entertainment";
    public static final String CATEGORY_NEWS_QA = "question_and_answer";
    public static final String CATEGORY_NEWS_TECH = "news_tech";
    public static final String CATEGORY_NEWS_CAR = "news_car";
    public static final String CATEGORY_NEWS_SPORT = "news_sport";
    public static final String CATEGORY_NEWS_FINANCE = "news_finance";
    public static final String CATEGORY_NEWS_MILITARY = "news_military";
    public static final String CATEGORY_NEWS_WORLD = "news_world";
    public static final String CATEGORY_ESSAY_JOKE = "essay_joke";
    public static final String CATEGORY_IMAGE_FUNNY = "image_funny";

    //默认每次获取数据的条数
    public static final int PAGE_SIZE = 10;

    public static final int GET_DATA_TYPE_NORMAL = 0;
    public static final int GET_DATA_TYPE_LOAD_MORE = 1;

    //RecyclerView ItemType
    public static final int ITEM_TYPE_GANK_TEXT = 0;
    public static final int ITEM_TYPE_GANK_IMAGE = 1;
    public static final int ITEM_TYPE_NEWS_TEXT = 2;
    public static final int ITEM_TYPE_NEWS_IMAGE = 3;
}
