package com.orangechain.laplace.activity.identity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.IdentityFragment;
import com.orangechain.laplace.activity.identity.bean.IdentityFragmentBean;

import java.util.List;

public class IdetityFragmentAdapter extends ArrayAdapter {


    private int resourceId;

    public IdetityFragmentAdapter(Context context, int resource, List<IdentityFragmentBean> objects) {

        super(context, resource, objects);

        this.resourceId = resource;//记录ID

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //获取view
        IdentityFragmentBean identityFragmentBean = (IdentityFragmentBean)getItem(position);

        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView image = view.findViewById(R.id.identity_item_image_imageview);
        TextView name = view.findViewById(R.id.identity_item_name_textview);
        TextView timeliness = view.findViewById(R.id.identity_item_timeliness_textview);
        TextView time = view.findViewById(R.id.identity_item_time_textview);

        name.setText("测试");
        timeliness.setText("生效中");
        time.setText("有效期:永久");

        return view;
    }



}
