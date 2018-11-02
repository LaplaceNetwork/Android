package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class UnboundActivity extends BaseActivity {

    @Override
    public void initWithView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbound;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,UnboundActivity.class);
        startWithNewAnimation(context,intent);

    }
}
