package com.orangechain.laplace.activity.identity.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.setting.adapter.MessageIdAdapter;
import com.orangechain.laplace.activity.identity.setting.bean.MessageIdBean;
import com.orangechain.laplace.activity.identity.setting.bean.messageIdSonBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageIdActivity extends BaseActivity {


    private List<MessageIdBean> listArr = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("ID信息");
        setToolBarTextColor(R.color.colorPrimary);
        setToolBarTextSize(R.dimen.text_size_17);

        //创建数据源
        messageIdSonBean sonBean0 = new messageIdSonBean("测试0","ceshi0");
        messageIdSonBean sonBean1 = new messageIdSonBean("测试0","ceshi0");
        messageIdSonBean sonBean2 = new messageIdSonBean("测试0","ceshi0");
        messageIdSonBean sonBean3 = new messageIdSonBean("测试0","ceshi0");
        messageIdSonBean sonBean4 = new messageIdSonBean("测试0","ceshi0");

        List<messageIdSonBean> list0 = new ArrayList<>();
        list0.add(sonBean0);
        list0.add(sonBean1);
        list0.add(sonBean2);
        list0.add(sonBean3);
        list0.add(sonBean4);

        MessageIdBean messageIdBean0 = new MessageIdBean(true,"测试0",list0);
        MessageIdBean messageIdBean1 = new MessageIdBean(true,"测试1",list0);
        MessageIdBean messageIdBean2 = new MessageIdBean(true,"测试2",list0);

        listArr.add(messageIdBean0);
        listArr.add(messageIdBean1);
        listArr.add(messageIdBean2);

        //创建响应的listview
        MessageIdAdapter adapter = new MessageIdAdapter(MessageIdActivity.this,R.layout.item_meaasge_id_activity,listArr);
        ListView listView = findViewById(R.id.message_id_listview);
        listView.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message_id;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,MessageIdActivity.class);
        startWithNewAnimation(context,intent);

    }
}
