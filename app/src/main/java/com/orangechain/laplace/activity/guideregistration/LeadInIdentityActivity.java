package com.orangechain.laplace.activity.guideregistration;


import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.cameraqrcode.CaptureActivity;

public class LeadInIdentityActivity extends BaseActivity {

    @Override
    public void initWithView() {
        setToolbarVisible(View.GONE);

        //修改图片的填充颜色
        Drawable imageViewDraw = ContextCompat.getDrawable(this, R.drawable.baseline_crop_free_black_24dp);
        imageViewDraw.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);

        imageViewDraw = ContextCompat.getDrawable(this, R.drawable.baseline_clear_black_24dp);
        imageViewDraw.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);

        // lead_in_search_imageview
        ImageView search = findViewById(R.id.lead_in_search_imageview);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //进入扫描界面
                CaptureActivity captureActivity = new CaptureActivity();
                captureActivity.pushActivity(LeadInIdentityActivity.this);
            }
        });

//        // lead_in_back_imageview
//        ImageView back = findViewById(R.id.lead_in_back_imageview);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                leftAction();
//            }
//        });

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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 101000 && resultCode == RESULT_OK) {
//            String result = data.getStringExtra(CaptureActivity.KEY_DATA);
//            Toast.makeText(this,"hahaha:" + result,Toast.LENGTH_SHORT).show();
//        }
//
//    }
}
