package com.orangechain.laplace.activity.pay.bean;

import java.util.List;

public class PayCardBean {

    int id;

    String cardName;

    int color;

    List<PayCardDetailBean> detailBeans;

    public PayCardBean(int id, String cardName, int color, List<PayCardDetailBean> detailBeans) {
        this.id = id;
        this.cardName = cardName;
        this.color = color;
        this.detailBeans = detailBeans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public List<PayCardDetailBean> getDetailBeans() {
        return detailBeans;
    }

    public void setDetailBeans(List<PayCardDetailBean> detailBeans) {
        this.detailBeans = detailBeans;
    }
}
