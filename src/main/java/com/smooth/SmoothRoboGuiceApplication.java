package com.smooth;

import android.app.Application;
import roboguice.RoboGuice;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-13:37
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class SmoothRoboGuiceApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RoboGuice.setUseAnnotationDatabases(false);
    }
}
