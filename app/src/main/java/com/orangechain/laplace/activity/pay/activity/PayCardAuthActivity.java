package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class PayCardAuthActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("卡片授权");

        //修改图片的填充颜色
        Drawable imageViewDraw = ContextCompat.getDrawable(this, R.drawable.baseline_report_black_24dp);
        imageViewDraw.setColorFilter(getResources().getColor(R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);


        Button button = findViewById(R.id.pay_card_auth_detail_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_card_auth;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,PayCardAuthActivity.class);
        startWithNewAnimation(context,intent);

    }
}
