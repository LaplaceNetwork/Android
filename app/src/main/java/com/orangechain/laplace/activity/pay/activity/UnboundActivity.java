package com.orangechain.laplace.activity.pay.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orangechain.laplace.R;
import com.orangechain.laplace.base.BaseActivity;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class UnboundActivity extends BaseActivity {

    @Override
    public void initWithView() {

        setToolBarText("解除绑定");

        Button confirmButton = findViewById(R.id.unbound_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogPlus dialog = DialogPlus.newDialog(UnboundActivity.this)
                        .setContentHolder(new ViewHolder(R.layout.input_face_finger_id))
                        .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                        .setGravity(Gravity.CENTER)
                        .create();
                dialog.show();

            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbound;
    }

    @Override
    public void pushActivity(Context context) {

        Intent intent = getLaunchIntent(context,UnboundActivity.class);
        startWithNewAnimation(context,intent);

    }
}
