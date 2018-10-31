package com.orangechain.laplace.activity.pay.bean;

public class PayCardTypeBean {

    String cardName;

    boolean selectStatus;

    public PayCardTypeBean(String cardName, boolean selectStatus) {
        this.cardName = cardName;
        this.selectStatus = selectStatus;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public boolean isSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(boolean selectStatus) {
        this.selectStatus = selectStatus;
    }
}
