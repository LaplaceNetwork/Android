package com.orangechain.laplace.ToolUtil;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import com.orangechain.laplace.base.basehelper.MyApplication;

public class SizeConvertUtil {

    /**
     * dp转px
     * @param dp
     * @return
     */
    public static int dip2px(int dp)
    {
        float density = MyApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dp*density+0.5);
    }

    /**	 * dp转为px
     * @param context  上下文
     * @param dipValue dp值
     * @return	 */
    public static int dip2px(Context context, float dipValue) 	{
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(	TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }

    /** px转换dip */
    public static int px2dip(int px) {
        final float scale = MyApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
    /** px转换sp */
    public static int px2sp(int pxValue) {
        final float fontScale = MyApplication.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
    /** sp转换px */
    public static int sp2px(int spValue) {
        final float fontScale = MyApplication.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
