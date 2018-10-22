package com.orangechain.laplace.activity.identity.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class AuthenticationActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("认证");


        Button authButton = findViewById(R.id.auth_permit_button);
        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticationProcessActivity authenticationProcessActivity = new AuthenticationProcessActivity();
                authenticationProcessActivity.pushActivity(AuthenticationActivity.this);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_authentication;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,AuthenticationActivity.class);
        startWithNewAnimation(context,intent);
    }
}
