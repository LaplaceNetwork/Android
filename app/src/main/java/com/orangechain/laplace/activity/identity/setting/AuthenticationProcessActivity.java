package com.orangechain.laplace.activity.identity.setting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.IndexActivity;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.base.BaseActivityCollector;

public class AuthenticationProcessActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("Laplace Passport");

        Button button = findViewById(R.id.auth_process_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //查看最终的结果 在此界面上直接显示结果 后期加动画
                getLayoutInflater().inflate(R.layout.custom_authentication_process_result,getMainViewGroup());

                //修改布局文件的值
                setResultViewData("Username","iyouus",R.id.authentication_process_result_username);
                setResultViewData("ID","198374058797897379746",R.id.authentication_process_result_id);
                setResultViewData("location","China",R.id.authentication_process_result_location);
                setResultViewData("Homepage","Http://e8game.net/friends-vision.siejt.html",R.id.authentication_process_result_homepage);
                setResultViewData("Avatar","Http://e8game.net/friends-vision.siejt.html",R.id.authentication_process_result_avatar);

            }
        });

    }

    /**
     * 动态设置结果数据
     */
    public void setResultViewData(String name,String content,int superLayout) {

        //修改布局文件的值
        ViewGroup viewGroup_username = findViewById(superLayout);
        TextView nameTextView = viewGroup_username.findViewById(R.id.custom_authentication_process_name);
        nameTextView.setText(name);
        TextView desTextView = viewGroup_username.findViewById(R.id.custom_authentication_process_des);
        desTextView.setText(content);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_authentication_process;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,AuthenticationProcessActivity.class);
        startWithNewAnimation(context,intent);

    }

    @Override
    public void leftAction() {
        BaseActivityCollector.finishAndGoBackHistoryActivity(IndexActivity.class);
    }
}
