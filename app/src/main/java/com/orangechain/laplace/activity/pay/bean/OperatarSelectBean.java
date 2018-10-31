package com.orangechain.laplace.activity.pay.bean;

public class OperatarSelectBean {

    String operatar;

    String operatarDetail;

    boolean selectStatus;

    public OperatarSelectBean(String operatar, String operatarDetail, boolean selectStatus) {
        this.operatar = operatar;
        this.operatarDetail = operatarDetail;
        this.selectStatus = selectStatus;
    }

    public String getOperatar() {
        return operatar;
    }

    public void setOperatar(String operatar) {
        this.operatar = operatar;
    }

    public String getOperatarDetail() {
        return operatarDetail;
    }

    public void setOperatarDetail(String operatarDetail) {
        this.operatarDetail = operatarDetail;
    }

    public boolean isSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(boolean selectStatus) {
        this.selectStatus = selectStatus;
    }
}
