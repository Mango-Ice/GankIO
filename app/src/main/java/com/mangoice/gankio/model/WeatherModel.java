package com.mangoice.gankio.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MangoIce on 2018/5/25.
 *
 *  From Meizu Weather API
 */
public class WeatherModel implements Serializable {
    private String code;
    private String message;
    private String redirect;
    private List<Value> value;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public List<Value> getValue() {
        return value;
    }

    public static class Indexes {
        private String abbreviation;
        private String alias;
        private String content;
        private String level;
        private String name;

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Pm25 {
        private String advice;
        private String aqi;
        private int citycount;
        private int cityrank;
        private String co;
        private String color;
        private String level;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String quality;
        private String so2;
        private String timestamp;
        private String updateTime;

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public int getCitycount() {
            return citycount;
        }

        public void setCitycount(int citycount) {
            this.citycount = citycount;
        }

        public int getCityrank() {
            return cityrank;
        }

        public void setCityrank(int cityrank) {
            this.cityrank = cityrank;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String upDateTime) {
            this.updateTime = upDateTime;
        }
    }

    public static class Realtime {
        private String img;
        private String sd;
        private String sendibleTemp;
        private String temp;
        private String time;
        private String wd;
        private String ws;
        private String weather;
        private String ziwaixian;

        public void setImg(String img) {
            this.img = img;
        }
        public String getImg() {
            return img;
        }

        public void setSd(String sD) {
            this.sd = sD;
        }
        public String getSd() {
            return sd;
        }

        public void setSendibletemp(String sendibleTemp) {
            this.sendibleTemp = sendibleTemp;
        }
        public String getSendibletemp() {
            return sendibleTemp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }
        public String getTemp() {
            return temp;
        }

        public void setTime(String time) {
            this.time = time;
        }
        public String getTime() {
            return time;
        }

        public void setWd(String wD) {
            this.wd = wD;
        }
        public String getWd() {
            return wd;
        }

        public void setWs(String wS) {
            this.ws = wS;
        }
        public String getWs() {
            return ws;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
        public String getWeather() {
            return weather;
        }

        public void setZiwaixian(String ziwaixian) {
            this.ziwaixian = ziwaixian;
        }
        public String getZiwaixian() {
            return ziwaixian;
        }
    }

    public static class Weather3hoursdetailsinfos {
        private String endtime;
        private String highesttemperature;
        private String img;
        private String israinfall;
        private String loweresttemperature;
        private String precipitation;
        private String starttime;
        private String wd;
        private String weather;
        private String ws;

        public void setEndtime(String endTime) {
            this.endtime = endTime;
        }
        public String getEndtime() {
            return endtime;
        }

        public void setHighesttemperature(String highestTemperature) {
            this.highesttemperature = highestTemperature;
        }
        public String getHighesttemperature() {
            return highesttemperature;
        }

        public void setImg(String img) {
            this.img = img;
        }
        public String getImg() {
            return img;
        }

        public void setIsrainfall(String isRainFall) {
            this.israinfall = isRainFall;
        }
        public String getIsrainfall() {
            return israinfall;
        }

        public void setLoweresttemperature(String lowerestTemperature) {
            this.loweresttemperature = lowerestTemperature;
        }
        public String getLoweresttemperature() {
            return loweresttemperature;
        }

        public void setPrecipitation(String precipitation) {
            this.precipitation = precipitation;
        }
        public String getPrecipitation() {
            return precipitation;
        }

        public void setStarttime(String startTime) {
            this.starttime = startTime;
        }
        public String getStarttime() {
            return starttime;
        }

        public void setWd(String wd) {
            this.wd = wd;
        }
        public String getWd() {
            return wd;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
        public String getWeather() {
            return weather;
        }

        public void setWs(String ws) {
            this.ws = ws;
        }
        public String getWs() {
            return ws;
        }
    }

    public static class Weatherdetailsinfo {
        private String publishtime;
        private List<Weather3hoursdetailsinfos> weather3hoursdetailsinfos;

        public void setPublishtime(String publishTime) {
            this.publishtime = publishTime;
        }
        public String getPublishtime() {
            return publishtime;
        }

        public void setWeather3hoursdetailsinfos(List<Weather3hoursdetailsinfos> weather3HoursDetailsInfos) {
            this.weather3hoursdetailsinfos = weather3HoursDetailsInfos;
        }
        public List<Weather3hoursdetailsinfos> getWeather3hoursdetailsinfos() {
            return weather3hoursdetailsinfos;
        }
    }

    public static class Weathers {
        private String date;
        private String img;
        private String sunDownTime;
        private String sunRiseTime;
        private String tempDayC;
        private String tempDayF;
        private String tempNightC;
        private String tempNightF;
        private String wd;
        private String weather;
        private String week;
        private String ws;

