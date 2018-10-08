package com.orangechain.laplace.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class BackupsIdentityActivity extends BaseActivity {

    @Override
    public void initWithView() {
        toolbar.setVisibility(View.INVISIBLE);
        bottomNavigationView.setVisibility(View.INVISIBLE);



    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_backups_identity;
    }

    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,BackupsIdentityActivity.class);
        startWithNewAnimation(context,intent);
    }
}
