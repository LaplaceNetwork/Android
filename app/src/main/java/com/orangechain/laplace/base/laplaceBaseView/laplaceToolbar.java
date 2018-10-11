package com.orangechain.laplace.base.laplaceBaseView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.orangechain.laplace.R;

public class laplaceToolbar extends Toolbar {

    /**
     * 左侧Title
     */
    private TextView mTxtLeftTitle;
    /**
     * 中间Title
     */
    private TextView mTxtMiddleTitle;
    /**
     * 右侧Title
     */
    private TextView mTxtRightTitle;

    //构造函数
    public laplaceToolbar(Context context) {
        this(context,null);
    }

    public laplaceToolbar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public laplaceToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater.from(context).inflate(R.layout.laplace_toolbar, this);
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMiddleTitle = (TextView) findViewById(R.id.txt_main_title);
        mTxtRightTitle = (TextView) findViewById(R.id.txt_right_title);
    }

//    @Override
//    protected void onFinishInflate() {
//        super.onFinishInflate();
//    }

    /***********************中间*************************/
    //设置中间title的内容
    public void setMainTitle(String text) {
        this.setTitle(" ");
        mTxtMiddleTitle.setVisibility(View.VISIBLE);
        mTxtMiddleTitle.setText(text);
    }

    //设置中间title的内容文字的颜色
    public void setMainTitleColor(int color) {
        mTxtMiddleTitle.setTextColor(color);
    }


    /***********************左边*************************/
    //设置title左边文字
    public void setLeftTitleText(String text) {
        mTxtLeftTitle.setVisibility(View.VISIBLE);
        mTxtLeftTitle.setText(text);
    }

    //设置title左边文字颜色
    public void setLeftTitleColor(int color) {
        mTxtLeftTitle.setTextColor(color);
    }

    //设置title左边文字尺寸
    public void setLeftTitleSize(float sp_size) {
        mTxtLeftTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,sp_size);
    }

    //隐藏左边图片
    public void setLeftTitleDrawableHidden() {
        mTxtLeftTitle.setCompoundDrawables(null,null,null,null);
    }

    //设置内边距
    public void setLeftTitlePadding(int left, int top, int right, int bottom){
        mTxtLeftTitle.setPadding(left,top,right,bottom);
    }

    //设置title左边图标
    public void setLeftTitleDrawable(int res) {
        Drawable dwLeft = ContextCompat.getDrawable(getContext(), res);
        dwLeft.setBounds(0, 0, dwLeft.getMinimumWidth(), dwLeft.getMinimumHeight());
        mTxtLeftTitle.setCompoundDrawables(dwLeft, null, null, null);
    }
    //设置title左边点击事件
    public void setLeftTitleClickListener(OnClickListener onClickListener){
        mTxtLeftTitle.setOnClickListener(onClickListener);
    }

    //设置左边是否显示 或者 隐藏
    public void setLeftTitleShow(boolean isShow) {
        if (isShow) {
            mTxtLeftTitle.setVisibility(View.VISIBLE);
        } else {
            mTxtLeftTitle.setVisibility(View.INVISIBLE);
        }
    }

    /***********************右边*************************/

    //设置title右边文字
    public void setRightTitleText(String text) {
        mTxtRightTitle.setVisibility(View.VISIBLE);
        mTxtRightTitle.setText(text);
    }

    //隐藏右边
    public void setRightVisible(int visible ) {
        mTxtRightTitle.setVisibility(visible);
    }

    //设置title右边文字颜色
    public void setRightTitleColor(int color) {
        mTxtRightTitle.setTextColor(color);
    }

    //设置title右边图标
    public void setRightTitleDrawable(int res) {
        mTxtRightTitle.setVisibility(View.VISIBLE);
        Drawable dwRight = ContextCompat.getDrawable(getContext(), res);
        dwRight.setBounds(0, 0, dwRight.getMinimumWidth(), dwRight.getMinimumHeight());
        mTxtRightTitle.setCompoundDrawables(null, null, dwRight, null);
    }

    //隐藏左边图片
    public void setRightTitleDrawableHidden() {
        mTxtRightTitle.setCompoundDrawables(null,null,null,null);
    }

    //设置内边距
    public void setRightTitlePadding(int left, int top, int right, int bottom){
        mTxtRightTitle.setPadding(left,top,right,bottom);
    }

    //设置title右边点击事件
    public void setRightTitleClickListener(OnClickListener onClickListener){
        mTxtRightTitle.setOnClickListener(onClickListener);
    }

}
