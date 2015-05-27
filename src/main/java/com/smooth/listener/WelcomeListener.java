package com.smooth.listener;

import android.content.Context;
import android.widget.Toast;
import com.google.inject.Inject;
import roboguice.activity.event.OnResumeEvent;
import roboguice.event.Observes;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.listener
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-15:30
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class WelcomeListener {
    @Inject
    Context context;
    public void welcomeOnResume(@Observes OnResumeEvent onResume) {
        Toast.makeText(context, "Welcome Activity has been resumed", Toast.LENGTH_LONG).show();
    }

}
