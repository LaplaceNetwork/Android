package com.orangechain.laplace.logUtil;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/******************** 隐藏各种导航栏 状态栏等操作 ***************/

public class NavigationUtil {

    /**
     * 设置状态栏的颜色
     * @param activity
     * @param color
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void statusBarTintColor(Activity activity, int color) {

        //代表 5.0 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(color);
            return;
        }

        //versionCode > 4.4 and versionCode < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup androidContainer = (ViewGroup) activity.findViewById(android.R.id.content);
            //留出高度 setFitsSystemWindows true 代表会调整布局，会把状态栏的高度留出来
            View contentView = androidContainer.getChildAt(0);
            if (contentView != null) {
                contentView.setFitsSystemWindows(true);
            }
            // 在原来的位置上添加一个状态栏
            View statusBarView = createStatusBarView(activity);
            androidContainer.addView(statusBarView,0);
            statusBarView.setBackgroundColor(color);
        }

    }

    /**
     * 创建一个需要填充的statusBarView
     */
    public static View createStatusBarView(Activity activity) {
        View statusBarView = new View(activity);
        ViewGroup.LayoutParams statusBarParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(activity));
        return statusBarView;

    }

    /**
     * 获取状态栏的高度
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceID = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceID > 0) {
            result = context.getResources().getDimensionPixelSize(resourceID);
        }
        return result;
    }


    /**
     * 隐藏导航栏
     * @param activity
     * @param visible
     */
    public static void setNavigationBar(Activity activity,int visible) {

        View decorView = activity.getWindow().getDecorView();
        //显示NavigationBar
        if (View.VISIBLE == visible) {
            int option = android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            decorView.setSystemUiVisibility(option);
        }
    }

    //注意： app 全屏 分为隐藏导航栏和不隐藏导航栏（状态栏和actionbar（toolbar）隐藏）

    /**
     * 隐藏状态栏和actionbar位置
     * @param activity
     */
    public static void statusBarHide(Activity activity) {
        // 代表 5.0 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
            return;
        }

        // versionCode > 4.4 and versionCode < 5.0
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 导航栏 状态栏隐藏 拖动会出现
     * @param activity
     * @param hasFocus
     */
    public static void NavigationBarStatusBar(Activity activity,boolean hasFocus) {
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    /**
     * 导航栏 状态栏设置透明
     * @param activity
     */
    public static void setNavigationBarStatusBarTranslucent(Activity activity) {

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        return;
    }
}
