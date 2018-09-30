package com.orangechain.laplace.activity;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class LeadInIdentityActivity extends BaseActivity {

    @Override
    public void initWithView() {
        toolbar.setVisibility(View.INVISIBLE);
        bottomNavigationView.setVisibility(View.INVISIBLE);



    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_lead_in_identity;
    }

    /**
     * 进入此活动
     * @param context
     */
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,LeadInIdentityActivity.class);
        startWithNewAnimation(context,intent);
    }


}
