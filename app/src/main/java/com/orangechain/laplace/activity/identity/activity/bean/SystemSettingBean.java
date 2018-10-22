package com.orangechain.laplace.activity.identity.activity.bean;

public class SystemSettingBean {

    String name;

    boolean showSwitch;//控制是否显示switch按钮  switch显示 则按钮隐藏

    String rightButtonContent;//右边按钮功能

    public SystemSettingBean(String name, boolean showSwitch, String rightButtonContent) {
        this.name = name;
        this.showSwitch = showSwitch;
        this.rightButtonContent = rightButtonContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShowSwitch() {
        return showSwitch;
    }

    public void setShowSwitch(boolean showSwitch) {
        this.showSwitch = showSwitch;
    }

    public String getRightButtonContent() {
        return rightButtonContent;
    }

    public void setRightButtonContent(String rightButtonContent) {
        this.rightButtonContent = rightButtonContent;
    }
}
