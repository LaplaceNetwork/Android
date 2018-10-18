package com.orangechain.laplace.activity.identity.setting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class AuthenticationProcessActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("Laplace Passport");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_authentication_process;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,AuthenticationProcessActivity.class);
        startWithNewAnimation(context,intent);

    }
}