package com.orangechain.laplace.activity.identity.setting.bean;

import java.util.List;

public class MessageIdBean {

    boolean isShow;

    String itemName;

    List<messageIdSonBean> listDesArray;


    public MessageIdBean(boolean isShow, String itemName, List<messageIdSonBean> listDesArray) {
        this.isShow = isShow;
        this.itemName = itemName;
        this.listDesArray = listDesArray;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<messageIdSonBean> getListDesArray() {
        return listDesArray;
    }

    public void setListDesArray(List<messageIdSonBean> listDesArray) {
        this.listDesArray = listDesArray;
    }
}
