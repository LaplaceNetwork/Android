package com.orangechain.laplace.activity.identity.bean;

public class IdentityFragmentBean {

    private String name;
    private String timeliness;
    private String date;
    private String imgUrl;

    public IdentityFragmentBean(String name, String timeliness, String date, String imgUrl) {
        this.name = name;
        this.timeliness = timeliness;
        this.date = date;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getTimeliness() {
        return timeliness;
    }

    public String getDate() {
        return date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeliness(String timeliness) {
        this.timeliness = timeliness;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
