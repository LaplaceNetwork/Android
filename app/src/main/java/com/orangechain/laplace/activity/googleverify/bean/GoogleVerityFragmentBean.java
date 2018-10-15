package com.orangechain.laplace.activity.googleverify.bean;

import android.widget.TextView;

public class GoogleVerityFragmentBean {

    String numberCode;

    String objectName;

    String imageStatus;

    public GoogleVerityFragmentBean(String numberCode, String objectName, String imageStatus) {
        this.numberCode = numberCode;
        this.objectName = objectName;
        this.imageStatus = imageStatus;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
    }
}
