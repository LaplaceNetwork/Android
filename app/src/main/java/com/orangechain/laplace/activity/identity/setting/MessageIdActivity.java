package com.orangechain.laplace.activity.identity.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class MessageIdActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("ID信息");
        setToolBarTextColor(R.color.colorPrimary);
        setToolBarTextSize(R.dimen.text_size_17);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message_id;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,MessageIdActivity.class);
        startWithNewAnimation(context,intent);

    }
}
