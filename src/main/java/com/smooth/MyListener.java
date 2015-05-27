package com.smooth;

import android.content.Context;
import android.widget.Toast;
import com.google.inject.Inject;
import roboguice.activity.event.OnResumeEvent;
import roboguice.event.Observes;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-13:39
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class MyListener {
    @Inject
    Context context;
    public void doSomethingOnResume(@Observes OnResumeEvent onResume) {
        Toast.makeText(context, "Activity has been resumed", Toast.LENGTH_LONG).show();
    }
}