        public void setDate(String date) {
            this.date = date;
        }
        public String getDate() {
            return date;
        }

        public void setImg(String img) {
            this.img = img;
        }
        public String getImg() {
            return img;
        }


        public void setSunDownTime(String sun_down_time) {
            this.sunDownTime = sun_down_time;
        }
        public String getSunDownTime() {
            return sunDownTime;
        }


        public void setSunRiseTime(String sun_rise_time) {
            this.sunRiseTime = sun_rise_time;
        }
        public String getSunRiseTime() {
            return sunRiseTime;
        }


        public void setTempDayC(String temp_day_c) {
            this.tempDayC = temp_day_c;
        }
        public String getTempDayC() {
            return tempDayC;
        }


        public void setTempDayF(String temp_day_f) {
            this.tempDayF = temp_day_f;
        }
        public String getTempDayF() {
            return tempDayF;
        }


        public void setTempNightC(String temp_night_c) {
            this.tempNightC = temp_night_c;
        }
        public String getTempNightC() {
            return tempNightC;
        }


        public void setTempNightF(String temp_night_f) {
            this.tempNightF = temp_night_f;
        }
        public String getTempNightF() {
            return tempNightF;
        }


        public void setWd(String wd) {
            this.wd = wd;
        }
        public String getWd() {
            return wd;
        }


        public void setWeather(String weather) {
            this.weather = weather;
        }
        public String getWeather() {
            return weather;
        }


        public void setWeek(String week) {
            this.week = week;
        }
        public String getWeek() {
            return week;
        }


        public void setWs(String ws) {
            this.ws = ws;
        }
        public String getWs() {
            return ws;
        }
    }

    public static class Value {
        private List<Alarms> alarms;
        private String city;
        private int cityid;
        private List<Indexes> indexes;
        private Pm25 pm25;
        private String provinceName;
        private Realtime realtime;
        private Weatherdetailsinfo weatherDetailsInfo;
        private List<Weathers> weathers;

        public void setAlarms(List<Alarms> alarms) {
            this.alarms = alarms;
        }
        public List<Alarms> getAlarms() {
            return alarms;
        }


        public void setCity(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }


        public void setCityid(int cityid) {
            this.cityid = cityid;
        }
        public int getCityid() {
            return cityid;
        }


        public void setIndexes(List<Indexes> indexes) {
            this.indexes = indexes;
        }
        public List<Indexes> getIndexes() {
            return indexes;
        }


        public void setPm25(Pm25 pm25) {
            this.pm25 = pm25;
        }
        public Pm25 getPm25() {
            return pm25;
        }


        public void setProvincename(String provinceName) {
            this.provinceName = provinceName;
        }
        public String getProvincename() {
            return provinceName;
        }


        public void setRealtime(Realtime realtime) {
            this.realtime = realtime;
        }
        public Realtime getRealtime() {
            return realtime;
        }


        public void setWeatherdetailsinfo(Weatherdetailsinfo weatherDetailsInfo) {
            this.weatherDetailsInfo = weatherDetailsInfo;
        }
        public Weatherdetailsinfo getWeatherdetailsinfo() {
            return weatherDetailsInfo;
        }


        public void setWeathers(List<Weathers> weathers) {
            this.weathers = weathers;
        }
        public List<Weathers> getWeathers() {
            return weathers;
        }

        }

    public static class Alarms {
        private String alarmId;
        private String alarmType;
        private String alarmTypeDesc;
        private String alarmLevelNo;
        private String alarmLevelNoDesc;
        private String alarmContent;
        private String publishTime;
        private String alarmDesc;
        private String precaution;

        public String getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(String alarmId) {
            this.alarmId = alarmId;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public String getAlarmTypeDesc() {
            return alarmTypeDesc;
        }

        public void setAlarmTypeDesc(String alarmTypeDesc) {
            this.alarmTypeDesc = alarmTypeDesc;
        }

        public String getAlarmLevelNo() {
            return alarmLevelNo;
        }

        public void setAlarmLevelNo(String alarmLevelNo) {
            this.alarmLevelNo = alarmLevelNo;
        }

        public String getAlarmLevelNoDesc() {
            return alarmLevelNoDesc;
        }

        public void setAlarmLevelNoDesc(String alarmLevelNoDesc) {
            this.alarmLevelNoDesc = alarmLevelNoDesc;
        }

        public String getAlarmContent() {
            return alarmContent;
        }

        public void setAlarmContent(String alarmContent) {
            this.alarmContent = alarmContent;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getAlarmDesc() {
            return alarmDesc;
        }

        public void setAlarmDesc(String alarmDesc) {
            this.alarmDesc = alarmDesc;
        }

        public String getPrecaution() {
            return precaution;
        }

        public void setPrecaution(String precaution) {
            this.precaution = precaution;
        }
    }
}
