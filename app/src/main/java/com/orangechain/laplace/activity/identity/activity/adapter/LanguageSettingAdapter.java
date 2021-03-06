package com.orangechain.laplace.activity.identity.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.activity.bean.LanguageSettingBean;

import java.util.List;

public class LanguageSettingAdapter extends ArrayAdapter {

    private int resourceId;

    public LanguageSettingAdapter(Context context, int resource, List<LanguageSettingBean> objects) {

        super(context, resource, objects);

        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LanguageSettingBean bean = (LanguageSettingBean) getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_language_setting,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = view.findViewById(R.id.language_setting_item_name);
            viewHolder.checkedButton = view.findViewById(R.id.language_setting_item_check);

            view.setTag(viewHolder);

        } else {

            view = convertView;

            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.nameTextView.setText(bean.getName());
        viewHolder.checkedButton.setChecked(bean.isChecked());

        return view;
    }

    class ViewHolder {

        TextView nameTextView;

        CheckBox checkedButton;

    }

}
