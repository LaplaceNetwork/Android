package com.orangechain.laplace.activity.guideregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class QRCodeActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("扫描二维码");
        setToolBarTextColor(R.color.color333333);
        setToolBarTextSize(R.dimen.text_size_17);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_qrcode;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,QRCodeActivity.class);
        startWithNewAnimation(context,intent);
    }
}
