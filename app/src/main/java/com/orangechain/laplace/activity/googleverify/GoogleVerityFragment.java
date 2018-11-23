package com.orangechain.laplace.activity.googleverify;

import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.googleverify.adapter.GoogleVerityFragmentAdapter;
import com.orangechain.laplace.activity.googleverify.bean.GoogleVerityFragmentBean;
import com.orangechain.laplace.activity.pay.PayFragment;
import com.orangechain.laplace.activity.pay.activity.PayCardAuthActivity;
import com.orangechain.laplace.base.BaseActivityCollector;
import com.orangechain.laplace.base.BaseFragment;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleVerityFragment extends BaseFragment {

    private View mView;

    //创建 数据源
    private List<GoogleVerityFragmentBean> list = new ArrayList<>();

    @Override
    public void initWithView(View view) {

        this.mView = view;


        list.clear();

        GoogleVerityFragmentBean bean0 = new GoogleVerityFragmentBean("889 556", "E8game：yoyo", "0");
        GoogleVerityFragmentBean bean1 = new GoogleVerityFragmentBean("220 252", "E8game：yoyo", "1");

        list.add(bean0);
        list.add(bean1);

        final GoogleVerityFragmentAdapter adapter = new GoogleVerityFragmentAdapter(getActivity(), R.layout.item_google_verification_fragment, list);
        final ListView listView = view.findViewById(R.id.Google_verification_listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //显示提示内容
                final DialogPlus dialog = DialogPlus.newDialog(mView.getContext())
                        .setContentHolder(new ViewHolder(R.layout.input_google_verity_delete))
                        .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                        .setGravity(Gravity.CENTER)
                        .setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(DialogPlus dialog, View view) {
                                //删除对应的内容
                                list.remove(position);
                                adapter.notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        })
                        .create();
                dialog.show();

            }
        });

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_google_verity;
    }

    @Override
    public void onPause() {
        super.onPause();
        IndexActivity indexActivity = (IndexActivity) getActivity();
        ViewGroup layoutViewGroup = indexActivity.findViewById(R.id.input_google_verification_frame_layout);
        if (layoutViewGroup != null) {
            indexActivity.getBaseViewGroup().removeView(layoutViewGroup);
        }
    }
}
