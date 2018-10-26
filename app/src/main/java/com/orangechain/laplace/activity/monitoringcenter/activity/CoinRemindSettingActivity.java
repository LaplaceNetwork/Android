package com.orangechain.laplace.activity.monitoringcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class CoinRemindSettingActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("设置提醒");
        setToolBarRightFirstButtonText("刷新");
        setToolBarRightFirstButtonImageHidden();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_coin_remind_setting;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,CoinRemindSettingActivity.class);
        startWithNewAnimation(context,intent);
    }
}
