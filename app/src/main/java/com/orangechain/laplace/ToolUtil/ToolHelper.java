package com.orangechain.laplace.ToolUtil;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;

public class ToolHelper {

    /**
     * 修改图片的主体颜色
     */
    public static Drawable changePictureColor(Context context,int color,int drawableId) {

        //修改图片的填充颜色
        Drawable imageViewDraw = ContextCompat.getDrawable(context, drawableId);
        imageViewDraw.setColorFilter(context.getResources().getColor(R.color.colorGray), PorterDuff.Mode.SRC_ATOP);

        return  imageViewDraw;
    }


}
