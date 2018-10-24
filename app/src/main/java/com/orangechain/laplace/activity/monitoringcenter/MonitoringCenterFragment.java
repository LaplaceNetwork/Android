package com.orangechain.laplace.activity.monitoringcenter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.activity.CoinUnusualActivity;
import com.orangechain.laplace.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonitoringCenterFragment extends BaseFragment {

    @Override
    public void initWithView(View view) {

        //币价异动
        View coinUnusualView = view.findViewById(R.id.MonitoringCenter_coin_unusual_layout);
        coinUnusualView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CoinUnusualActivity coinUnusualActivity = new CoinUnusualActivity();
                coinUnusualActivity.pushActivity(getActivity());
            }
        });

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_monitoring_center;
    }


}
