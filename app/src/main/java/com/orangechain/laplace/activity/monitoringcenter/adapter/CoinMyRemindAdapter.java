package com.orangechain.laplace.activity.monitoringcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.activity.CoinRemindActivity;
import com.orangechain.laplace.activity.monitoringcenter.activity.CoinRemindSettingActivity;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinMyRemindBean;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinRemindBean;

import java.util.List;

public class CoinMyRemindAdapter extends ArrayAdapter {

    private int mResource;

    public CoinMyRemindAdapter(Context context, int resource, List<CoinMyRemindBean> objects) {
        super(context, resource, objects);

        this.mResource = resource;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CoinMyRemindBean bean = (CoinMyRemindBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_coin_remind_myself,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.exchangeCoupleTextView = view.findViewById(R.id.item_coin_remind_myself_exchangecouple);
            viewHolder.exchangeTextView = view.findViewById(R.id.item_coin_remind_myself_exchange);
            viewHolder.highTextView = view.findViewById(R.id.item_coin_remind_myself_high);
            viewHolder.lowTextView = view.findViewById(R.id.item_coin_remind_myself_low);
            viewHolder.delete = view.findViewById(R.id.item_coin_remind_myself_delete);

            view.setTag(viewHolder);
        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.exchangeCoupleTextView.setText(bean.getExchangeCouple());
        viewHolder.exchangeTextView.setText(bean.getExchange());
        viewHolder.highTextView.setText(bean.getHigh());
        viewHolder.lowTextView.setText(bean.getLow());
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //删除一组数据 主要通过修改数据源 进行设置

            }
        });

        return view;

    }


    class ViewHolder {

        TextView exchangeCoupleTextView;

        TextView exchangeTextView;

        TextView highTextView;

        TextView lowTextView;

        TextView delete;

    }

}
