package com.orangechain.laplace.activity.identity.activity.bean;

public class LanguageSettingBean {

    String name;

    boolean checked;

    public LanguageSettingBean(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
