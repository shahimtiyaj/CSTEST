package com.csinfotech.cstest.model;

public class DataInfo {
    private String title;
    private String des;
    private String date;

    public DataInfo() {

    }

    public DataInfo(String title, String des, String date) {
        this.title = title;
        this.des = des;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
