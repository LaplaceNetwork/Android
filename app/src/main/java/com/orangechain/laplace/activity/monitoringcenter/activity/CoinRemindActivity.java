package com.orangechain.laplace.activity.monitoringcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.SizeConvertUtil;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinRemindAdapter;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinRemindBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CoinRemindActivity extends BaseActivity {

    List<CoinRemindBean> list = new ArrayList<>();

    private int viewIDIndex = 1000;

    @Override
    public void initWithView() {

        setToolBarText("币价提醒");

//        //在toolbar上面加一个view 获取toolbar布局
//        RelativeLayout toolBarRelativeLayout = findViewById(R.id.laplace_toolbar_layout);
//
//        TextView mainTextView = findViewById(R.id.txt_main_title);
//        mainTextView.setId(viewIDIndex);
//
//        //创建一个
//        TextView myMindTextView = new TextView(this);
//        myMindTextView.setText("我的提醒");
//        myMindTextView.setTextColor(getResources().getColor(R.color.colorC9C9C9));
//        myMindTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,11);
//        myMindTextView.setGravity(Gravity.CENTER);
//
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT);
////        layoutParams.addRule(RelativeLayout.RIGHT_OF,viewIDIndex);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        layoutParams.setMargins(0,0,150,0); //这边比例的问题 需要考虑
//
//        myMindTextView.setLayoutParams(layoutParams);
//        toolBarRelativeLayout.addView(myMindTextView);





        CoinRemindBean bean0 = new CoinRemindBean("ETH","Ethereum");
        CoinRemindBean bean1 = new CoinRemindBean("ETH","Ethereum");

        list.add(bean0);
        list.add(bean1);


        CoinRemindAdapter adapter = new CoinRemindAdapter(this,R.layout.item_coin_remind,list);
        ListView listView = findViewById(R.id.coin_remind_listview);
        listView.setAdapter(adapter);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_coin_remind;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,CoinRemindActivity.class);
        startWithNewAnimation(context,intent);

    }
}
