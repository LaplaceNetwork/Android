package com.orangechain.laplace.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.orangechain.laplace.R;
import com.orangechain.laplace.base.laplaceBaseView.laplaceToolbar;
import com.orangechain.laplace.interfac.BottomNavigationViewInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    private ViewGroup viewGroup;
    private laplaceToolbar toolbar;
    private FrameLayout mFrameLayout;
    public BottomNavigationView bottomNavigationView;
    private int mLayoutResID;

    /**
     * 此变量用于启动activity时的标识，用于判断activity结束时是否覆盖原有动画，以保持启动退出动画一致性
     */
    private static boolean isFromActivityStart = false;

    /**
     * 结束动画
     */
    private static int exitAnimation = 0;

    /**
     * ******************************************************************
     */

    /**
     * 进行界面内容的初始化 在子类进行实现
     */
    public abstract void initWithView();

    /**
     * 获取要布置的UI ID
     */
    public abstract int getLayoutId();

    /**
     * 创建跳转方法
     */
    public abstract void pushActivity(Context context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseActivityCollector.addActivity(this);

        //打印进入活动的名称
//        logUtil.d("BaseActivity",getClass().getSimpleName());

        setContentView(getLayoutId());

        initWithView();
    }

    @Override
    public void setContentView(int layoutResID) {
        //设置界面的一些主要的样式
        super.setContentView(R.layout.activity_base);
        //设置toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setLeftTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftAction();
            }
        });

        toolbar.setRightTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this, "点击了右侧Title", Toast.LENGTH_SHORT).show();
            }
        });

        //设置主要的framelayput
        mFrameLayout = findViewById(R.id.main_frame);

        //设置bottomNavigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home_id:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_home_id);
                        return true;
                    case R.id.nav_pay:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_pay);
                        return true;
                    case R.id.nav_google_verity:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_google_verity);
                        return true;
                    case R.id.nav_current_time:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_current_time);
                        return true;
                    case R.id.nav_monitoring_center:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_monitoring_center);
                        return true;
                    default:
                        return false;
                }
            }
        });


        mLayoutResID = layoutResID;

        //将布局文件放在父容器内
        if (mLayoutResID != -1) {

            //拿到主界面
            viewGroup = findViewById(R.id.main_frame);

            //将子类的界面放上去
            getLayoutInflater().inflate(mLayoutResID,viewGroup);
        }

        //设置界面的主要方向 纵向
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //设置键盘不挤压布局
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN|WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //保证app字号在控制范围内进行修改
        Resources resource = this.getResources();
        Configuration configuration = resource.getConfiguration();
        configuration.fontScale = 1.0f;// 设置字体的缩放比例
        resource.updateConfiguration(configuration, resource.getDisplayMetrics());
    }

    /**
     * 设置标题
     * @param text
     */
    public void setToolBarText(String text) {
        toolbar.setMainTitle(text);
    }

    /**
     * 设置toolbar是否显示
     */
    public void setToolbarVisible(int visible) {
        toolbar.setVisibility(visible);
    }

    /**
     * 设置ToolBar的颜色
     */

    public void setToolBarBackColor(int color) {
        toolbar.setBackgroundColor(getResources().getColor(color));
    }

    /**
     * 设置ToolBar字体颜色
     */
    public void setToolBarTextColor(int color) {
        toolbar.setMainTitleColor(getResources().getColor(color));
    }

    /**
     * 设置返回键图片
     */
    public void setToolBarLeftImage(int res) {
        toolbar.setLeftTitleDrawable(res);
    }

    /**
     * 设置返回按钮图片颜色
     * @param colorId
     */
    public void setToolBarLeftColor(@ColorRes int colorId) {
        Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.baseline_navigate_before_black_24dp);
        upArrow.setColorFilter(getResources().getColor(colorId), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

    }

    /**
     * 是否显示返回按钮 默认是显示
     */
    public void setToolBarLeftShow(boolean isShow) {
        if (isShow) {
            //显示出来
            toolbar.setLeftTitleShow(true);
        } else {
            //隐藏起来
            toolbar.setLeftTitleShow(false);
        }
    }

    /**
     * 设置BottomNavigationView是否显示
     */
    public void setBottomNavigationViewVisible(int visible) {
        bottomNavigationView.setVisibility(visible);
    }


    /**
     * 创建一个关于BottomNavigationView接口的内部类
     */
    public static class BottomNavigationViewEvent {

        private static BottomNavigationViewInterface mBottomNavigationViewInterface;


        public static void setBottomNavigationVInterface(BottomNavigationViewInterface BNVInterface) {

            mBottomNavigationViewInterface = BNVInterface;

        }

        public static void clickItemAction(int actionId) {
            mBottomNavigationViewInterface.clickNavigationItemListener(actionId);
        }

    }

    /**
     * 返回事件
     *
     */
    public void leftAction(){
        this.finish();
        BaseActivityCollector.removeActivity(this);
    }


    /**
     * 重写系统返回事件
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            leftAction();
            return true;
        }
        return false;
    }

    /**
     * ******************************此处管理活动之间跳转的动画
     */

    /**
     * 获取启动intent
     *
     * @param context
     * @param tClass
     * @return
     */
    public static Intent getLaunchIntent(Context context, Class<? extends BaseActivity> tClass) {
        return new Intent(context, tClass);
    }

    /**
     * 带动画启动页面，覆盖系统原有动画样式原理是startactivity 前overridePendingTransition（）
     *
     * @param context 这里需要context是activity实例才能覆盖动画效果，否则仍旧是系统原有动画样式
     * @param intent  调用getLaunchIntent方法获取
     */
    public static void startWithOldAnimation(Context context, Intent intent) {
        if (context instanceof Activity) {
            isFromActivityStart = true;
            exitAnimation = 0;
            context.startActivity(intent);//须在activity启动前调用
//            ((Activity) context).overridePendingTransition(R.anim.slide_in_right, 0);本应该是这个参数，但是有的机型会有前一个activity结束动画，所以需要虚拟一个动画代替，做到保持原有页面不动的效果
            ((Activity) context).overridePendingTransition(R.anim.slide_in, R.anim.slide_none);
        } else {//context 非activity的情形 ,无法调用覆盖方法，因此还是系统默认的跳转动画
            isFromActivityStart = false;
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * @param context        这里需要context是activity实例才能覆盖动画效果，否则仍旧是系统原有动画样式
     * @param intent         调用getLaunchIntent方法获取
     * @param enterAnimation 进入动画
     * @param exiteAnimation 结束动画
     */
    public static void startWithOldAnimation(Context context, Intent intent, int enterAnimation, int exiteAnimation) {
        if (context instanceof Activity) {
            isFromActivityStart = true;
            exitAnimation = exiteAnimation;
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(enterAnimation, R.anim.slide_none);
        } else {
            isFromActivityStart = false;
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * 带动画启动页面，使用ActivityOptionsCompat实现 4.1以上有效
     *
     * @param context 这里需要context是activity实例才能覆盖动画效果，否则仍旧是系统原有动画样式
     * @param intent  调用getLaunchIntent方法获取
     */
    public static void startWithNewAnimation(Context context, Intent intent) {
        if (context instanceof Activity) {
            isFromActivityStart = true;
            exitAnimation = 0;
            ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.slide_in, R.anim.slide_none);
            ActivityCompat.startActivity((Activity) context, intent, compat.toBundle());
        } else {//context 非activity的情形 ,无法调用覆盖方法，因此还是系统默认的跳转动画
            isFromActivityStart = false;
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * @param context        这里需要context是activity实例才能覆盖动画效果，否则仍旧是系统原有动画样式
     * @param intent         调用getLaunchIntent方法获取
     * @param enterAnimation 进入动画
     * @param exiteAnimation 结束动画
     */
    public static void startWithNewAnimation(Context context, Intent intent, int enterAnimation, int exiteAnimation) {
        if (context instanceof Activity) {
            isFromActivityStart = true;
            exitAnimation = exiteAnimation;
            ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, enterAnimation, R.anim.slide_none);
            ActivityCompat.startActivity((Activity) context, intent, compat.toBundle());
        } else {
            isFromActivityStart = false;
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * 处理点击系统返回按钮
     */
    @Override
    public void finish() {
        super.finish();
        if (isFromActivityStart)
            overridePendingTransition(0, exitAnimation == 0 ? R.anim.slide_out : exitAnimation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this != null) {
            BaseActivityCollector.removeActivity(this);
        }
    }

    /**
     * ******************************此处管理屏幕的一些内容
     */

    /**
     * 获取屏幕的高度和宽度
     */
    public int[] getScreenProperty() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        int screenHeight = (int) (height / density);// 屏幕高度(dp)


        Log.d("h_bl", "屏幕宽度（像素）：" + width);
        Log.d("h_bl", "屏幕高度（像素）：" + height);
        Log.d("h_bl", "屏幕密度（0.75 / 1.0 / 1.5）：" + density);
        Log.d("h_bl", "屏幕密度dpi（120 / 160 / 240）：" + densityDpi);
        Log.d("h_bl", "屏幕宽度（dp）：" + screenWidth);
        Log.d("h_bl", "屏幕高度（dp）：" + screenHeight);

        return new int[]{screenWidth, screenHeight};
    }



}
