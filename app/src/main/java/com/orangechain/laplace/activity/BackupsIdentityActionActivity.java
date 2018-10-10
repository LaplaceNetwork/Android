package com.orangechain.laplace.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class BackupsIdentityActionActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setBottomNavigationViewVisible(View.GONE);

        setToolBarText("立即备份");

        setToolBarBackColor(R.color.colorPrimary);
        setToolBarTextColor(R.color.colorWhite);
        setToolBarLeftColor(R.color.colorWhite);

        //修改图片的填充颜色
        Drawable imageViewDraw = ContextCompat.getDrawable(this, R.drawable.baseline_report_black_24dp);
        imageViewDraw.setColorFilter(getResources().getColor(R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);


        Button exportButton = findViewById(R.id.export_keystory_botton);
        exportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //进入首页

            }
        });

        Button watchButton = findViewById(R.id.watch_keystory_botton);
        watchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //查看二维码
                BackupsQRCodeActivity backupsQRCodeActivity = new BackupsQRCodeActivity();
                backupsQRCodeActivity.pushActivity(BackupsIdentityActionActivity.this);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_backups_identity_action;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,BackupsIdentityActionActivity.class);
        startWithNewAnimation(context,intent);
    }
}
