package com.orangechain.laplace.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.currenttime.CurrentTimeFragment;
import com.orangechain.laplace.activity.googleverify.GoogleVerityFragment;
import com.orangechain.laplace.activity.googleverify.activity.AuthPhoneActivity;
import com.orangechain.laplace.activity.guideregistration.CreatIdentityActivity;
import com.orangechain.laplace.activity.guideregistration.LeadInIdentityActivity;
import com.orangechain.laplace.activity.guideregistration.QRCodeActivity;
import com.orangechain.laplace.activity.identity.IdentityFragment;
import com.orangechain.laplace.activity.identity.activity.SystemSettingActivity;
import com.orangechain.laplace.activity.monitoringcenter.MonitoringCenterFragment;
import com.orangechain.laplace.activity.pay.PayFragment;
import com.orangechain.laplace.activity.pay.activity.PayAddCardActivity;
import com.orangechain.laplace.base.BaseActivityCollector;
import com.orangechain.laplace.base.BaseBottomNavigationActivity;
import com.orangechain.laplace.base.laplaceBaseView.laplaceToolbar;
import com.orangechain.laplace.cameraqrcode.CaptureActivity;
import com.orangechain.laplace.interfac.BottomNavigationViewInterface;


public class IndexActivity extends BaseBottomNavigationActivity implements BottomNavigationViewInterface {

    //初次初始化
    private boolean isFirstInit = true;
    private int currentPage; //记录当前的主功能界面

    //几个主要的home界面
    private CurrentTimeFragment currentTimeFragment;
    private GoogleVerityFragment googleVerityFragment;
    private IdentityFragment identityFragment;
    private MonitoringCenterFragment monitoringCenterFragment;
    private PayFragment payFragment;

    //通知
    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    public void pushActivity(Context context) {
        Intent intent = new Intent(context, IndexActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //注册本地通知
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.orangechain.laplace.IndexActivity.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);

    }

    @Override
    public void initWithView() {

        super.initWithView();

        //第一次进入的时候 需要展示引导页
        if (isFirstInit) {

            //获取父view 其上加载引导界面
            getLayoutInflater().inflate(R.layout.activity_index, getBaseViewGroup());

            //隐藏导航栏
            setToolbarVisible(View.GONE);
//            setBottomNavigationViewVisible(View.GONE);

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

        } else {

            //创建主界面
            initMainUI();
        }
    }

    /**
     * 正式创建首页
     */
    public void initMainUI() {

        //移除其他view
        ViewGroup viewGroup = findViewById(R.id.main_frame);
        viewGroup.removeAllViewsInLayout();
        //移除引导页
        ViewGroup guidanceGroup = (ViewGroup) getBaseViewGroup().findViewById(R.id.guidance_index);
        if (guidanceGroup != null) {
            getBaseViewGroup().removeView(guidanceGroup);
        }

        //显示导航栏
        setToolbarVisible(View.VISIBLE);
//        setBottomNavigationViewVisible(View.VISIBLE);

        //设置代理
        BottomNavigationViewEvent.setBottomNavigationVInterface(this);

        //主界面 隐藏返回按钮
        setToolBarLeftShow(false);

        //创建主要的活动界面
        currentTimeFragment = new CurrentTimeFragment();
        googleVerityFragment = new GoogleVerityFragment();
        identityFragment = new IdentityFragment();
        monitoringCenterFragment = new MonitoringCenterFragment();
        payFragment = new PayFragment();

        //设置主界面内容
        setMainFragment(identityFragment,"id");
        changeToolBarContent(R.id.nav_home_id);

    }

