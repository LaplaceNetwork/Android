package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.pay.adapter.OperatarSelectAdapter;
import com.orangechain.laplace.activity.pay.bean.OperatarSelectBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PayOperatarSelectActivity extends BaseActivity {

    private List<OperatarSelectBean> beanList = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("运营商选择");

        OperatarSelectBean bean0 = new OperatarSelectBean("运营商1","运营商介绍",false);
        OperatarSelectBean bean1 = new OperatarSelectBean("运营商2","运营商介绍",false);
        beanList.add(bean0);
        beanList.add(bean1);


        ListView listView = findViewById(R.id.operatar_select_list);
        OperatarSelectAdapter operatarSelectAdapter = new OperatarSelectAdapter(this,R.layout.item_operatar_select,beanList);
        listView.setAdapter(operatarSelectAdapter);


        Button button = findViewById(R.id.operatar_select_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PayCardTypeActivity payCardTypeActivity = new PayCardTypeActivity();
                payCardTypeActivity.pushActivity(PayOperatarSelectActivity.this);

            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_operatar_select;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,PayOperatarSelectActivity.class);
        startWithNewAnimation(context,intent);

    }
}
