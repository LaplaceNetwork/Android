package com.orangechain.laplace.luncher;

import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.R;
import com.orangechain.laplace.logUtil.NavigationUtil;

public class ADLuncherActivity extends BaseActivity {


    @Override
    public void initWithView() {
        //隐藏相关的导航栏 此活动将会是一个广告界面
        NavigationUtil.NavigationBarStatusBar(this,true);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_adluncher;
    }

}
