package com.orangechain.laplace.activity.identity.setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.setting.SystemSettingActivity;
import com.orangechain.laplace.activity.identity.setting.bean.SystemSettingBean;

import java.util.List;

public class SystemSettingAdapter extends ArrayAdapter {

    private int resourceId;

    final private SystemSettingActivity mActivity;

    public SystemSettingAdapter(Context context, int resource, List<SystemSettingBean> objects) {
        super(context, resource, objects);

        this.resourceId = resource;
        this.mActivity = (SystemSettingActivity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //获取数据源
        SystemSettingBean bean = (SystemSettingBean) getItem(position);

        //创建view
        View view;
        viewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_system_setting,parent,false);

            viewHolder = new viewHolder();

            viewHolder.nameTextView = view.findViewById(R.id.system_setting_item_name);
            viewHolder.aSwitch = view.findViewById(R.id.system_setting_item_switch);
            viewHolder.rightButton = view.findViewById(R.id.system_setting_item_action);

            view.setTag(viewHolder);

        } else {

            view = convertView;

            viewHolder = (viewHolder) view.getTag();
        }

        viewHolder.nameTextView.setText(bean.getName());
        viewHolder.rightButton.setText(bean.getRightButtonContent());


        //设置相应的点击事件
        if (position == 1) {
            viewHolder.rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.clickRightButton("language");
                }
            });
        } else if (position == 2) {
            viewHolder.rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.clickRightButton("push");
                }
            });
        }



        if (bean.isShowSwitch()) {
            viewHolder.aSwitch.setVisibility(View.VISIBLE);
            viewHolder.rightButton.setVisibility(View.GONE);
        } else {
            viewHolder.aSwitch.setVisibility(View.GONE);
            viewHolder.rightButton.setVisibility(View.VISIBLE);
        }

        return view;
    }

     class viewHolder {

        TextView nameTextView;

        Switch aSwitch;

        Button rightButton;

     }

}
