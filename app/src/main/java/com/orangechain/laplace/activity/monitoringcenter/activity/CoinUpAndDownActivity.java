package com.orangechain.laplace.activity.monitoringcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinUpAndDownAdapter;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinUpAndDownBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CoinUpAndDownActivity extends BaseActivity {

    private List<CoinUpAndDownBean> list = new ArrayList<>();


    @Override
    public void initWithView() {

        setToolBarText("币价涨跌");


        //设置数据源
        CoinUpAndDownBean bean0 = new CoinUpAndDownBean("ETH","Ethereum",false);
        CoinUpAndDownBean bean1 = new CoinUpAndDownBean("BTC","Bitcoin",false);
        CoinUpAndDownBean bean2 = new CoinUpAndDownBean("EOS","EOS",false);

        list.add(bean0);
        list.add(bean1);
        list.add(bean2);

        ListView listView = findViewById(R.id.coin_up_down_listview);
        CoinUpAndDownAdapter adapter = new CoinUpAndDownAdapter(this,R.layout.item_coin_up_down,list);
        listView.setAdapter(adapter);

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_coin_up_and_down;
    }


    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context,CoinUpAndDownActivity.class);
        startWithNewAnimation(context,intent);
    }
}
