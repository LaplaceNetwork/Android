package com.orangechain.laplace.activity.monitoringcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.SizeConvertUtil;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinRemindAdapter;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinRemindPageTransformer;
import com.orangechain.laplace.activity.monitoringcenter.adapter.CoinRemindPagerAdapter;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinRemindBean;
import com.orangechain.laplace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CoinRemindActivity extends BaseActivity {

    List<CoinRemindBean> list = new ArrayList<>();

//    private int viewIDIndex = 1000;

    @Override
    public void initWithView() {

        setToolBarText("");

        //在toolbar上面加一个view 获取toolbar布局  color333333  colorC9C9C9
        RelativeLayout toolBarRelativeLayout = findViewById(R.id.laplace_toolbar_layout);

        //讲viewpager 添加到界面上
        ViewGroup baseViewGroup =(ViewGroup) getLayoutInflater().inflate(R.layout.input_coin_remind_toolbar_customview,toolBarRelativeLayout);

        //获取viewpager
        final ViewPager viewPager = baseViewGroup.findViewById(R.id.coin_remind_custom_toolbar);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(80, 0, 80, 0);

        //创建一个textView
        TextView myMindTextView = new TextView(this);
        myMindTextView.setText("币价提醒");
        myMindTextView.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        myMindTextView.setLayoutParams(layoutParams);
        myMindTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //滚到第一页
                viewPager.setCurrentItem(0);
            }
        });

        //创建一个textView
        TextView myMindTextView1 = new TextView(this);
        myMindTextView1.setText("我的提醒");
        myMindTextView1.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        myMindTextView.setLayoutParams(layoutParams1);
        myMindTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });


        List<View> listViews = new ArrayList<>();
        listViews.add(myMindTextView);
        listViews.add(myMindTextView1);

        CoinRemindPagerAdapter pagerAdapter = new CoinRemindPagerAdapter(listViews);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true,new CoinRemindPageTransformer());














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
