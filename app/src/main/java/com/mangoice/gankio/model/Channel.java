package com.mangoice.gankio.model;

import java.io.Serializable;

/**
 * Created by MangoIce on 2018/5/24.
 *
 * channelType is like the API CATEGORY_ALL-"all"
 * channelName is like "全部"
 */
public class Channel implements Serializable {
    private String channelType;
    private String channelName;

    public Channel(String channelType, String channelName) {
        this.channelType = channelType;
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
