package com.orangechain.laplace.base.basehelper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class MyApplication extends Application {

    private static Context mcontext;

    private String topActivity;//最上层的活动

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

                topActivity = activity.getClass().getName();

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });


    }

    public static Context getContext() {
        return mcontext;
    }


    public boolean isTopActivity(String TAG){
        if(TextUtils.isEmpty(topActivity))
            return false;
        return topActivity.contains(TAG);
    }

}
