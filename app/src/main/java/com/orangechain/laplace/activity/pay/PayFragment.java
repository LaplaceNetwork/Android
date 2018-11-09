package com.orangechain.laplace.activity.pay;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
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

import java.lang.ref.WeakReference;
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
    private CardStackView cardStackView;

    private List<PayCardDetailBean> payCardDetailBeanList;
    private List<PayCardBean> payCardBeanList;
    private PayCardStackAdapter adapter;

    private CardStackView.ViewHolder selectViewHolder;//当前选择的viewholder
    private int selectViewHolderPosition;//选择的位置
    private PayCardEnum cardActionType;//卡片执行动作类型

    private int processNum = 1;

    private static class MyHandler extends Handler {
        private final WeakReference<PayFragment> mFragment;

        private MyHandler(PayFragment fragment) {
            mFragment = new WeakReference<>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {

            IndexActivity activity = (IndexActivity) mFragment.get().getActivity();

            if (activity != null) {

                switch (msg.what) {
                    case 2: {
                        mFragment.get().doTimerAction();
                        this.removeMessages(2);
                        Message message = this.obtainMessage(2);
                        this.sendMessageDelayed(message, 1000);
                    }
                    break;
                    case 3:
                        this.removeMessages(2);
                        break;
                    default:
                        break;
                }

            }

        }
    }

    private final MyHandler mHandler = new MyHandler(this);


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
        PayCardBean payCardBean0 = new PayCardBean(0, "LPT Creditcard", R.color.colorED6363, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean1 = new PayCardBean(0, "LPT Creditcard", R.color.colorEAD00F, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean2 = new PayCardBean(0, "LPT Creditcard", R.color.color2C467B, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean3 = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean4 = new PayCardBean(0, "LPT Creditcard", R.color.colorED6363, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean5 = new PayCardBean(0, "LPT Creditcard", R.color.colorEAD00F, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean6 = new PayCardBean(0, "LPT Creditcard", R.color.color2C467B, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean7 = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean8 = new PayCardBean(0, "LPT Creditcard", R.color.colorED6363, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean9 = new PayCardBean(0, "LPT Creditcard", R.color.colorEAD00F, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean10 = new PayCardBean(0, "LPT Creditcard", R.color.color2C467B, payCardDetailBeanList, false, false, PayCardEnum.nor);
        PayCardBean payCardBean11 = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList, false, false, PayCardEnum.nor);

        payCardBeanList = new ArrayList<>();
        payCardBeanList.add(payCardBean0);
        payCardBeanList.add(payCardBean1);
        payCardBeanList.add(payCardBean2);
        payCardBeanList.add(payCardBean3);

        payCardBeanList.add(payCardBean4);
        payCardBeanList.add(payCardBean5);
        payCardBeanList.add(payCardBean6);
        payCardBeanList.add(payCardBean7);

        payCardBeanList.add(payCardBean8);
        payCardBeanList.add(payCardBean9);
        payCardBeanList.add(payCardBean10);
        payCardBeanList.add(payCardBean11);

        //更新数据
        adapter.updateData(payCardBeanList);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

        selectViewHolderPosition = cardStackView.getSelectPosition();
        //离开的界面的时候 收起列表
        if (cardStackView.isExpending()) {
            cardStackView.clearSelectPosition();
        }

    }

    @Override
    public void finishViewTag(String tag) {

        switch (tag) {

            case "addCard":
                //记录执行动作
                cardActionType = PayCardEnum.con;
                //添加卡片
                PayCardBean payCardBeanAdd = new PayCardBean(0, "LPT Creditcard", R.color.color4A90E2, payCardDetailBeanList, true, true, PayCardEnum.con);
                payCardBeanList.add(0, payCardBeanAdd);
                adapter.updateData(payCardBeanList);

                //显示正确的view 添加的卡片位于第一位
                selectViewHolder = showCardStackViewIndexPage(0,false);

                //开启计时器 模拟进度
                startTimer();

                return;
            case "deleteCard":
                //获取要删除的卡片 修改数据 并且更新状态
                PayCardBean payCardBeanAdd1 = (PayCardBean) payCardBeanList.get(selectViewHolderPosition);
                payCardBeanAdd1.setStatus(PayCardEnum.cac);
                adapter.updateData(payCardBeanList);

                //展开默认选择的卡片
                selectViewHolder = showCardStackViewIndexPage(selectViewHolderPosition,false);
                cardActionType = PayCardEnum.cac;

                //开启计时器 模拟进度
                startTimer();

                return;
            default:
                return;
        }

    }

    /**
     * 设置CardStackView自动跳转的界面
     *
     * @param index
     */
    public CardStackView.ViewHolder showCardStackViewIndexPage(int index,boolean showAnimation) {
        CardStackView.ViewHolder viewHolder = null;
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
            viewHolder = (CardStackView.ViewHolder) getViewHolderMethod.invoke(cardStackView, index);

            if (!showAnimation) {
                Method performItemClickMethod = cls.getDeclaredMethod("performItemClick", CardStackView.ViewHolder.class);
                performItemClickMethod.invoke(cardStackView, viewHolder);
            } else {
                //doCardClickAnimation
                Method doCardClickAnimationMethod = cls.getDeclaredMethod("doCardClickAnimation", CardStackView.ViewHolder.class);
                doCardClickAnimationMethod.invoke(cardStackView,viewHolder,index);
            }

        } catch (Exception e) {
            e.printStackTrace();
//            Throwable cause = e.getCause();
//            System.out.println(cause.toString()+ "ceshi");
        } finally {
            return viewHolder;
        }
    }

    /**
     * 确保CardStackViewStatus处于非签约状态
     */
    public void turnOffContractStatus() {

//        RelativeLayout cardLayout = superView.findViewById(R.id.pay_cardStackView_card_layout);//头部一组
//        RelativeLayout cardLayoutContract = superView.findViewById(R.id.pay_cardStackView_card_contract);//头部二组
//        RelativeLayout cardContent = superView.findViewById(R.id.pay_cardStackView_card_content_layout);//底部一组
//        RelativeLayout cardContentContract = superView.findViewById(R.id.pay_cardStackView_card_content_qrcode);//底部二组
//        cardLayout.setVisibility(View.VISIBLE);
//        cardContent.setVisibility(cardLayout.getVisibility());
//        cardLayoutContract.setVisibility(View.INVISIBLE);
//        cardContentContract.setVisibility(cardLayoutContract.getVisibility());

        //修改数据源中的数据 并且刷新界面
        PayCardBean payCardBeanAdd = payCardBeanList.get(0);
        payCardBeanAdd.setStatus(PayCardEnum.nor);
        adapter.updateData(payCardBeanList);

    }

    /*******************计时器三件套********************/
    public void startTimer() {

        Message message = mHandler.obtainMessage(2);
        mHandler.sendMessage(message);

    }

    public void stopTimer() {

        Message message = mHandler.obtainMessage(3);
        mHandler.sendMessage(message);

    }

    /**
     * 执行计时器事件
     */
    public void doTimerAction() {
//        ViewGroup selectView = (ViewGroup) selectViewHolder;
        ProgressBar progressBar = selectViewHolder.itemView.findViewById(R.id.pay_cardStackView_card_contract_progressBar);
        TextView progressText = selectViewHolder.itemView.findViewById(R.id.pay_cardStackView_card_contract_progress_status);
        TextView progressSignal = selectViewHolder.itemView.findViewById(R.id.pay_cardStackView_card_contract_progress_status_signal);
        RelativeLayout QRCodeLayout = selectViewHolder.itemView.findViewById(R.id.pay_cardStackView_card_content_qrcode);



            if (cardActionType == PayCardEnum.con) {
                progressText.setText("正在签约");
                if (processNum >= 2) {
                    progressBar.setProgress(processNum - 1);

                    if (processNum == 2) {
                        progressText.setText("正在签约");
                    } else if (processNum == 3) {
                        progressText.setText("签约上链");
                        QRCodeLayout.setVisibility(View.INVISIBLE);
                    } else if (processNum == 4) {
                        progressText.setText("等待区块确认");
                    } else if (processNum == 5) {
                        progressText.setText("授权完成");
                        progressSignal.setText("5s");
                    } else {

                        if (cardStackView.isExpending()) {
                            //恢复列表状态
                            cardStackView.performItemClick(selectViewHolder);
                        }

                        stopTimer();
                        processNum = 1;
                    }
                }

            } else if (cardActionType == PayCardEnum.cac) {

                Log.i("eeeee","eeeee");
                progressText.setText("区块确认中");
                if (processNum >= 2) {
                    progressBar.setProgress(processNum - 1);

                    if (processNum == 2) {
                        progressText.setText("区块确认中");
                    } else if (processNum == 3) {
                        progressText.setText("正在解约");
                    } else if (processNum == 4) {
                        progressText.setText("正在解约");
                    } else if (processNum == 5) {
                        progressText.setText("解约完成");
                        progressSignal.setText("5s");
                    } else if (processNum == 6) {

                        if (cardStackView.isExpending()) {
                            //恢复列表状态
                            cardStackView.performItemClick(selectViewHolder);
                        }

                    } else {

                        //删除此卡片 并 更新
                        payCardBeanList.remove(selectViewHolderPosition);
                        adapter.updateData(payCardBeanList);

                        stopTimer();
                        processNum = 1;
                    }
                }
            }

        processNum += 1;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemExpend(boolean expend) {

        if (!expend & cardActionType != PayCardEnum.cac) {
            turnOffContractStatus();
        }

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pay;
    }
}
