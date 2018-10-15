package com.orangechain.laplace.activity.identity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.ToolHelper;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.identity.adapter.IdetityFragmentAdapter;
import com.orangechain.laplace.activity.identity.bean.IdentityFragmentBean;
import com.orangechain.laplace.base.BaseFragment;

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

        //创建数据源
        beanlist.clear();

        IdentityFragmentBean identityFragmentBean0 = new IdentityFragmentBean("潇洒","生效中","授权时间 2018.11.11 11:11:11","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=941310360,2054712345&fm=26&gp=0.jpg");
        IdentityFragmentBean identityFragmentBean1 = new IdentityFragmentBean("慎思","依旧生效中","授权时间 2018.11.11 11:11:11","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1241745327,2603208474&fm=26&gp=0.jpg");

        beanlist.add(identityFragmentBean0);
        beanlist.add(identityFragmentBean1);

        //生成相应的list
        IdetityFragmentAdapter idetityFragmentAdapter = new IdetityFragmentAdapter(getActivity(),R.layout.identity_fragment_item,beanlist);
        idetityFragmentAdapter.superFragment = this;
        ListView listView = view.findViewById(R.id.idcard_listview);
        listView.setAdapter(idetityFragmentAdapter);

        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IdentityFragmentBean bean = beanlist.get(position);//获取item实体数据
                Toast.makeText(getActivity(),bean.getName(),Toast.LENGTH_SHORT).show();
            }
        });


        //修改图片的填充颜色
        IndexActivity activity = (IndexActivity) getActivity();
        activity.getSupportActionBar().setHomeAsUpIndicator(ToolHelper.changePictureColor(getActivity(),R.color.colorGray,R.drawable.baseline_report_black_24dp));

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_identity;
    }
}
