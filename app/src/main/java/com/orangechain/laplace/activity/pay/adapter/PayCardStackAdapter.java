package com.orangechain.laplace.activity.pay.adapter;

import android.content.Context;
import android.support.design.circularreveal.cardview.CircularRevealCardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;
import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.pay.activity.CardMessageActivity;
import com.orangechain.laplace.activity.pay.activity.PayActionActivity;
import com.orangechain.laplace.activity.pay.bean.PayCardBean;

public class PayCardStackAdapter extends StackAdapter<PayCardBean> {

    private Context mContext;

    public PayCardStackAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_cardstackview, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);

        return cardViewHolder;
    }

    @Override
    public void bindView(PayCardBean bean, int position, CardStackView.ViewHolder holder) {

        if (holder instanceof CardViewHolder) {

            CardViewHolder cardViewHolder = (CardViewHolder) holder;
            cardViewHolder.onBind(bean, position);

        }

    }


    class CardViewHolder extends CardStackView.ViewHolder {

        View root;
        RelativeLayout headerLayout;
        TextView headerName;
        RelativeLayout contentLayout;
        ListView contentList;
        Button onlineButton;
        Button laplacePayButton;
        ImageView desImageView;


        public CardViewHolder(View view) {
            super(view);

            root = view;
            headerLayout = view.findViewById(R.id.pay_cardStackView_card_layout);
            headerName = view.findViewById(R.id.pay_cardStackView_card_name);
            contentLayout = view.findViewById(R.id.pay_cardStackView_card_content_layout);
            contentList = view.findViewById(R.id.pay_cardStackView_card_content_trade_history_list);
            onlineButton = view.findViewById(R.id.pay_cardStackView_card_content_trade_online);
            laplacePayButton = view.findViewById(R.id.pay_cardStackView_card_content_trade_laplacepay);
            desImageView = view.findViewById(R.id.pay_cardStackView_card_des);

        }

        public void onBind(PayCardBean bean, int position) {

            headerLayout.setBackgroundColor(mContext.getResources().getColor(bean.getColor()));
            //创建内容list
            PayCardDetailAdapter adapter = new PayCardDetailAdapter(mContext, R.layout.item_pay_detail_cardstackview, bean.getDetailBeans());
            contentList.setAdapter(adapter);

            desImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //进入卡片信息界面
                    CardMessageActivity cardMessageActivity = new CardMessageActivity();
                    cardMessageActivity.pushActivity(mContext);

                }
            });

        }

        @Override
        public void onItemExpand(boolean b) {

            contentLayout.setVisibility(b ? View.VISIBLE : View.GONE);

            if (b) {
                laplacePayButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //进入相应的界面
                        PayActionActivity payActionActivity = new PayActionActivity();
                        payActionActivity.pushActivity(mContext);
                    }
                });

                onlineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //进入相应的界面
                        PayActionActivity payActionActivity = new PayActionActivity();
                        payActionActivity.pushActivity(mContext);
                    }
                });

            }
        }

    }

}
