package com.orangechain.laplace.luncher;

/**
 * 项目主入口 进行一些初始化的设计
 */

import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.R;
import com.orangechain.laplace.logUtil.NavigationUtil;

public class MainActivity extends BaseActivity {


    @Override
    public void initWithView() {
        //进行项目最初的元素设计
        initSystem();

        //初始化 进入分发界面
        IndexActivity.pushActivity(MainActivity.this);
    }

    /**
     * 对数据库 文件管理 版本控制 等等 进行初始化
     */
    protected void initSystem() {
        //隐藏相关的导航栏 此活动将会是一个广告界面
        NavigationUtil.NavigationBarStatusBar(this,true);

    }

    @Override
    public int getLayoutId() {
        //初始化界面
        return R.layout.activity_main;
    }

}
