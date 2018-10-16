package com.orangechain.laplace.activity.identity.setting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class LanguageSettingActivity extends BaseActivity {


    @Override
    public void initWithView() {

        setToolBarText("语言设置");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_language_setting;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,LanguageSettingActivity.class);
        startWithNewAnimation(context,intent);
    }
}
