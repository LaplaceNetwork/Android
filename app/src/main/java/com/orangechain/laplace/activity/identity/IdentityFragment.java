package com.orangechain.laplace.activity.identity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.ToolHelper;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.activity.identity.adapter.IdetityFragmentAdapter;
import com.orangechain.laplace.activity.identity.bean.IdentityFragmentBean;
import com.orangechain.laplace.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdentityFragment extends BaseFragment {

    //创建数据源
    private List<IdentityFragmentBean> beanlist = new ArrayList<IdentityFragmentBean>();

    @Override
    public void initWithView(View view) {

        ImageView protectImageView = view.findViewById(R.id.identity_usericon_imageview);

        //这边需要对图片做一个剪裁 圆角剪裁
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539608309718&di=b2379fa2bb33ffbc19a0507f54ea4f21&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201501%2F25%2F20150125094219_cWXuL.jpeg")
                .apply(bitmapTransform(new CircleCrop())).into(protectImageView);


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
        activity.getSupportActionBar().setHomeAsUpIndicator(ToolHelper.changePictureColor(getActivity(),R.color.colorF3F3F3,R.drawable.baseline_protect_black_24dp));
        activity.getSupportActionBar().setHomeAsUpIndicator(ToolHelper.changePictureColor(getActivity(),R.color.colorGray,R.drawable.baseline_report_black_24dp));

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_identity;
    }
}
