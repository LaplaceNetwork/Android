package com.orangechain.laplace.activity.pay.bean;

import com.orangechain.laplace.enumutil.PayCardEnum;

import java.util.List;

public class PayCardBean {

    int id;

    String cardName;

    int color;

    List<PayCardDetailBean> detailBeans;

    //是否显示二维码
    boolean isShowQRCode;

    //是否显示签约状态
    boolean isShowContract;

    //签约还是解约 还是普通状态
    PayCardEnum status;

    public PayCardBean(int id, String cardName, int color, List<PayCardDetailBean> detailBeans, boolean isShowQRCode, boolean isShowContract, PayCardEnum status) {
        this.id = id;
        this.cardName = cardName;
        this.color = color;
        this.detailBeans = detailBeans;
        this.isShowQRCode = isShowQRCode;
        this.isShowContract = isShowContract;
        this.status = status;
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

    public boolean isShowQRCode() {
        return isShowQRCode;
    }

    public void setShowQRCode(boolean showQRCode) {
        isShowQRCode = showQRCode;
    }

    public boolean isShowcontract() {
        return isShowContract;
    }

    public void setShowcontract(boolean showcontract) {
        isShowContract = showcontract;
    }

    public PayCardEnum getStatus() {
        return status;
    }

    public void setStatus(PayCardEnum status) {
        this.status = status;
    }

}
