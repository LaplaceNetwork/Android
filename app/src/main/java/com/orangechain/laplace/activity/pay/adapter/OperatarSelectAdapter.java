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
import com.orangechain.laplace.activity.pay.bean.OperatarSelectBean;

import java.util.List;

public class OperatarSelectAdapter extends ArrayAdapter {

    public OperatarSelectAdapter(Context context, int resource, List<OperatarSelectBean> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        OperatarSelectBean bean = (OperatarSelectBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_operatar_select,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.operatarTextView = view.findViewById(R.id.item_operatar_select_name);
            viewHolder.operatarDetailTextView = view.findViewById(R.id.item_operatar_select_detail);
            viewHolder.selectButton = view.findViewById(R.id.item_operatar_select_checkbox);

            view.setTag(viewHolder);

        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.operatarTextView.setText(bean.getOperatar());
        viewHolder.operatarDetailTextView.setText(bean.getOperatarDetail());
        viewHolder.selectButton.setChecked(bean.isSelectStatus());

        return view;

    }

    class ViewHolder {

        TextView operatarTextView;

        TextView operatarDetailTextView;

        CheckBox selectButton;

    }

}
