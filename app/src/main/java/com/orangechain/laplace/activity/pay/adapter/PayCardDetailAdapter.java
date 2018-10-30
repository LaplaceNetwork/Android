package com.orangechain.laplace.activity.pay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.pay.bean.PayCardDetailBean;

import java.util.List;

public class PayCardDetailAdapter extends ArrayAdapter {

    public PayCardDetailAdapter(Context context, int resource, List<PayCardDetailBean> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PayCardDetailBean bean = (PayCardDetailBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_detail_cardstackview,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.addressTextView = view.findViewById(R.id.item_pay_detail_cardstackview_address);
            viewHolder.dateTextView = view.findViewById(R.id.item_pay_detail_cardstackview_date);
            viewHolder.moneyTextView = view.findViewById(R.id.item_pay_detail_cardstackview_money);

            view.setTag(viewHolder);

        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.addressTextView.setText(bean.getAddress());
        viewHolder.dateTextView.setText(bean.getDate());
        viewHolder.moneyTextView.setText(bean.getMoney());

        return view;
    }

    class ViewHolder {

        TextView addressTextView;

        TextView dateTextView;

        TextView moneyTextView;

    }

}
