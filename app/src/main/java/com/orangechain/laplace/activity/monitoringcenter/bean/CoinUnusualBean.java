package com.orangechain.laplace.activity.monitoringcenter.bean;

public class CoinUnusualBean {

    String coinName;

    String baseCoinName;

    String proportion;

    String inputProportion;

    String outputProportion;

    boolean switchStatus;

    String type;

    public CoinUnusualBean(String coinName, String baseCoinName, String proportion, String inputProportion, String outputProportion, boolean switchStatus, String type) {
        this.coinName = coinName;
        this.baseCoinName = baseCoinName;
        this.proportion = proportion;
        this.inputProportion = inputProportion;
        this.outputProportion = outputProportion;
        this.switchStatus = switchStatus;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getBaseCoinName() {
        return baseCoinName;
    }

    public void setBaseCoinName(String baseCoinName) {
        this.baseCoinName = baseCoinName;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getInputProportion() {
        return inputProportion;
    }

    public void setInputProportion(String inputProportion) {
        this.inputProportion = inputProportion;
    }

    public String getOutputProportion() {
        return outputProportion;
    }

    public void setOutputProportion(String outputProportion) {
        this.outputProportion = outputProportion;
    }

    public boolean getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(boolean switchStatus) {
        this.switchStatus = switchStatus;
    }
}
