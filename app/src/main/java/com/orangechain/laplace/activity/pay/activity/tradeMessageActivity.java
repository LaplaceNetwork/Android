package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.pay.adapter.TradeMessageAdaptar;
import com.orangechain.laplace.activity.pay.bean.TradeMessageBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class tradeMessageActivity extends BaseActivity {

    private List<TradeMessageBean> beanList = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("交易信息");

        TradeMessageBean bean0 = new TradeMessageBean("ceshi","0000000000000000000"
        ,"000000 XXX","11111111111111","0000.00.00 00:00:00");
        TradeMessageBean bean1 = new TradeMessageBean("","0000000000000000000"
                ,"000000 XXX","11111111111111","0000.00.00 00:00:00");

        beanList.add(bean0);
        beanList.add(bean1);

        TradeMessageAdaptar adaptar = new TradeMessageAdaptar(this,R.layout.item_trade_message,beanList);
        ListView listView = findViewById(R.id.trade_message_listview);
        listView.setAdapter(adaptar);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_trade_message;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,tradeMessageActivity.class);
        startWithNewAnimation(context,intent);

    }
}
