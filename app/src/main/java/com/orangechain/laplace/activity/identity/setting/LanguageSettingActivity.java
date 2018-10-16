package com.orangechain.laplace.activity.identity.setting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.setting.adapter.LanguageSettingAdapter;
import com.orangechain.laplace.activity.identity.setting.bean.LanguageSettingBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class LanguageSettingActivity extends BaseActivity {

    private List<LanguageSettingBean> listArr = new ArrayList<>();


    @Override
    public void initWithView() {

        setToolBarText("语言设置");

        //创建数据源
        listArr.clear();
        LanguageSettingBean bean0 = new LanguageSettingBean("中文",true);
        LanguageSettingBean bean1 = new LanguageSettingBean("English",false);
        LanguageSettingBean bean2 = new LanguageSettingBean("Korea",false);
        listArr.add(bean0);
        listArr.add(bean1);
        listArr.add(bean2);


        LanguageSettingAdapter adapter = new LanguageSettingAdapter(this,R.layout.language_setting_item,listArr);
        ListView listView = findViewById(R.id.language_setting_listview);
        listView.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_language_setting;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,LanguageSettingActivity.class);
        startWithNewAnimation(context,intent);
    }
}
