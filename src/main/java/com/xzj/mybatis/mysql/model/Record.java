package com.xzj.mybatis.mysql.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 2017-11-16.
 */
//select * from  fmdata.t_current_alarm
public class Record {
    int csn;
    String alarmName;
    String alarmId;
    long occurUtc;
    long clearUtc;
    String clearUser;
    String ackUser;
    String meName;
    String medn;

    public int getCsn() {
        return csn;
    }

    public void setCsn(int csn) {
        this.csn = csn;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }


    public String getClearUser() {
        return clearUser;
    }

    public void setClearUser(String clearUser) {
        this.clearUser = clearUser;
    }

    public String getAckUser() {
        return ackUser;
    }

    public void setAckUser(String ackUser) {
        this.ackUser = ackUser;
    }

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName;
    }

    public String getMedn() {
        return medn;
    }

    public void setMedn(String medn) {
        this.medn = medn;
    }

    public long getOccurUtc() {
        return occurUtc;
    }

    public void setOccurUtc(long occurUtc) {
        this.occurUtc = occurUtc;
    }

    public long getClearUtc() {
        return clearUtc;
    }

    public void setClearUtc(long clearUtc) {
        this.clearUtc = clearUtc;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
