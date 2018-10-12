package com.orangechain.laplace.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.orangechain.laplace.R;
import com.orangechain.laplace.ToolUtil.SizeConvertUtil;
import com.orangechain.laplace.interfac.BottomNavigationViewInterface;

public class BaseBottomNavigationActivity extends BaseActivity {

    public BottomNavigationView bottomNavigationView;

    @Override
    public void initWithView() {

        LayoutInflater layoutInflater = getLayoutInflater();
        //将bottom_navigation放到布局上
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.fl_root1);
        layoutInflater.inflate(R.layout.activity_base_bottom_navigation,relativeLayout);
        //设置bottomNavigation
        bottomNavigationView = relativeLayout.findViewById(R.id.bottom_navigation);

        //修改main_frame的布局规则
        FrameLayout main_frame = relativeLayout.findViewById(R.id.main_frame);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) main_frame.getLayoutParams();
        //params.bottomMargin = SizeConvertUtil.dip2px(53);
        //params.addRule(RelativeLayout.ABOVE,R.id.bottom_navigation);//这句不起作用 是个问题
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.botttom_navigation_height);
        main_frame.setLayoutParams(params);

        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home_id:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_home_id);
                        return true;
                    case R.id.nav_pay:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_pay);
                        return true;
                    case R.id.nav_google_verity:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_google_verity);
                        return true;
                    case R.id.nav_current_time:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_current_time);
                        return true;
                    case R.id.nav_monitoring_center:
                        BottomNavigationViewEvent.clickItemAction(R.id.nav_monitoring_center);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    /**
     * 设置BottomNavigationView是否显示
     */
    public void setBottomNavigationViewVisible(int visible) {
        bottomNavigationView.setVisibility(visible);
    }

    /**
     * 创建一个关于BottomNavigationView接口的内部类
     */
    public static class BottomNavigationViewEvent {

        private static BottomNavigationViewInterface mBottomNavigationViewInterface;

        public static void setBottomNavigationVInterface(BottomNavigationViewInterface BNVInterface) {

            mBottomNavigationViewInterface = BNVInterface;

        }

        public static void clickItemAction(int actionId) {
            mBottomNavigationViewInterface.clickNavigationItemListener(actionId);
        }

    }

    @Override
    public void pushActivity(Context context) {

        //不做任何事情

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_bottom_navigation;
    }
}
