package com.orangechain.laplace.activity.pay.bean;

public class TradeMessageBean {

    String tradesStatus;

    String addressStart;

    String addressStartMoney;

    String addressEnd;

    String tradeDate;

    public TradeMessageBean(String tradesStatus, String addressStart, String addressStartMoney, String addressEnd, String tradeDate) {
        this.tradesStatus = tradesStatus;
        this.addressStart = addressStart;
        this.addressStartMoney = addressStartMoney;
        this.addressEnd = addressEnd;
        this.tradeDate = tradeDate;
    }

    public String getTradesStatus() {
        return tradesStatus;
    }

    public void setTradesStatus(String tradesStatus) {
        this.tradesStatus = tradesStatus;
    }

    public String getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(String addressStart) {
        this.addressStart = addressStart;
    }

    public String getAddressStartMoney() {
        return addressStartMoney;
    }

    public void setAddressStartMoney(String addressStartMoney) {
        this.addressStartMoney = addressStartMoney;
    }

    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }
}
