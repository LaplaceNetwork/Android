package com.orangechain.laplace.activity.pay.bean;

public class PayCardDetailBean {

    String address;

    String date;

    String money;

    public PayCardDetailBean(String address, String date, String money) {
        this.address = address;
        this.date = date;
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
