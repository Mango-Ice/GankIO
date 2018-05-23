package com.mangoice.gankio.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MangoIce on 2018/5/22.
 */
public class NewsModel {
    private static Gson gson = new Gson();

    private String message;
    private List<Data> data;
    private int totalNumber;
    private boolean hasMore;
    private int loginStatus;
    private int showEtStatus;
    private String postContentHint;
    private boolean hasMoreToRefresh;
    private int actionToLastStick;
    private int feedFlag;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }


    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setShowEtStatus(int showEtStatus) {
        this.showEtStatus = showEtStatus;
    }

    public int getShowEtStatus() {
        return showEtStatus;
    }

    public void setPostContentHint(String postContentHint) {
        this.postContentHint = postContentHint;
    }

    public String getPostContentHint() {
        return postContentHint;
    }

    public void setHasMoreToRefresh(boolean hasMoreToRefresh) {
        this.hasMoreToRefresh = hasMoreToRefresh;
    }

    public boolean getHasMoreToRefresh() {
        return hasMoreToRefresh;
    }

    public void setActionToLastStick(int actionToLastStick) {
        this.actionToLastStick = actionToLastStick;
    }

    public int getActionToLastStick() {
        return actionToLastStick;
    }

    public void setFeedFlag(int feedFlag) {
        this.feedFlag = feedFlag;
    }

    public int getFeedFlag() {
        return feedFlag;
    }


    public static class Data implements Serializable, MultiItemEntity {
        private String content;
        private String code;
        private int itemType;

        public void setContent(String content) {
            this.content = content;
        }

        public Content getContent() {

            return gson.fromJson(content, NewsModel.Content.class);
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "content='" + content + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }

    public static class Content implements Serializable {
        private String media_name;
        private String title;
        private List<ImageList> imageList;
        private int readCount;
        private int commentCount;
        private int publishTime;
        private int diggCount;

        public String getMediaName() { return media_name;}

        public void setMediaName(String media_name) { this.media_name = media_name; }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ImageList> getImageList() {

            return imageList;
        }

        public void setImageList(List<ImageList> image_list) {
            this.imageList = image_list;
        }

        public int getReadCount() {
            return readCount;
        }

        public void setReadCount(int read_count) {
            this.readCount = read_count;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int comment_count) {
            this.commentCount = comment_count;
        }

        public int getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(int publish_time) {
            this.publishTime = publish_time;
        }

        public int getDiggCount() {
            return diggCount;
        }

        public void setDiggCount(int digg_count) {
            this.diggCount = digg_count;
        }
    }

    public static class ImageList implements Serializable {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", totalNumber=" + totalNumber +
                ", hasMore=" + hasMore +
                ", loginStatus=" + loginStatus +
                ", showEtStatus=" + showEtStatus +
                ", postContentHint='" + postContentHint + '\'' +
                ", hasMoreToRefresh=" + hasMoreToRefresh +
                ", actionToLastStick=" + actionToLastStick +
                ", feedFlag=" + feedFlag +
                '}';
    }
}
