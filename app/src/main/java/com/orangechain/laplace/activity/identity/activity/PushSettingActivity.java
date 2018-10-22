package com.orangechain.laplace.activity.identity.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class PushSettingActivity extends BaseActivity {

    @Override
    public void initWithView() {
        setToolBarText("推送管理");

        //修改第一组
        View viewGroup1 = findViewById(R.id.push_setting_message_include);
        TextView name1 = viewGroup1.findViewById(R.id.push_name);
        name1.setText("推送消息");

        //修改第二组
        View viewGroup2 = findViewById(R.id.push_setting_night_quietness_include);
        TextView name2 = viewGroup2.findViewById(R.id.push_name);
        TextView des = viewGroup2.findViewById(R.id.push_des);
        name2.setText("夜间勿扰模式");
        des.setVisibility(View.VISIBLE);
        des.setText("(23:00 - 07:00)");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_push_setting;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,PushSettingActivity.class);
        startWithNewAnimation(context,intent);
    }
}
