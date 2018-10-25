package com.orangechain.laplace.activity.monitoringcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinUnusualAdapter;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinUnusualBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CoinUnusualActivity extends BaseActivity {

    private List<CoinUnusualBean> list = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("币价异动");

        //创建数据源
        CoinUnusualBean bean0 = new CoinUnusualBean("ETH","Ethereum","5000个",
        "5000个","5000个",false,"number");
        CoinUnusualBean bean1 = new CoinUnusualBean("ETH","Ethereum","5000个",
                "5000个","5000个",false,"number");
        CoinUnusualBean bean2 = new CoinUnusualBean("ETH","Ethereum","5000个",
                "5000个","5000个",false,"number");
        CoinUnusualBean bean3 = new CoinUnusualBean("MFT","Mainframe","0.1%",
                "0.1%","0.1%",false,"proportion");

        list.add(bean0);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        ListView listView = findViewById(R.id.coin_unusual_list);
        CoinUnusualAdapter adapter = new CoinUnusualAdapter(this,R.layout.item_coin_unusual_list_activity,list);
        listView.setAdapter(adapter);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_coin_unusual;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,CoinUnusualActivity.class);
        startWithNewAnimation(context,intent);

    }
}
