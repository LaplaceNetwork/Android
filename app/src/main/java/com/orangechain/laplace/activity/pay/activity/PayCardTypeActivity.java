package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.pay.adapter.PayCardTypeAdapter;
import com.orangechain.laplace.activity.pay.bean.PayCardTypeBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PayCardTypeActivity extends BaseActivity {

    private List<PayCardTypeBean> beanList = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("卡片类型");

        PayCardTypeBean bean0 = new PayCardTypeBean("BTC",false);
        PayCardTypeBean bean1 = new PayCardTypeBean("ETH",false);
        PayCardTypeBean bean2 = new PayCardTypeBean("EOS",false);

        beanList.add(bean0);
        beanList.add(bean1);
        beanList.add(bean2);

        ListView listView = findViewById(R.id.pay_card_type_listview);
        PayCardTypeAdapter adapter = new PayCardTypeAdapter(this,R.layout.item_pay_card_type,beanList);
        listView.setAdapter(adapter);

        Button button = findViewById(R.id.pay_card_type_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PayCardAuthActivity payCardAuthActivity = new PayCardAuthActivity();
                payCardAuthActivity.pushActivity(PayCardTypeActivity.this);

            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_card_type;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,PayCardTypeActivity.class);
        startWithNewAnimation(context,intent);
    }
}
