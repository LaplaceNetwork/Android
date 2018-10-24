package com.orangechain.laplace.activity.monitoringcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.monitoringcenter.activity.CoinUnusualActivity;
import com.orangechain.laplace.activity.monitoringcenter.bean.CoinUnusualBean;

import java.util.List;

public class CoinUnusualAdapter extends ArrayAdapter {

    private int mResource;

    private CoinUnusualActivity activity;

    public CoinUnusualAdapter(Context context, int resource, List<CoinUnusualBean> objects) {
        super(context, resource, objects);

        this.mResource = resource;
        this.activity = (CoinUnusualActivity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final CoinUnusualBean bean = (CoinUnusualBean) getItem(position);

        final View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_coin_unusual_list_activity,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.coinName = view.findViewById(R.id.coin_unusual_name);
            viewHolder.baseCoinName = view.findViewById(R.id.coin_unusual_des);
            viewHolder.proportion = view.findViewById(R.id.item_coin_unusual_proportion);
            viewHolder.inputProportion = view.findViewById(R.id.item_coin_unusual_in_proportion);
            viewHolder.outputProportion = view.findViewById(R.id.item_coin_unusual_out_proportion);
            viewHolder.aSwitch = view.findViewById(R.id.item_coin_unusual_switch);

            view.setTag(viewHolder);

        } else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.coinName.setText(bean.getCoinName());
        viewHolder.baseCoinName.setText(bean.getBaseCoinName());
        viewHolder.proportion.setText(bean.getProportion());
        viewHolder.inputProportion.setText(bean.getInputProportion());
        viewHolder.outputProportion.setText(bean.getOutputProportion());
        viewHolder.aSwitch.setChecked(bean.getSwitchStatus());

        viewHolder.aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bean.getType() == "number") {
                    //显示数量
                    final ViewGroup viewGroup =(ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.input_coin_unusual_number_frame,activity.getBaseViewGroup());

                    //移除
                    final View baseView = viewGroup.findViewById(R.id.input_coin_unusual_number_frame_layout);
                    if (baseView != null) {
                        baseView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewGroup.removeView(baseView);
                            }
                        });


                        final Button button = viewGroup.findViewById(R.id.coin_unusual_number_save_button);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewGroup.removeView(baseView);
                            }
                        });

                    }

                } else {
                    //显示比列

                    //显示数量
                    final ViewGroup viewGroup =(ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.input_coin_unusual_proportion_frame,activity.getBaseViewGroup());

                    //移除
                    final View baseView = viewGroup.findViewById(R.id.input_coin_unusual_proportion_frame_layout);
                    if (baseView != null) {
                        baseView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewGroup.removeView(baseView);
                            }
                        });


                        final Button button = viewGroup.findViewById(R.id.coin_unusual_proportion_save_button);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewGroup.removeView(baseView);
                            }
                        });

                    }

                }

            }
        });




        return view;

    }

    class ViewHolder {

        TextView coinName;

        TextView baseCoinName;

        TextView proportion;

        TextView inputProportion;

        TextView outputProportion;

        Switch aSwitch;

    }


}
