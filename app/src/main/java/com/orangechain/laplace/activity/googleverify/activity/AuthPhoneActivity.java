package com.orangechain.laplace.activity.googleverify.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.guideregistration.QRCodeActivity;
import com.orangechain.laplace.base.BaseActivity;

public class AuthPhoneActivity extends BaseActivity {


    @Override
    public void initWithView() {

        setToolBarText("手动输入验证码");
        setToolBarTextColor(R.color.color333333);
        setToolBarTextSize(R.dimen.text_size_17);

        //修改界面内容
        ViewGroup viewGroupAccoount = findViewById(R.id.auth_account_layout);

        TextView name = viewGroupAccoount.findViewById(R.id.auth_name);
        name.setText("账户");
        TextView des = viewGroupAccoount.findViewById(R.id.auth_des);
        des.setText("user@example.com");

        ViewGroup viewGroupSecretkey = findViewById(R.id.auth_secretkey_layout);

        name = viewGroupSecretkey.findViewById(R.id.auth_name);
        name.setText("密钥");
        des = viewGroupSecretkey.findViewById(R.id.auth_des);
        des.setText("1234 5678 9000 0000");


        Button button = findViewById(R.id.auth_confirm_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                leftAction();

            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_auth_phone;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,AuthPhoneActivity.class);
        startWithNewAnimation(context,intent);

    }

}
