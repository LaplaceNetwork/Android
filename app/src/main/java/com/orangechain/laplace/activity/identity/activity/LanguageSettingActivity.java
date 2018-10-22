package com.orangechain.laplace.activity.identity.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.activity.adapter.LanguageSettingAdapter;
import com.orangechain.laplace.activity.identity.activity.bean.LanguageSettingBean;
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


        LanguageSettingAdapter adapter = new LanguageSettingAdapter(this,R.layout.item_language_setting,listArr);
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
