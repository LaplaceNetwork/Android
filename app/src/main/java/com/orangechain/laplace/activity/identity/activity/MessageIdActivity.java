package com.orangechain.laplace.activity.identity.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.activity.adapter.MessageIdAdapter;
import com.orangechain.laplace.activity.identity.activity.bean.MessageIdBean;
import com.orangechain.laplace.activity.identity.activity.bean.messageIdSonBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageIdActivity extends BaseActivity {


    private List<MessageIdBean> listArr = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("ID信息");
        setToolBarTextColor(R.color.color022656);
        setToolBarTextSize(R.dimen.text_size_17);

        //创建数据源
        messageIdSonBean sonBean0 = new messageIdSonBean("Username","iyouus");
        messageIdSonBean sonBean1 = new messageIdSonBean("ID","198374058797897379746");
        messageIdSonBean sonBean2 = new messageIdSonBean("Location","China");
        messageIdSonBean sonBean3 = new messageIdSonBean("Homepage","Http://e8game.net/friends-vision.siejt.html");
        messageIdSonBean sonBean4 = new messageIdSonBean("Avatar","Http://e8game.net/friends-vision.siejt.html");

        List<messageIdSonBean> list0 = new ArrayList<>();
        list0.add(sonBean0);
        list0.add(sonBean1);
        list0.add(sonBean2);
        list0.add(sonBean3);
        list0.add(sonBean4);

        MessageIdBean messageIdBean0 = new MessageIdBean(false,"E8game",list0);
        MessageIdBean messageIdBean1 = new MessageIdBean(false,"Opensea",list0);
        MessageIdBean messageIdBean2 = new MessageIdBean(false,"Telegram",list0);
        MessageIdBean messageIdBean3 = new MessageIdBean(false,"Twitter",list0);

        listArr.add(messageIdBean0);
        listArr.add(messageIdBean1);
        listArr.add(messageIdBean2);
        listArr.add(messageIdBean3);

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
