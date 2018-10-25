package com.orangechain.laplace.activity.monitoringcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinExchangeKnockdownBean;

import java.util.List;

public class CoinExchangeKnockDownAdapter extends ArrayAdapter {

    private int mResource;

    public CoinExchangeKnockDownAdapter(Context context, int resource, List<CoinExchangeKnockdownBean> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CoinExchangeKnockdownBean bean = (CoinExchangeKnockdownBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_coin_exchange_knockdown,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = view.findViewById(R.id.coin_exchange_knockdown_name);
            viewHolder.fullNameTextView = view.findViewById(R.id.coin_exchange_knockdown_des);
            viewHolder.limitTextView = view.findViewById(R.id.coin_exchange_knockdown_limit_count);
            viewHolder.aSwitch = view.findViewById(R.id.coin_exchange_knockdown_swicth);

            view.setTag(viewHolder);
        } else {

            view  = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.nameTextView.setText(bean.getName());
        viewHolder.fullNameTextView.setText(bean.getFullName());
        viewHolder.limitTextView.setText(bean.getLimitCount());
        viewHolder.aSwitch.setChecked(bean.isSwitchStatus());

        return view;
    }


    class ViewHolder {

        TextView nameTextView;

        TextView fullNameTextView;

        TextView limitTextView;

        Switch aSwitch;
    }

}
