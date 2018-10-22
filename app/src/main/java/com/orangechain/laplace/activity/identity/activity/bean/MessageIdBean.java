package com.orangechain.laplace.activity.identity.activity.bean;

import java.util.List;

public class MessageIdBean {

    boolean isShow;//是否显示

    String itemName;//组头的信息

    List<messageIdSonBean> listDesArray;//隐藏部分的数据


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