    //修改顶部导航栏样式
    public void changeToolBarContent(int page) {

        //记录当前的主功能界面
        currentPage = page;

        android.support.v7.widget.Toolbar toolbar = getToolBar();
        switch (page) {
            case R.id.nav_home_id:
                ((laplaceToolbar) toolbar).setMainTitle("");
                ((laplaceToolbar) toolbar).setLeftTitleText("Laplace-ID");
                ((laplaceToolbar) toolbar).setLeftTitleColor(getResources().getColor(R.color.color022656));
                ((laplaceToolbar) toolbar).setLeftTitleSize(getResources().getDimensionPixelSize(R.dimen.text_size_25));
                ((laplaceToolbar) toolbar).setLeftTitleDrawableHidden();
                ((laplaceToolbar) toolbar).setLeftTitlePadding(21, 0, 0, 0);
                ((laplaceToolbar) toolbar).setRightTitleDrawable(R.drawable.baseline_settings_black_24dp);
                ((laplaceToolbar) toolbar).setRightTitlePadding(0, 0, 21, 0);

                //修改toobar背景色
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                changePictureColor(R.drawable.baseline_settings_black_24dp, R.color.color2C467B);

                ((laplaceToolbar) toolbar).setRightVisible(View.VISIBLE);
                ((laplaceToolbar) toolbar).setRightTitleText("");

                //显示switch按钮
                ((laplaceToolbar) toolbar).setSwitchVisible(View.GONE);

                return;
            case R.id.nav_pay:
                ((laplaceToolbar) toolbar).setMainTitle("");
                ((laplaceToolbar) toolbar).setLeftTitleText("Laplace-Pay");
                ((laplaceToolbar) toolbar).setLeftTitleColor(getResources().getColor(R.color.color022656));
                ((laplaceToolbar) toolbar).setLeftTitleSize(getResources().getDimensionPixelSize(R.dimen.text_size_25));
                ((laplaceToolbar) toolbar).setLeftTitleDrawableHidden();
                ((laplaceToolbar) toolbar).setLeftTitlePadding(21, 0, 0, 0);
                ((laplaceToolbar) toolbar).setRightTitleDrawable(R.drawable.baseline_add_black_24dp);
                ((laplaceToolbar) toolbar).setRightTitlePadding(0, 0, 21, 0);

                toolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                changePictureColor(R.drawable.baseline_add_black_24dp, R.color.color2C467B);

                ((laplaceToolbar) toolbar).setRightVisible(View.VISIBLE);
                ((laplaceToolbar) toolbar).setRightTitleText("");

                //显示switch按钮
                ((laplaceToolbar) toolbar).setSwitchVisible(View.GONE);

                return;
            case R.id.nav_google_verity:
                ((laplaceToolbar) toolbar).setMainTitle("");
                ((laplaceToolbar) toolbar).setLeftTitleText("谷歌验证器");
                ((laplaceToolbar) toolbar).setLeftTitleColor(getResources().getColor(R.color.colorWhite));
                ((laplaceToolbar) toolbar).setLeftTitleSize(getResources().getDimensionPixelSize(R.dimen.text_size_25));
                ((laplaceToolbar) toolbar).setLeftTitleDrawableHidden();
                ((laplaceToolbar) toolbar).setLeftTitlePadding(21, 0, 0, 0);
                ((laplaceToolbar) toolbar).setRightTitleDrawable(R.drawable.baseline_add_black_24dp);
                ((laplaceToolbar) toolbar).setRightTitlePadding(0, 0, 21, 0);

                toolbar.setBackgroundColor(getResources().getColor(R.color.color022656));
                changePictureColor(R.drawable.baseline_add_black_24dp, R.color.colorWhite);

                ((laplaceToolbar) toolbar).setRightVisible(View.VISIBLE);
                ((laplaceToolbar) toolbar).setRightTitleText("");

                //显示switch按钮
                ((laplaceToolbar) toolbar).setSwitchVisible(View.GONE);

                return;
            case R.id.nav_current_time:
                ((laplaceToolbar) toolbar).setMainTitle("");
                ((laplaceToolbar) toolbar).setLeftTitleText("实时动态");
                ((laplaceToolbar) toolbar).setLeftTitleColor(getResources().getColor(R.color.colorWhite));
                ((laplaceToolbar) toolbar).setLeftTitleSize(getResources().getDimensionPixelSize(R.dimen.text_size_25));
                ((laplaceToolbar) toolbar).setLeftTitleDrawableHidden();
                ((laplaceToolbar) toolbar).setLeftTitlePadding(21, 0, 0, 0);

                toolbar.setBackgroundColor(getResources().getColor(R.color.color022656));

                ((laplaceToolbar) toolbar).setRightVisible(View.VISIBLE);

                //隐藏右边图片
                ((laplaceToolbar) toolbar).setRightTitleDrawableHidden();
                ((laplaceToolbar) toolbar).setRightTitleText("动态列表");
                ((laplaceToolbar) toolbar).setRightTitleColor(getResources().getColor(R.color.colorWhite));

                //显示switch按钮
                ((laplaceToolbar) toolbar).setSwitchVisible(View.VISIBLE);

                return;
            case R.id.nav_monitoring_center:
                ((laplaceToolbar) toolbar).setMainTitle("");
                ((laplaceToolbar) toolbar).setLeftTitleText("Laplace控制台");
                ((laplaceToolbar) toolbar).setLeftTitleColor(getResources().getColor(R.color.color022656));
                ((laplaceToolbar) toolbar).setLeftTitleSize(getResources().getDimensionPixelSize(R.dimen.text_size_25));
                ((laplaceToolbar) toolbar).setLeftTitleDrawableHidden();
                ((laplaceToolbar) toolbar).setLeftTitlePadding(21, 0, 0, 0);

                toolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));

