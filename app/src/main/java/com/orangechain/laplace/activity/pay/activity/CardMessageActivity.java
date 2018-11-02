package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class CardMessageActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("卡片信息");

        View address = findViewById(R.id.card_message_summary_address);
        TextView name = address.findViewById(R.id.card_message_name);
        TextView content = address.findViewById(R.id.card_message_des);
        name.setText("地址");
        content.setText("0000000000000000000");

        address = findViewById(R.id.card_message_summary_time);
        name = address.findViewById(R.id.card_message_name);
        content = address.findViewById(R.id.card_message_des);
        name.setText("添加时间");
        content.setText("0000:00:00 00:00:00");

        address = findViewById(R.id.card_message_summary_operatar);
        name = address.findViewById(R.id.card_message_name);
        content = address.findViewById(R.id.card_message_des);
        name.setText("运营商");
        content.setText("XXXXXXXXX");

        Button open = findViewById(R.id.card_message_summary_open_button);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button watch = findViewById(R.id.card_message_summary_watch_button);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_card_message;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,CardMessageActivity.class);
        startWithNewAnimation(context,intent);

    }
}
