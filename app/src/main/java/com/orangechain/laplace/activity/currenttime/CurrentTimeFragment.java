package com.orangechain.laplace.activity.currenttime;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.currenttime.adapter.CurrentTimeListAdapter;
import com.orangechain.laplace.activity.currenttime.bean.CurrentTimeListBean;
import com.orangechain.laplace.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentTimeFragment extends BaseFragment {

    private List<CurrentTimeListBean> listBeans = new ArrayList<>();
    private View mView;
    private CurrentTimeListAdapter adapter;

    @Override
    public void initWithView(View view) {

        this.mView = view;

        //创建数据
        CurrentTimeListBean bean0 = new CurrentTimeListBean("11:11","代币异动提醒","ETH","链上大额转账提醒",
                "2018.11.11 11:11:11","8000个ETH","0x8kneut……9ejcny","0x8kneut……9ejcny（交易所地址）",
                "ETH 5分钟内上涨2.29%，下跌金额为90.09美元，火币现价为308.19美元，请密切关注市场价格波动，注意控制风险",true,"red");
        CurrentTimeListBean bean1 = new CurrentTimeListBean("11:11","代币异动提醒","ETH","链上大额转账提醒",
                "2018.11.11 11:11:11","8000个ETH","0x8kneut……9ejcny","0x8kneut……9ejcny（交易所地址）",
                "ETH 5分钟内上涨2.29%，下跌金额为90.09美元，火币现价为308.19美元，请密切关注市场价格波动，注意控制风险",true,"red");
        CurrentTimeListBean bean2 = new CurrentTimeListBean("11:11","代币异动提醒","ETH","链上大额转账提醒",
                "2018.11.11 11:11:11","8000个ETH","0x8kneut……9ejcny","0x8kneut……9ejcny（交易所地址）",
                "ETH 5分钟内上涨2.29%，下跌金额为90.09美元，火币现价为308.19美元，请密切关注市场价格波动，注意控制风险",true,"red");
        CurrentTimeListBean bean3 = new CurrentTimeListBean("11:11","代币异动提醒","ETH","链上大额转账提醒",
                "2018.11.11 11:11:11","8000个ETH","0x8kneut……9ejcny","0x8kneut……9ejcny（交易所地址）",
                "ETH 5分钟内上涨2.29%，下跌金额为90.09美元，火币现价为308.19美元，请密切关注市场价格波动，注意控制风险",true,"red");
        CurrentTimeListBean bean4 = new CurrentTimeListBean("11:11","代币异动提醒","ETH","链上大额转账提醒",
                "2018.11.11 11:11:11","8000个ETH","0x8kneut……9ejcny","0x8kneut……9ejcny（交易所地址）",
                "ETH 5分钟内上涨2.29%，下跌金额为90.09美元，火币现价为308.19美元，请密切关注市场价格波动，注意控制风险",true,"red");
        CurrentTimeListBean bean5 = new CurrentTimeListBean("11:11","代币异动提醒","ETH","链上大额转账提醒",
                "2018.11.11 11:11:11","8000个ETH","0x8kneut……9ejcny","0x8kneut……9ejcny（交易所地址）",
                "ETH 5分钟内上涨2.29%，下跌金额为90.09美元，火币现价为308.19美元，请密切关注市场价格波动，注意控制风险",true,"red");

        listBeans.add(bean0);
        listBeans.add(bean1);
        listBeans.add(bean2);
        listBeans.add(bean3);
        listBeans.add(bean4);
        listBeans.add(bean5);

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_current_time;
    }

    /**
     * 显示列表
     */
     public void showTimeListView() {

         ListView listView = mView.findViewById(R.id.input_current_time_list);

         if (adapter == null) {
             adapter = new CurrentTimeListAdapter(getActivity(), R.layout.item_current_time_list_fragment, listBeans);
         }

         if (listView != null) {
             listView.setAdapter(adapter);
         }

     }



}
