package com.orangechain.laplace.activity.pay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.pay.bean.TradeMessageBean;

import java.util.List;

public class TradeMessageAdaptar extends ArrayAdapter {

    public TradeMessageAdaptar(Context context, int resource, List<TradeMessageBean> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TradeMessageBean bean = (TradeMessageBean)getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trade_message,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.statusImageView = view.findViewById(R.id.item_trade_message_imageview);
            viewHolder.addressStartTextView = view.findViewById(R.id.item_trade_message_address_start);
            viewHolder.addressStartMoneyTextView = view.findViewById(R.id.item_trade_message_address_start_money);
            viewHolder.dateTextView = view.findViewById(R.id.item_trade_message_time);
            viewHolder.addressEndTextView = view.findViewById(R.id.item_trade_message_address_end);
            viewHolder.statusTextView = view.findViewById(R.id.item_trade_message_status);

            view.setTag(viewHolder);

        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (bean.getTradesStatus() == "ceshi") {
            //修改图片

            //修改状态
            viewHolder.statusTextView.setText("测试");

        } else {

            viewHolder.statusTextView.setText("");

        }

        viewHolder.addressStartTextView.setText(bean.getAddressStart());
        viewHolder.addressStartMoneyTextView.setText(bean.getAddressStartMoney());
        viewHolder.dateTextView.setText(bean.getTradeDate());
        viewHolder.addressEndTextView.setText(bean.getAddressEnd());

        return view;
    }


    class ViewHolder {

        ImageView statusImageView;

        TextView addressStartTextView;

        TextView addressStartMoneyTextView;

        TextView dateTextView;

        TextView addressEndTextView;

        TextView statusTextView;
    }

}
