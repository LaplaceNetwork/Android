package com.orangechain.laplace.activity.guideregistration;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.QRCodeUtil;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.base.BaseActivityCollector;

public class BackupsQRCodeActivity extends BaseActivity {

    LocalBroadcastManager localBroadcastManager;


    @Override
    public void initWithView() {

        setToolBarText("备份身份");
        setToolBarBackColor(R.color.colorPrimary);
        setToolBarTextColor(R.color.colorWhite);
        setToolBarLeftColor(R.color.colorWhite);

        //本地通知
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        //生成二维码
        ImageView imageView = findViewById(R.id.QRCode_imageview);
        Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap("https://www.baidu.com", 480, 480);//之后根据具体的数据生成图片
        imageView.setImageBitmap(mBitmap);


        //修改图片的填充颜色
        Drawable imageViewDraw = ContextCompat.getDrawable(this, R.drawable.baseline_report_black_24dp);
        imageViewDraw.setColorFilter(getResources().getColor(R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);

        Button saveButton = findViewById(R.id.QRCode_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入主界面
                BaseActivityCollector.finishAndGoBackHistoryActivity(IndexActivity.class);
                //显示主界面 隐藏index界面
                Intent intent = new Intent("com.orangechain.laplace.IndexActivity.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,BackupsQRCodeActivity.class);
        startWithNewAnimation(context,intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_backups_qrcode;
    }
}
