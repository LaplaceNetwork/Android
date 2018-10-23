package com.orangechain.laplace.activity.currenttime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.currenttime.bean.CurrentTimeListBean;

import java.util.List;

public class CurrentTimeListAdapter extends ArrayAdapter {

    private int mResource;

    public CurrentTimeListAdapter(Context context, int resource, List<CurrentTimeListBean> objects) {
        super(context, resource, objects);

        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CurrentTimeListBean bean = (CurrentTimeListBean)getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_current_time_list_fragment,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.currentTimeTextView = view.findViewById(R.id.item_current_time_list_fragment_time);
            viewHolder.titleTextView = view.findViewById(R.id.item_current_time_list_content_title);
            viewHolder.objectTextView = view.findViewById(R.id.item_current_time_list_content_object_des);
            viewHolder.typeTextView = view.findViewById(R.id.item_current_time_list_content_type_des);
            viewHolder.TimeTextView = view.findViewById(R.id.item_current_time_list_content_time_des);
            viewHolder.moneyTextView = view.findViewById(R.id.item_current_time_list_content_money_des);
            viewHolder.inputAddressTextView = view.findViewById(R.id.item_current_time_list_content_input_address_des);
            viewHolder.outputAddressTextView = view.findViewById(R.id.item_current_time_list_content_output_address_des);
            viewHolder.contenDesTextView = view.findViewById(R.id.item_current_time_list_content_content_des);

            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.currentTimeTextView.setText(bean.getCurrentTime());
        viewHolder.titleTextView.setText(bean.getTitle());
        viewHolder.objectTextView.setText(bean.getObjectText());
        viewHolder.typeTextView.setText(bean.getType());
        viewHolder.TimeTextView.setText(bean.getObjectTime());
        viewHolder.moneyTextView.setText(bean.getMoney());
        viewHolder.inputAddressTextView.setText(bean.getInputAddress());
        viewHolder.outputAddressTextView.setText(bean.getOutputAddress());
        viewHolder.contenDesTextView.setText(bean.getDes());

        //此处需要根据需求 动态显示相关选项

        return view;
    }



    class ViewHolder {

        TextView currentTimeTextView;

        TextView titleTextView;

        TextView objectTextView;

        TextView typeTextView;

        TextView TimeTextView;

        TextView moneyTextView;

        TextView inputAddressTextView;

        TextView outputAddressTextView;

        TextView contenDesTextView;
    }


}
