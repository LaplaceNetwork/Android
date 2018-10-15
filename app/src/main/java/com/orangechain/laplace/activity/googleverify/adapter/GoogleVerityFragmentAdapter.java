package com.orangechain.laplace.activity.googleverify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.ToolHelper;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.googleverify.bean.GoogleVerityFragmentBean;

import java.util.List;

public class GoogleVerityFragmentAdapter extends ArrayAdapter {

    private int resourceId;

    private Context SuperContext;

    public GoogleVerityFragmentAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.resourceId = resource;
        this.SuperContext = context;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        //获取数据bean
        GoogleVerityFragmentBean bean = (GoogleVerityFragmentBean)getItem(position);

        View view;
        viewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            viewHolder = new viewHolder();
            viewHolder.numberCodeTextView = view.findViewById(R.id.google_verification_numberCode);
            viewHolder.objectNameTextView = view.findViewById(R.id.google_verification_objectstatus);
            viewHolder.imageStatusImage = view.findViewById(R.id.google_verification_status_image);

            view.setTag(viewHolder);


        } else {

            view = convertView;

            viewHolder = (viewHolder) view.getTag();

        }

        viewHolder.numberCodeTextView.setText(bean.getNumberCode());
        viewHolder.objectNameTextView.setText(bean.getObjectName());

        if (bean.getImageStatus() == "0") {
            //显示红色
            viewHolder.numberCodeTextView.setTextColor(SuperContext.getResources().getColor(R.color.colorED6363));

            //修改图片的填充颜色
//            IndexActivity activity = (IndexActivity) SuperContext;
//            activity.getSupportActionBar().setHomeAsUpIndicator(ToolHelper.changePictureColor(activity,R.color.colorED6363,R.drawable.baseline_timelapse_black_24dp));

        } else {
            //显示原色
            viewHolder.numberCodeTextView.setTextColor(SuperContext.getResources().getColor(R.color.color2087FF));

        }

        return view;
    }

    class viewHolder {

        TextView numberCodeTextView;

        TextView objectNameTextView;

        ImageView imageStatusImage;

    }

}
