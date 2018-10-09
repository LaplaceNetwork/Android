package com.orangechain.laplace.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class CreatIdentityActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setBottomNavigationViewVisible(View.GONE);
        setToolbarVisible(View.GONE);

        Button button = findViewById(R.id.button_creat_identity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FingerprintOpenActivity fingerprintOpenActivity = new FingerprintOpenActivity();
                fingerprintOpenActivity.pushActivity(CreatIdentityActivity.this);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_creat_identity;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context, CreatIdentityActivity.class);
        startWithNewAnimation(context,intent);
    }
}
