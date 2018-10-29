package com.orangechain.laplace.activity.monitoringcenter.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.basehelper.MyApplication;

public class CoinRemindPageTransformer implements PageTransformer {


    private static final float MAX_ROTATION=20.0f;
    private static final float MIN_SCALE=0.75f;
    private static final float MAX_TRANSLATE=20.0f;

    @Override
    public void transformPage(@NonNull View view, float position) {


        if (position < -1.0f) {

            TextView textView = (TextView) view;
            textView.setTextColor(MyApplication.getContext().getResources().getColor(R.color.colorC9C9C9));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 11);

        } else if (position <= 0.0f) {

            TextView textView = (TextView) view;
            textView.setTextColor(MyApplication.getContext().getResources().getColor(R.color.colorC9C9C9));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 11 );

        } else if (position <= 1.0f) {

            TextView textView = (TextView) view;
            textView.setTextColor(MyApplication.getContext().getResources().getColor(R.color.color333333));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);

        } else {

            TextView textView = (TextView) view;
            textView.setTextColor(MyApplication.getContext().getResources().getColor(R.color.colorC9C9C9));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 11);

        }

    }
}
