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
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinRemindBean;

import java.util.List;

public class CoinRemindAdapter extends ArrayAdapter {

    private int mResource;
    private CoinRemindActivity coinRemindActivity;

    public CoinRemindAdapter(Context context, int resource, List<CoinRemindBean> objects) {
        super(context, resource, objects);

        this.mResource = resource;
        this.coinRemindActivity = (CoinRemindActivity) context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CoinRemindBean bean = (CoinRemindBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_coin_remind,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = view.findViewById(R.id.coin_exchange_knockdown_name);
            viewHolder.fullNameTextView = view.findViewById(R.id.coin_exchange_knockdown_des);
            viewHolder.settingView = view.findViewById(R.id.coin_remind_setting);

            view.setTag(viewHolder);
        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.nameTextView.setText(bean.getName());
        viewHolder.fullNameTextView.setText(bean.getFullName());
        viewHolder.settingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入设置界面
                CoinRemindSettingActivity coinRemindSettingActivity = new CoinRemindSettingActivity();
                coinRemindSettingActivity.pushActivity(coinRemindActivity);
            }
        });




        return view;

    }


    class ViewHolder {

        TextView nameTextView;

        TextView fullNameTextView;

        TextView settingView;

    }

}
