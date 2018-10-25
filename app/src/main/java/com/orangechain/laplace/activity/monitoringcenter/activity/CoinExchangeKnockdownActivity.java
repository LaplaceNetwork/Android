package com.orangechain.laplace.activity.monitoringcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinExchangeKnockDownAdapter;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinExchangeKnockdownBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CoinExchangeKnockdownActivity extends BaseActivity {

    List<CoinExchangeKnockdownBean> list = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("交易所成交");

        CoinExchangeKnockdownBean bean0 = new CoinExchangeKnockdownBean("ETH","Ethereum","50000USDT",false);
        CoinExchangeKnockdownBean bean1 = new CoinExchangeKnockdownBean("ETH","Ethereum","50000USDT",false);
        CoinExchangeKnockdownBean bean2 = new CoinExchangeKnockdownBean("ETH","Ethereum","50000USDT",false);

        list.add(bean0);
        list.add(bean1);
        list.add(bean2);

        CoinExchangeKnockDownAdapter adapter = new CoinExchangeKnockDownAdapter(this,R.layout.item_coin_exchange_knockdown,list);
        ListView listView = findViewById(R.id.coin_exchange_knockdown_list);
        listView.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_coin_exchange_knockdown;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,CoinExchangeKnockdownActivity.class);
        startWithNewAnimation(context,intent);

    }
}
