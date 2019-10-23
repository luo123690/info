package com.six.info.entity;

import java.util.Date;

public class Application {
    private int id;
    private int userid;
    private String type;
    private String professionF;
    private String professionS;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfessionF() {
        return professionF;
    }

    public void setProfessionF(String professionF) {
        this.professionF = professionF;
    }

    public String getProfessionS() {
        return professionS;
    }

    public void setProfessionS(String professionS) {
        this.professionS = professionS;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
