package com.orangechain.laplace.activity.identity.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.ToolHelper;
import com.orangechain.laplace.activity.identity.activity.adapter.SystemSettingAdapter;
import com.orangechain.laplace.activity.identity.activity.bean.SystemSettingBean;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.interfac.SystemSettingInterface;

import java.util.ArrayList;
import java.util.List;

public class SystemSettingActivity extends BaseActivity implements SystemSettingInterface {


    private List<SystemSettingBean> listArr = new ArrayList<>();


    @Override
    public void initWithView() {

        setToolBarText("系统设置");

        listArr.clear();

        //创建数据源
        SystemSettingBean bean0 = new SystemSettingBean("Face ID", true, "");
        SystemSettingBean bean1 = new SystemSettingBean("语言设置", false, "中文");
        SystemSettingBean bean2 = new SystemSettingBean("推送管理", false, "");

        listArr.add(bean0);
        listArr.add(bean1);
        listArr.add(bean2);

        SystemSettingAdapter adapter = new SystemSettingAdapter(this, R.layout.item_system_setting, listArr);
        ListView listView = findViewById(R.id.system_setting_listview);
        listView.setAdapter(adapter);

        //修改图片的颜色
        getSupportActionBar().setHomeAsUpIndicator(ToolHelper.changePictureColor(this, R.color.colorB8BEC9, R.drawable.baseline_keyboard_arrow_right_black_24dp));

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_system_setting;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context, SystemSettingActivity.class);
        startWithNewAnimation(context, intent);
    }

    @Override
    public void clickRightButton(String buttonMark) {

        if (buttonMark == "language") {
            LanguageSettingActivity languageSettingActivity = new LanguageSettingActivity();
            languageSettingActivity.pushActivity(SystemSettingActivity.this);
        } else if (buttonMark == "push") {
            PushSettingActivity pushSettingActivity = new PushSettingActivity();
            pushSettingActivity.pushActivity(SystemSettingActivity.this);
        }

    }
}
