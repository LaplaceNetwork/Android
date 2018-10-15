package com.orangechain.laplace.activity.identity.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.IdentityFragment;
import com.orangechain.laplace.activity.identity.bean.IdentityFragmentBean;

import java.util.List;

public class IdetityFragmentAdapter extends ArrayAdapter {

    public Fragment superFragment;

    private int resourceId;

    public IdetityFragmentAdapter(Context context, int resource, List<IdentityFragmentBean> objects) {

        super(context, resource, objects);

        this.resourceId = resource;//记录ID

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //获取
        IdentityFragmentBean identityFragmentBean = (IdentityFragmentBean)getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.image = view.findViewById(R.id.identity_item_image_imageview);
            viewHolder.name = view.findViewById(R.id.identity_item_name_textview);
            viewHolder.time = view.findViewById(R.id.identity_item_time_textview);
            viewHolder.timeliness = view.findViewById(R.id.identity_item_timeliness_textview);

            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.name.setText(identityFragmentBean.getName());
        viewHolder.timeliness.setText(identityFragmentBean.getTimeliness());
        viewHolder.time.setText(identityFragmentBean.getDate());

        Glide.with(superFragment).load(identityFragmentBean.getImgUrl()).into(viewHolder.image);

        return view;
    }

    class ViewHolder {

        ImageView image;

        TextView name;

        TextView timeliness;

        TextView time;

    }




}
