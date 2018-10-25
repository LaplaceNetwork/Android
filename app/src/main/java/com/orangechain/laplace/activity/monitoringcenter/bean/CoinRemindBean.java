package com.orangechain.laplace.activity.monitoringcenter.bean;

public class CoinRemindBean {

    String name;

    String fullName;

    public CoinRemindBean(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
