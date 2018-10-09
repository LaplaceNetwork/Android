package com.orangechain.laplace.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class FingerprintOpenActivity extends BaseActivity {

    @Override
    public void initWithView() {
        setToolbarVisible(View.GONE);
        setBottomNavigationViewVisible(View.GONE);

        Button button = findViewById(R.id.open_fingerprint_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FingerprintOpenActivity.this,
//                        R.string.development_specification,Toast.LENGTH_SHORT).show();

                BackupsIdentityActivity backupsIdentityActivity = new BackupsIdentityActivity();
                backupsIdentityActivity.pushActivity(FingerprintOpenActivity.this);

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_fingerprint_open;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,FingerprintOpenActivity.class);
        startWithNewAnimation(context,intent);
    }
}
