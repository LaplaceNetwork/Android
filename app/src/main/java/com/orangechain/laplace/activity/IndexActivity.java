package com.orangechain.laplace.activity;

import android.content.Context;
import android.content.Intent;
import android.content.RestrictionEntry;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.currenttime.CurrentTimeFragment;
import com.orangechain.laplace.activity.googleverify.GoogleVerityFragment;
import com.orangechain.laplace.activity.identity.IdentityFragment;
import com.orangechain.laplace.activity.monitoringcenter.MonitoringCenterFragment;
import com.orangechain.laplace.activity.pay.PayFragment;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.base.BaseActivityCollector;
import com.orangechain.laplace.interfac.BottomNavigationViewInterface;


public class IndexActivity extends BaseActivity implements BottomNavigationViewInterface {

    //初次初始化
    private boolean isFirstInit = true;

    //几个主要的home界面
    private CurrentTimeFragment currentTimeFragment;
    private GoogleVerityFragment googleVerityFragment;
    private IdentityFragment identityFragment;
    private MonitoringCenterFragment monitoringCenterFragment;
    private PayFragment payFragment;

    @Override
    public void pushActivity(Context context) {
        Intent intent = new Intent(context,IndexActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initWithView() {

        //创建主要的活动界面
        currentTimeFragment = new CurrentTimeFragment();
        googleVerityFragment = new GoogleVerityFragment();
        identityFragment = new IdentityFragment();
        monitoringCenterFragment = new MonitoringCenterFragment();
        payFragment = new PayFragment();

        setMainFragment(identityFragment);

        //设置代理
        BottomNavigationViewEvent.setBottomNavigationVInterface(this);

        //隐藏返回按钮
        setToolBarLeftShow(false);

        if (isFirstInit) {
            setToolbarVisible(View.GONE);
            setBottomNavigationViewVisible(View.GONE);

            //导入用户
            Button button_input = findViewById(R.id.button_input_index);
            button_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LeadInIdentityActivity leadInIdentityActivity = new LeadInIdentityActivity();
                    leadInIdentityActivity.pushActivity(IndexActivity.this);
                }
            });

            //创建用户
            Button button_creat = findViewById(R.id.button_creat_index);
            button_creat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreatIdentityActivity creatIdentityActivity = new CreatIdentityActivity();
                    creatIdentityActivity.pushActivity(IndexActivity.this);
                }
            });
            }
        }

    @Override
    public void clickNavigationItemListener(int itemId) {
        switch (itemId) {
            case R.id.nav_home_id:
                setMainFragment(identityFragment);
                return;
            case R.id.nav_pay:
                setMainFragment(payFragment);
                return;
            case R.id.nav_google_verity:
                setMainFragment(googleVerityFragment);
                return;
            case R.id.nav_current_time:
                setMainFragment(currentTimeFragment);
                return;
            case R.id.nav_monitoring_center:
                setMainFragment(monitoringCenterFragment);
                return;
            default:
                return;
        }
    }

    /**
     * 设置主fragment
     * 切换当前的布局
     */
    private void setMainFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//        android.os.Process.killProcess(android.os.Process.myPid()); 由于关闭的所有的活动 可以关闭当前的进程
        BaseActivityCollector.finishAllActivity();
        return true;
    }

    @Override
    public int getLayoutId() {
        if (isFirstInit) {
            return R.layout.activity_index;
        }
        return -1;
    }
}
