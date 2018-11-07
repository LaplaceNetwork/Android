package com.orangechain.laplace.activity.pay;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
import com.orangechain.laplace.interfac.PayFragmentInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends BaseFragment implements CardStackView.ItemExpendListener, PayFragmentInterface {

    private View superView;
    private boolean isFinished = false;
    CardStackView cardStackView;

    @Override
    public void initWithView(View view) {

        superView = view;

        cardStackView = view.findViewById(R.id.pay_cardStackView);
        cardStackView.setItemExpendListener(this);
        cardStackView.setAnimatorAdapter(new UpDownAnimatorAdapter(cardStackView));
        PayCardStackAdapter adapter = new PayCardStackAdapter(getActivity());
        cardStackView.setAdapter(adapter);

        //创建数据
        PayCardDetailBean payCardDetailBean0 = new PayCardDetailBean("1111111111...111111", "1111:11:11 11:11:11", "xxxxxxxxxx LPT");
        PayCardDetailBean payCardDetailBean1 = new PayCardDetailBean("1111111111...111111", "1111:11:11 11:11:11", "xxxxxxxxxx LPT");
        PayCardDetailBean payCardDetailBean2 = new PayCardDetailBean("1111111111...111111", "1111:11:11 11:11:11", "xxxxxxxxxx LPT");

        List<PayCardDetailBean> payCardDetailBeanList = new ArrayList<>();
        payCardDetailBeanList.add(payCardDetailBean0);
        payCardDetailBeanList.add(payCardDetailBean1);
        payCardDetailBeanList.add(payCardDetailBean2);

        //int id, String cardName, int color, List<PayCardDetailBean> detailBeans
        PayCardBean payCardBean0 = new PayCardBean(0, "LPT Creditcard", R.color.colorED6363, payCardDetailBeanList);
        PayCardBean payCardBean1 = new PayCardBean(0, "LPT Creditcard", R.color.colorEAD00F, payCardDetailBeanList);
        PayCardBean payCardBean2 = new PayCardBean(0, "LPT Creditcard", R.color.color2C467B, payCardDetailBeanList);
        PayCardBean payCardBean3 = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList);

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

        //更新数据
        adapter.updateData(payCardBeanList);

    }

    @Override
    public void onResume() {
        super.onResume();

        if (isFinished) {
//            showCardStackViewIndexPage(0);
        }

    }

    @Override
    public void onPause() {
        super.onPause();

        isFinished = true;

    }

    @Override
    public void finishViewTag(String tag) {

        switch (tag) {

            case "addCard":
                showCardStackViewIndexPage(0);
                return;
            case "deleteCard":


                return;
            default:
                return;
        }

    }

    public void showCardStackViewIndexPage(int index) {

        try {
            Class<?> cls = cardStackView.getClass();
            Constructor constructor = cls.getConstructor(Context.class);
            Object object = constructor.newInstance(getActivity());

            //获取内部元素
//            Field field = cls.getDeclaredField("mViewHolders");
//            field.setAccessible(true);
//            List<CardStackView.ViewHolder> viewHolderList = (List<CardStackView.ViewHolder>)field.get(cardStackView);

            //获取 getViewHolder 方法
            Method getViewHolderMethod = cls.getDeclaredMethod("getViewHolder", int.class);
            getViewHolderMethod.setAccessible(true);
            CardStackView.ViewHolder viewHolder = (CardStackView.ViewHolder) getViewHolderMethod.invoke(cardStackView, index);


            Method performItemClickMethod = cls.getDeclaredMethod("performItemClick", CardStackView.ViewHolder.class);
            performItemClickMethod.invoke(cardStackView, viewHolder);


        } catch (Exception e) {
            e.printStackTrace();
//            Throwable cause = e.getCause();
//            System.out.println(cause.toString()+ "ceshi");
        }

    }

    @Override
    public void onItemExpend(boolean expend) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pay;
    }
}
