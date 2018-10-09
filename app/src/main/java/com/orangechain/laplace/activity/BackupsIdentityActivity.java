package com.orangechain.laplace.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class BackupsIdentityActivity extends BaseActivity {

    @Override
    public void initWithView() {
        setToolbarVisible(View.GONE);
        setBottomNavigationViewVisible(View.GONE);

        Button button = findViewById(R.id.backups_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackupsIdentityActionActivity backupsIdentityActionActivity = new BackupsIdentityActionActivity();
                backupsIdentityActionActivity.pushActivity(BackupsIdentityActivity.this);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_backups_identity;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,BackupsIdentityActivity.class);
        startWithNewAnimation(context,intent);
    }
}
