package com.orangechain.laplace.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class BackupsQRCodeActivity extends BaseActivity {


    @Override
    public void initWithView() {

        setToolBarText("备份身份");
        setToolBarBackColor(R.color.colorPrimary);
        setToolBarTextColor(R.color.colorWhite);
        setToolBarLeftColor(R.color.colorWhite);

        setBottomNavigationViewVisible(View.GONE);

    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,BackupsQRCodeActivity.class);
        startWithNewAnimation(context,intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_backups_qrcode;
    }
}
