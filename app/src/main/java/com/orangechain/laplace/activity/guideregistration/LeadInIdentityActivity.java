package com.orangechain.laplace.activity.guideregistration;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class LeadInIdentityActivity extends BaseActivity {

    @Override
    public void initWithView() {
        setToolbarVisible(View.GONE);

        Button button = findViewById(R.id.button_creat_identity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FingerprintOpenActivity fingerprintOpenActivity = new FingerprintOpenActivity();
                fingerprintOpenActivity.pushActivity(LeadInIdentityActivity.this);

            }
        });



    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_lead_in_identity;
    }


    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,LeadInIdentityActivity.class);
        startWithNewAnimation(context,intent);
    }
}
