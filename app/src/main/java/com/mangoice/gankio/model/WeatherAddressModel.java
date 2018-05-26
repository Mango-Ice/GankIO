package com.mangoice.gankio.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MangoIce on 2018/5/26.
 */
public class WeatherAddressModel implements Serializable {
    private List<Cities> cities;
    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }
    public List<Cities> getCities() {
        return cities;
    }

    public static class Cities implements Serializable {

        private String city;
        private String cityid;

        public void setCity(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }
        public String getCityid() {
            return cityid;
        }

    }

    public static class Country implements Serializable {
        private String areaid;
        private String countyname;

        public void setAreaid(String areaid) {
            this.areaid = areaid;
        }
        public String getAreaid() {
            return areaid;
        }

        public void setCountyname(String countyname) {
            this.countyname = countyname;
        }
        public String getCountyname() {
            return countyname;
        }
    }

}
