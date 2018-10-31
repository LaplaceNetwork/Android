package com.orangechain.laplace.activity.pay;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopeer.cardstack.AllMoveDownAnimatorAdapter;
import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.UpDownAnimatorAdapter;
import com.loopeer.cardstack.UpDownStackAnimatorAdapter;
import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.pay.adapter.PayCardStackAdapter;
import com.orangechain.laplace.activity.pay.bean.PayCardBean;
import com.orangechain.laplace.activity.pay.bean.PayCardDetailBean;
import com.orangechain.laplace.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends BaseFragment implements CardStackView.ItemExpendListener {

    @Override
    public void initWithView(View view) {

        CardStackView cardStackView = view.findViewById(R.id.pay_cardStackView);
        cardStackView.setItemExpendListener(this);
        cardStackView.setAnimatorAdapter(new UpDownAnimatorAdapter(cardStackView));
        PayCardStackAdapter adapter = new PayCardStackAdapter(getActivity());
        cardStackView.setAdapter(adapter);


        //创建数据 String address, String date, String money
        PayCardDetailBean payCardDetailBean0 = new PayCardDetailBean("1111111111...111111","1111:11:11 11:11:11","xxxxxxxxxx LPT");
        PayCardDetailBean payCardDetailBean1 = new PayCardDetailBean("1111111111...111111","1111:11:11 11:11:11","xxxxxxxxxx LPT");
        PayCardDetailBean payCardDetailBean2 = new PayCardDetailBean("1111111111...111111","1111:11:11 11:11:11","xxxxxxxxxx LPT");

        List<PayCardDetailBean> payCardDetailBeanList = new ArrayList<>();
        payCardDetailBeanList.add(payCardDetailBean0);
        payCardDetailBeanList.add(payCardDetailBean1);
        payCardDetailBeanList.add(payCardDetailBean2);

        //int id, String cardName, int color, List<PayCardDetailBean> detailBeans
        PayCardBean payCardBean0 = new PayCardBean(0,"LPT Creditcard",R.color.colorED6363,payCardDetailBeanList);
        PayCardBean payCardBean1 = new PayCardBean(0,"LPT Creditcard",R.color.colorEAD00F,payCardDetailBeanList);
        PayCardBean payCardBean2 = new PayCardBean(0,"LPT Creditcard",R.color.color2C467B,payCardDetailBeanList);
        PayCardBean payCardBean3 = new PayCardBean(0,"LPT Creditcard",R.color.color4A90E2,payCardDetailBeanList);

        List<PayCardBean> payCardBeanList = new ArrayList<>();
        payCardBeanList.add(payCardBean0);
        payCardBeanList.add(payCardBean1);
        payCardBeanList.add(payCardBean2);
        payCardBeanList.add(payCardBean3);
        payCardBeanList.add(payCardBean0);
        payCardBeanList.add(payCardBean1);
        payCardBeanList.add(payCardBean2);
        payCardBeanList.add(payCardBean3);
        payCardBeanList.add(payCardBean0);
        payCardBeanList.add(payCardBean1);
        payCardBeanList.add(payCardBean2);
        payCardBeanList.add(payCardBean3);

        adapter.updateData(payCardBeanList);

    }

    @Override
    public void onItemExpend(boolean expend) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pay;
    }
}
