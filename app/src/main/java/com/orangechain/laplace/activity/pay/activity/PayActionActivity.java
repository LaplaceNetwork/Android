package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.base.BaseActivity;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class PayActionActivity extends BaseActivity {

    private CountDownTimer mCountDownTimer;
    private DialogPlus dialog;

    @Override
    public void initWithView() {

        setToolBarText("支付");

        Button button = findViewById(R.id.pay_action_trade_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = DialogPlus.newDialog(PayActionActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.input_pay_action_fingerprint))
                        .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                        .setGravity(Gravity.BOTTOM)
                        .create();
                dialog.show();

                ImageView finger = findViewById(R.id.pay_action_fingerprint_image);
                finger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //显示
                        ViewGroup successView = findViewById(R.id.pay_action_fingerprint_success);

                        TextView summaryView = findViewById(R.id.pay_action_fingerprint_success_detail_summary);
                        summaryView.setText("请至订单处查看进度");

                        ViewGroup fingerView = findViewById(R.id.pay_action_fingerprint_content);
                        fingerView.setVisibility(View.GONE);
                        successView.setVisibility(View.VISIBLE);

                        //开启一个倒计时 跳转到交易信息界面
                        mCountDownTimer = new CountDownTimer(1000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                TradeMessageActivity tradeMessageActivity = new TradeMessageActivity();
                                tradeMessageActivity.pushActivity(PayActionActivity.this,PayActionActivity.class);
                            }
                        };
                        mCountDownTimer.start();
                    }
                });


            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_action;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context, PayActionActivity.class);
        startWithNewAnimation(context, intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        dialog.dismiss();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}
