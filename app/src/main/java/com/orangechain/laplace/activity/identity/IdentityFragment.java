package com.orangechain.laplace.activity.identity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.identity.adapter.IdetityFragmentAdapter;
import com.orangechain.laplace.activity.identity.bean.IdentityFragmentBean;
import com.orangechain.laplace.base.BaseFragment;
import com.orangechain.laplace.base.basehelper.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdentityFragment extends BaseFragment {

    //创建数据源
    private List<IdentityFragmentBean> beanlist = new ArrayList<IdentityFragmentBean>();

    @Override
    public void initWithView(View view) {


        beanlist.clear();

        IdentityFragmentBean identityFragmentBean0 = new IdentityFragmentBean("whdaius","doahsoidha","sdasdas","sdasdasda");
        IdentityFragmentBean identityFragmentBean1 = new IdentityFragmentBean("adsda","23eweqweq","ewrwereqw","likfhiowe");

        beanlist.add(identityFragmentBean0);
        beanlist.add(identityFragmentBean1);

        IdetityFragmentAdapter idetityFragmentAdapter = new IdetityFragmentAdapter(getActivity(),R.layout.identity_fragment_item,beanlist);
        ListView listView = view.findViewById(R.id.idcard_listview);
        listView.setAdapter(idetityFragmentAdapter);


    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_identity;
    }
}
