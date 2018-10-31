package com.orangechain.laplace.activity.pay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.pay.bean.PayCardTypeBean;

import java.util.List;

public class PayCardTypeAdapter extends ArrayAdapter {

    public PayCardTypeAdapter(Context context, int resource, List<PayCardTypeBean> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PayCardTypeBean bean = (PayCardTypeBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_card_type,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = view.findViewById(R.id.item_pay_card_type_name);
            viewHolder.selectButton = view.findViewById(R.id.item_pay_card_type_checkbox);

            view.setTag(viewHolder);

        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.nameTextView.setText(bean.getCardName());
        viewHolder.selectButton.setChecked(bean.isSelectStatus());

        return view;
    }

    class ViewHolder {

        TextView nameTextView;

        CheckBox selectButton;

    }

}
