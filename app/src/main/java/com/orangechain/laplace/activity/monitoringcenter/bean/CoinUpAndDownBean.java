package com.orangechain.laplace.activity.monitoringcenter.bean;

public class CoinUpAndDownBean {

    String name;

    String fullName;

    boolean switchStatus;

    public CoinUpAndDownBean(String name, String fullName, boolean switchStatus) {
        this.name = name;
        this.fullName = fullName;
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

    public boolean isSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(boolean switchStatus) {
        this.switchStatus = switchStatus;
    }
}
