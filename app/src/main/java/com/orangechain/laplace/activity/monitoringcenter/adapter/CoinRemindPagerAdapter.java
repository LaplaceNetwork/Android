package com.orangechain.laplace.activity.monitoringcenter.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CoinRemindPagerAdapter extends PagerAdapter {

    private List<View> views;

    public CoinRemindPagerAdapter(List<View> list) {

        views = list;

    }

    /**
     * 确认View与实例对象是否相互对应。ViewPager内部用于获取View对应的ItemInfo。
     *
     * @param view   ViewPager显示的View内容
     * @param object 在instantiateItem中提交给ViewPager进行保存的实例对象
     * @return 是否相互对应
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object ;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    /**
     * 为给定的位置创建相应的View。创建View之后,需要在该方法中自行添加到container中。
     * @param container ViewPager本身
     * @param position  位置
     * @return 提交给ViewPager进行保存的实例对象
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = views.get(position);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        //释放相应的view
        container.removeView(views.get(position));
    }
}
