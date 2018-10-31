package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class PayAddCardActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("添加卡片");

        Button next = findViewById(R.id.pay_add_card_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayOperatarSelectActivity payOperatarSelectActivity = new PayOperatarSelectActivity();
                payOperatarSelectActivity.pushActivity(PayAddCardActivity.this);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_add_card;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,PayAddCardActivity.class);
        startWithNewAnimation(context,intent);

    }
}
