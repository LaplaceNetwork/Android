package com.orangechain.laplace.base;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/**
 * 此类主要用于管理应用的活动类
 */

public class BaseActivityCollector {

    /**
     * 建立容器
     */
    public static List<Activity> activities = new ArrayList<Activity>();

    /**
     * 添加活动
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 移除活动
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 移除所有活动
     */
    public static void finishAllActivity() {
        for (Activity activity:activities) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

    /**
     * 返回到指定历史活动
     */
    public static void finishAndGoBackHistoryActivity(Class historyActivity) {
        //倒叙
        for (int i = activities.size()-1;i>=0;i--) {
            Activity activity = activities.get(i);
            //如果不是指定的历史活动名称则销毁掉
            if (!activity.isFinishing()) {
                if (activity.getClass() != historyActivity) {
                    activity.finish();
                } else {
                    return;
                }
            }
        }
    }

}
