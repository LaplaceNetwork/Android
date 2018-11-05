package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class PayActionActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("支付");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_action;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,PayActionActivity.class);
        startWithNewAnimation(context,intent);

    }
}
