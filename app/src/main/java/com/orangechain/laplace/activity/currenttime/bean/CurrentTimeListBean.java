package com.orangechain.laplace.activity.currenttime.bean;

public class CurrentTimeListBean {

    String currentTime;

    String title;

    String objectText;

    String type;

    String objectTime;

    String money;

    String inputAddress;

    String outputAddress;

    String des;

    boolean desIsShow;

    String desColor;

    public CurrentTimeListBean(String currentTime, String title, String objectText, String type, String objectTime, String money, String inputAddress, String outputAddress, String des, boolean desIsShow, String desColor) {
        this.currentTime = currentTime;
        this.title = title;
        this.objectText = objectText;
        this.type = type;
        this.objectTime = objectTime;
        this.money = money;
        this.inputAddress = inputAddress;
        this.outputAddress = outputAddress;
        this.des = des;
        this.desIsShow = desIsShow;
        this.desColor = desColor;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjectText() {
        return objectText;
    }

    public void setObjectText(String objectText) {
        this.objectText = objectText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjectTime() {
        return objectTime;
    }

    public void setObjectTime(String objectTime) {
        this.objectTime = objectTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getInputAddress() {
        return inputAddress;
    }

    public void setInputAddress(String inputAddress) {
        this.inputAddress = inputAddress;
    }

    public String getOutputAddress() {
        return outputAddress;
    }

    public void setOutputAddress(String outputAddress) {
        this.outputAddress = outputAddress;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isDesIsShow() {
        return desIsShow;
    }

    public void setDesIsShow(boolean desIsShow) {
        this.desIsShow = desIsShow;
    }

    public String getDesColor() {
        return desColor;
    }

    public void setDesColor(String desColor) {
        this.desColor = desColor;
    }
}
