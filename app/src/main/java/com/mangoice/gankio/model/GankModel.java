package com.mangoice.gankio.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MangoIce on 2017/11/25.
 */

public class GankModel {
    private boolean error;
    private List<ResultsBean> results;


    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return error;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public static class ResultsBean implements Serializable {
        public ResultsBean(String _id, String createdAt, String desc, String publishedAt, String source, String type, String url, boolean used, String who, List<String> images) {
            this._id = _id;
            this.createdAt = createdAt;
            this.desc = desc;
            this.publishedAt = publishedAt;
            this.source = source;
            this.type = type;
            this.url = url;
            this.used = used;
            this.who = who;
            this.images = images;
        }

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String getId() {
            return _id;
        }

        public void setId(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public Object getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
