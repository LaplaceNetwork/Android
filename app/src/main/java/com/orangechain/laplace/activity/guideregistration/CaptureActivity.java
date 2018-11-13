package com.orangechain.laplace.activity.guideregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;

public class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback {


    @Override
    public void initWithView() {

        setToolBarText("二维码扫描");

    }

    // SurfaceHolder.Callback 三个接口方法
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_capture;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,CaptureActivity.class);
        startWithNewAnimation(context,intent);

    }
}
