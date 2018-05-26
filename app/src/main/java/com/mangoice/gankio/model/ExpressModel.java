package com.mangoice.gankio.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MangoIce on 2018/5/26.
 */
public class ExpressModel implements Serializable {
    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private String state;
    private List<Data> data;

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }


    public void setNu(String nu) {
        this.nu = nu;
    }
    public String getNu() {
        return nu;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }
    public String getIscheck() {
        return ischeck;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getCondition() {
        return condition;
    }

    public void setCom(String com) {
        this.com = com;
    }
    public String getCom() {
        return com;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }

    public static class Data {

        private String time;
        private String ftime;
        private String context;
        private String location;


        public void setTime(String time) {
            this.time = time;
        }
        public String getTime() {
            return time;
        }


        public void setFtime(String ftime) {
            this.ftime = ftime;
        }
        public String getFtime() {
            return ftime;
        }


        public void setContext(String context) {
            this.context = context;
        }
        public String getContext() {
            return context;
        }


        public void setLocation(String location) {
            this.location = location;
        }
        public String getLocation() {
            return location;
        }

    }

}
