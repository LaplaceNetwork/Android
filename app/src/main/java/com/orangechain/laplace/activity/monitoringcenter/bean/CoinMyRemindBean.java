package com.orangechain.laplace.activity.monitoringcenter.bean;

public class CoinMyRemindBean {

    String exchangeCouple;

    String exchange;

    String high;

    String low;

    public CoinMyRemindBean(String exchangeCouple, String exchange, String high, String low) {
        this.exchangeCouple = exchangeCouple;
        this.exchange = exchange;
        this.high = high;
        this.low = low;
    }

    public String getExchangeCouple() {
        return exchangeCouple;
    }

    public void setExchangeCouple(String exchangeCouple) {
        this.exchangeCouple = exchangeCouple;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
