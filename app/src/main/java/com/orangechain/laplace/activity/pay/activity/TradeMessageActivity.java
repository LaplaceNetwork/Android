package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.pay.adapter.TradeMessageAdaptar;
import com.orangechain.laplace.activity.pay.bean.TradeMessageBean;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.base.BaseActivityCollector;
import com.orangechain.laplace.enumutil.BackStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class TradeMessageActivity extends BaseActivity {

    private static BackStatusEnum backEnum;//记录返回动作

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

        Intent intent = getLaunchIntent(context,TradeMessageActivity.class);
        startWithNewAnimation(context,intent);

    }

    /**
     * 类别跳转 根据跳转来的类做相应的回应
     * @param context
     * @param tagClass
     */
    public void pushActivity(Context context,Class tagClass) {

        if (tagClass == PayActionActivity.class) {
            //返回的时候直接返回到首页
            backEnum = BackStatusEnum.gohome;
        }
        Intent intent = getLaunchIntent(context,TradeMessageActivity.class);
        startWithNewAnimation(context,intent);

    }

    @Override
    public void leftAction() {
        if (backEnum == BackStatusEnum.gohome) {
            BaseActivityCollector.finishAndGoBackHistoryActivity(IndexActivity.class);
        } else {
            super.leftAction();
        }
    }
}
