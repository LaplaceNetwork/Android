package com.orangechain.laplace.activity.identity.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.activity.bean.MessageIdBean;
import com.orangechain.laplace.activity.identity.activity.bean.messageIdSonBean;

import java.util.List;

public class MessageIdAdapter extends ArrayAdapter {

    private int resourceId;
    private Context mContext;

    public MessageIdAdapter(Context context, int resource, List<MessageIdBean> objects) {
        super(context, resource, objects);

        this.resourceId = resource;
        this.mContext = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final MessageIdBean bean = (MessageIdBean) getItem(position);

        List<messageIdSonBean> array = bean.getListDesArray();

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_meaasge_id_activity,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.messsageIdHeaderNameTextView = view.findViewById(R.id.message_id_item_top_name);
            viewHolder.messageIdImageView = view.findViewById(R.id.message_id_item_top_arrow);

            //获取message_id_item_bottom_layout
            viewHolder.groupRelativeLayout = view.findViewById(R.id.message_id_item_bottom_layout);

            //获取以下小组的内容
            ViewGroup userView = view.findViewById(R.id.message_id_item_bottom_username);
            viewHolder.userNameTextView = userView.findViewById(R.id.message_id_item_name);
            viewHolder.userNameDesTextView = userView.findViewById(R.id.message_id_item_des);

            ViewGroup idView = view.findViewById(R.id.message_id_item_bottom_id);
            viewHolder.idTextView = idView.findViewById(R.id.message_id_item_name);
            viewHolder.idDesTextView = idView.findViewById(R.id.message_id_item_des);

            ViewGroup locationView = view.findViewById(R.id.message_id_item_bottom_location);
            viewHolder.locationTextView = locationView.findViewById(R.id.message_id_item_name);
            viewHolder.locationDesTextView = locationView.findViewById(R.id.message_id_item_des);

            ViewGroup homepageView = view.findViewById(R.id.message_id_item_bottom_homepage);
            viewHolder.homepageTextView = homepageView.findViewById(R.id.message_id_item_name);
            viewHolder.homepageDesTextView = homepageView.findViewById(R.id.message_id_item_des);

            ViewGroup avatarView = view.findViewById(R.id.message_id_item_bottom_avatar);
            viewHolder.avatarTextView = avatarView.findViewById(R.id.message_id_item_name);
            viewHolder.avatarDesTextView = avatarView.findViewById(R.id.message_id_item_des);

            view.setTag(viewHolder);

        } else {

            view = convertView;

            viewHolder = (ViewHolder) view.getTag();

        }

        //设置组头的信息
        viewHolder.messsageIdHeaderNameTextView.setText(bean.getItemName());

        viewHolder.messageIdImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bean.setShow(!bean.isShow());
                notifyDataSetChanged();

            }
        });

        //判断是否显示详细内容
        if (bean.isShow()) {
            viewHolder.groupRelativeLayout.setVisibility(View.VISIBLE);
            viewHolder.messageIdImageView.getDrawable().setLevel(0);
        } else {
            viewHolder.groupRelativeLayout.setVisibility(View.GONE);
            viewHolder.messageIdImageView.getDrawable().setLevel(10000);
        }

        //分组取出数据
        messageIdSonBean bean1 = array.get(0);
        viewHolder.userNameTextView.setText(bean1.getName());
        viewHolder.userNameDesTextView.setText(bean1.getDes());

        bean1 = array.get(1);
        viewHolder.idTextView.setText(bean1.getName());
        viewHolder.idDesTextView.setText(bean1.getDes());

        bean1 = array.get(2);
        viewHolder.locationTextView.setText(bean1.getName());
        viewHolder.locationDesTextView.setText(bean1.getDes());

        bean1 = array.get(3);
        viewHolder.homepageTextView.setText(bean1.getName());
        viewHolder.homepageDesTextView.setText(bean1.getDes());

        bean1 = array.get(4);
        viewHolder.avatarTextView.setText(bean1.getName());
        viewHolder.avatarDesTextView.setText(bean1.getDes());


        return view;
    }

    class ViewHolder {

        TextView messsageIdHeaderNameTextView;

        ImageView messageIdImageView;

        //可以隐藏的部分
        RelativeLayout groupRelativeLayout;

        TextView userNameTextView;

        TextView userNameDesTextView;

        TextView idTextView;

        TextView idDesTextView;

        TextView locationTextView;

        TextView locationDesTextView;

        TextView homepageTextView;

        TextView homepageDesTextView;

        TextView avatarTextView;

        TextView avatarDesTextView;

    }


}