                ((laplaceToolbar) toolbar).setRightVisible(View.INVISIBLE);
                ((laplaceToolbar) toolbar).setRightTitleText("");

                //显示switch按钮
                ((laplaceToolbar) toolbar).setSwitchVisible(View.GONE);

                return;
            default:
                return;
        }

    }

    /**
     * 执行右边点击按钮 执行相关功能
     */
    @Override
    public void rightFirstButtonAction() {

        switch (currentPage) {

            case R.id.nav_home_id:
                //进入设置界面
                SystemSettingActivity systemSettingActivity = new SystemSettingActivity();
                systemSettingActivity.pushActivity(IndexActivity.this);
                return;
            case R.id.nav_google_verity:
                //显示相关的内容在主界面上
                final ViewGroup showViewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.input_google_verification_frame, getBaseViewGroup());

                final View baseView = showViewGroup.findViewById(R.id.input_google_verification_frame_layout);
                baseView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showViewGroup.removeView(baseView);
                    }
                });

                View QRCodeView = showViewGroup.findViewById(R.id.google_verification_qrcode_textview);
                QRCodeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //进入二维码界面
//                        QRCodeActivity qrCodeActivity = new QRCodeActivity();
//                        qrCodeActivity.pushActivity(IndexActivity.this);

                        //进入扫描界面
                        CaptureActivity captureActivity = new CaptureActivity();
                        captureActivity.pushActivity(IndexActivity.this);



                    }
                });

                View authView = showViewGroup.findViewById(R.id.google_verification_auth_textview);
                authView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //进入验证界面
                        AuthPhoneActivity authPhoneActivity = new AuthPhoneActivity();
                        authPhoneActivity.pushActivity(IndexActivity.this);
                    }
                });
                return;
            case R.id.nav_current_time:

                ViewGroup view = (ViewGroup) findViewById(R.id.fragment_current_time_layout);
                View oldListView = findViewById(R.id.input_current_time_list_frame_layout);
                if (oldListView != null) {
                    view.removeView(oldListView);
                } else {
                    //显示列表
                    getLayoutInflater().inflate(R.layout.input_current_time_list_frame, view);
                    currentTimeFragment.showTimeListView();
                }
                return;

            case R.id.nav_pay:

                PayAddCardActivity payAddCardActivity = new PayAddCardActivity();
                payAddCardActivity.pushActivity(IndexActivity.this);

                return;
            default:
                return;


        }

    }

    @Override
    public void rightSwitchButtonAction() {
        super.rightSwitchButtonAction();

        //显示弹幕

    }

    //修改资源图片颜色
    public void changePictureColor(int imageRes, int color) {
        Drawable imageViewDraw = ContextCompat.getDrawable(this, imageRes);
        imageViewDraw.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(imageViewDraw);
    }

    @Override
    public void clickNavigationItemListener(int itemId) {
        switch (itemId) {
            case R.id.nav_home_id:
                setMainFragment(identityFragment,"id");
                changeToolBarContent(R.id.nav_home_id);
                return;
            case R.id.nav_pay:
                setMainFragment(payFragment,"pay");
                changeToolBarContent(R.id.nav_pay);
                return;
            case R.id.nav_google_verity:
                setMainFragment(googleVerityFragment,"googleVerity");
                changeToolBarContent(R.id.nav_google_verity);
                return;
            case R.id.nav_current_time:
                setMainFragment(currentTimeFragment,"currentTime");
                changeToolBarContent(R.id.nav_current_time);
                return;
            case R.id.nav_monitoring_center:
                setMainFragment(monitoringCenterFragment,"monitoringCenter");
                changeToolBarContent(R.id.nav_monitoring_center);
                return;
            default:
                return;
        }
    }

    /**
     * 设置主fragment
     * 切换当前的布局
     */
    private void setMainFragment(Fragment fragment,String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment,tag);
        fragmentTransaction.commitAllowingStateLoss();
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
//        if (isFirstInit) {
//            return R.layout.activity_index;
//        }

        //不加载引导界面 由代码动态加载
        return -1;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    //接受本地通知
    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            initMainUI();

        }
    }

}
