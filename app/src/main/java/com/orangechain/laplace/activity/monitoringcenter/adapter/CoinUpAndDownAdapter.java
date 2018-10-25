package com.orangechain.laplace.activity.monitoringcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinUpAndDownBean;

import java.util.List;

public class CoinUpAndDownAdapter extends ArrayAdapter {

    private int mResource;

    public CoinUpAndDownAdapter(Context context, int resource, List<CoinUpAndDownBean> objects) {
        super(context, resource, objects);
        this.mResource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        CoinUpAndDownBean bean = (CoinUpAndDownBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_coin_up_down,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = view.findViewById(R.id.coin_up_and_down_name_textview);
            viewHolder.fullTextView = view.findViewById(R.id.coin_up_and_down_fullname_textview);
            viewHolder.aSwitch = view.findViewById(R.id.coin_up_and_down_switch);

            view.setTag(viewHolder);

        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.nameTextView.setText(bean.getName());
        viewHolder.fullTextView.setText(bean.getFullName());
        viewHolder.aSwitch.setChecked(bean.isSwitchStatus());

        return view;
    }


    class ViewHolder {

        TextView nameTextView;

        TextView fullTextView;

        Switch aSwitch;

    }


}
