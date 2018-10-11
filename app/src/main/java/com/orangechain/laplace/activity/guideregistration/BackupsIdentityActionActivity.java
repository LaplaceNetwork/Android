package com.orangechain.laplace.activity.guideregistration;


import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.base.BaseActivityCollector;

public class BackupsIdentityActionActivity extends BaseActivity {

    LocalBroadcastManager localBroadcastManager;

    @Override
    public void initWithView() {

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

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
                //进入主界面
                BaseActivityCollector.finishAndGoBackHistoryActivity(IndexActivity.class);
                //显示主界面 隐藏index界面
                Intent intent = new Intent("com.orangechain.laplace.IndexActivity.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
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
