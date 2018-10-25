package com.orangechain.laplace.activity.monitoringcenter.bean;

public class CoinExchangeKnockdownBean {

    String name;

    String fullName;

    String limitCount;

    boolean switchStatus;

    public CoinExchangeKnockdownBean(String name, String fullName, String limitCount, boolean switchStatus) {
        this.name = name;
        this.fullName = fullName;
        this.limitCount = limitCount;
        this.switchStatus = switchStatus;
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

    public String getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(String limitCount) {
        this.limitCount = limitCount;
    }

    public boolean isSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(boolean switchStatus) {
        this.switchStatus = switchStatus;
    }
}
