package com.orangechain.laplace.base;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orangechain.laplace.R;

public abstract class BaseFragment extends Fragment {

    private View view;

    //父文本 活动
    protected Context mContext;
    protected Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取布局
        view = inflater.inflate(getFragmentLayoutId(),container,false);

        try{
            mContext = getContext();
            mActivity = getActivity();

            //创建内容
            initWithView(view);

        }catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }

    /**
     * 界面初始化
     */
    public abstract void initWithView(View view);

    /**
     * 回去布局ID
     */
    public abstract int getFragmentLayoutId();




}
