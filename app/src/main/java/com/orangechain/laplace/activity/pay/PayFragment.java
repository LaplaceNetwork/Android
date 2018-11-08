package com.orangechain.laplace.activity.pay;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.orangechain.laplace.enumutil.PayCardEnum;
import com.orangechain.laplace.interfac.PayFragmentInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends BaseFragment implements CardStackView.ItemExpendListener, PayFragmentInterface {

    private View superView;
    private boolean isFinished = false;
    CardStackView cardStackView;

    private List<PayCardDetailBean> payCardDetailBeanList;
    private List<PayCardBean> payCardBeanList;
    private PayCardStackAdapter adapter;

    private int processNum = 1;
    CountDownTimer mCountDownTimer;

    @Override
    public void initWithView(View view) {

        superView = view;

        cardStackView = view.findViewById(R.id.pay_cardStackView);
        cardStackView.setItemExpendListener(this);
        cardStackView.setAnimatorAdapter(new UpDownAnimatorAdapter(cardStackView));
        adapter = new PayCardStackAdapter(getActivity());
        cardStackView.setAdapter(adapter);

        //创建数据
        PayCardDetailBean payCardDetailBean0 = new PayCardDetailBean("1111111111...111111", "1111:11:11 11:11:11", "xxxxxxxxxx LPT");
        PayCardDetailBean payCardDetailBean1 = new PayCardDetailBean("1111111111...111111", "1111:11:11 11:11:11", "xxxxxxxxxx LPT");
        PayCardDetailBean payCardDetailBean2 = new PayCardDetailBean("1111111111...111111", "1111:11:11 11:11:11", "xxxxxxxxxx LPT");

        payCardDetailBeanList = new ArrayList<>();
        payCardDetailBeanList.add(payCardDetailBean0);
        payCardDetailBeanList.add(payCardDetailBean1);
        payCardDetailBeanList.add(payCardDetailBean2);

        //int id, String cardName, int color, List<PayCardDetailBean> detailBeans
        PayCardBean payCardBean0 = new PayCardBean(0, "LPT Creditcard", R.color.colorED6363, payCardDetailBeanList,false,false,PayCardEnum.nor);
        PayCardBean payCardBean1 = new PayCardBean(0, "LPT Creditcard", R.color.colorEAD00F, payCardDetailBeanList,false,false,PayCardEnum.nor);
        PayCardBean payCardBean2 = new PayCardBean(0, "LPT Creditcard", R.color.color2C467B, payCardDetailBeanList,false,false,PayCardEnum.nor);
        PayCardBean payCardBean3 = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList,false,false,PayCardEnum.nor);

        payCardBeanList = new ArrayList<>();
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
                //添加卡片
                PayCardBean payCardBeanAdd = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList,true,true,PayCardEnum.con);
                payCardBeanList.add(0,payCardBeanAdd);
                adapter.updateData(payCardBeanList);

                //显示正确的view
                showCardStackViewIndexPage(0);

                //开启计时器 动态模拟签约进度
                mCountDownTimer = new CountDownTimer(8000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        ProgressBar progressBar = superView.findViewById(R.id.pay_cardStackView_card_contract_progressBar);
                        TextView progressText = superView.findViewById(R.id.pay_cardStackView_card_contract_progress_status);
                        TextView progressSignal = superView.findViewById(R.id.pay_cardStackView_card_contract_progress_status_signal);
                        RelativeLayout QRCodeLayout = superView.findViewById(R.id.pay_cardStackView_card_content_qrcode);

                        progressBar.setProgress(processNum);

                        if (processNum == 1) {
                            progressText.setText("正在签约");
                        } else if (processNum == 2) {
                            progressText.setText("签约上链");
                            QRCodeLayout.setVisibility(View.INVISIBLE);
                        } else if (processNum == 3) {
                            progressText.setText("等待区块确认");
                        } else if (processNum == 4) {
                            progressText.setText("授权完成");
                            progressSignal.setText("5s");
                        }

                        processNum += 1;

                    }

                    @Override
                    public void onFinish() {

                    }
                };

                mCountDownTimer.start();
                return;
            case "deleteCard":

                //删除卡片数据源




                return;
            default:
                return;
        }

    }


    /**
     * 设置CardStackView自动跳转的界面
     * @param index
     */
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
    public void onDestroy() {
        super.onDestroy();
        mCountDownTimer.cancel();
    }

    @Override
    public void onItemExpend(boolean expend) {

//        pay_cardStackView_card_layout  pay_cardStackView_card_contract
        if (!expend) {
            RelativeLayout cardLayout = superView.findViewById(R.id.pay_cardStackView_card_layout);
            RelativeLayout cardContract = superView.findViewById(R.id.pay_cardStackView_card_contract);
            RelativeLayout cardContent = superView.findViewById(R.id.pay_cardStackView_card_content_layout);
            cardLayout.setVisibility(View.VISIBLE);
            cardContract.setVisibility(View.INVISIBLE);
            cardContent.setVisibility(View.VISIBLE);
        }






    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pay;
    }
}
