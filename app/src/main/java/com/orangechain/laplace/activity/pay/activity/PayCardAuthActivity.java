package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.pay.PayFragment;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.base.BaseActivityCollector;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.ViewHolder;

public class PayCardAuthActivity extends BaseActivity {

    private boolean isSueccess;

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

                //显示提示内容
                final DialogPlus dialog = DialogPlus.newDialog(PayCardAuthActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.input_pay_card_auth_fingerprint))
                        .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                        .setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(DialogPlus dialog, View view) {
                                //回到首页 显示相关的内容
                                if (isSueccess) {
                                    IndexActivity indexActivity = (IndexActivity) BaseActivityCollector.finishAndGoBackHistoryActivity(IndexActivity.class);
                                    PayFragment payFragment = (PayFragment) indexActivity.getSupportFragmentManager().findFragmentByTag("pay");
                                    payFragment.finishViewTag("addCard");



                                }
                            }
                        })
                        .setOnDismissListener(new OnDismissListener() {
                            @Override
                            public void onDismiss(DialogPlus dialog) {
                                if (isSueccess) {
                                    IndexActivity indexActivity = (IndexActivity) BaseActivityCollector.finishAndGoBackHistoryActivity(IndexActivity.class);
                                    PayFragment payFragment = (PayFragment) indexActivity.getSupportFragmentManager().findFragmentByTag("pay");
                                    payFragment.finishViewTag("addCard");

                                }
                            }
                        })
                        .create();
                dialog.show();

                final View dialogContentView = dialog.getHolderView();

                ImageView imageView = dialogContentView.findViewById(R.id.pay_card_auth_fingerprint_image);

                if (imageView != null) {

                    imageView.setOnClickListener(new View.OnClickListener() {

                        View successView = dialogContentView.findViewById(R.id.pay_card_auth_fingerprint_success);
                        View contentView = dialogContentView.findViewById(R.id.pay_card_auth_fingerprint_content);

                        @Override
                        public void onClick(View v) {

                            contentView.setVisibility(View.GONE);
                            successView.setVisibility(View.VISIBLE);

                            isSueccess = true;

                            Drawable imageViewDraw = ContextCompat.getDrawable(PayCardAuthActivity.this, R.drawable.baseline_check_circle_black_24dp);
                            imageViewDraw.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                            getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);
                        }
                    });
                }
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
