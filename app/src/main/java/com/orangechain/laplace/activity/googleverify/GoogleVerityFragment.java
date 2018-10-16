package com.orangechain.laplace.activity.googleverify;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.googleverify.adapter.GoogleVerityFragmentAdapter;
import com.orangechain.laplace.activity.googleverify.bean.GoogleVerityFragmentBean;
import com.orangechain.laplace.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleVerityFragment extends BaseFragment {

    //创建 数据源
    private List<GoogleVerityFragmentBean> list = new ArrayList<>();

    @Override
    public void initWithView(View view) {


        list.clear();

        GoogleVerityFragmentBean bean0 = new GoogleVerityFragmentBean("889 556","E8game：yoyo","0");
        GoogleVerityFragmentBean bean1 = new GoogleVerityFragmentBean("220 252","E8game：yoyo","1");

        list.add(bean0);
        list.add(bean1);

        GoogleVerityFragmentAdapter adapter = new GoogleVerityFragmentAdapter(getActivity(),R.layout.item_google_verification_fragment,list);
        ListView listView = view.findViewById(R.id.Google_verification_listview);
        listView.setAdapter(adapter);

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_google_verity;
    }
}
