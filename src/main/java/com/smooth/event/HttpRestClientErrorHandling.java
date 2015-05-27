package com.smooth.event;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.inject.Inject;
import org.androidannotations.annotations.EBean;

import org.androidannotations.annotations.UiThread;
import org.androidannotations.api.rest.RestErrorHandler;
import org.springframework.core.NestedRuntimeException;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.event
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/27-12:35
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EBean
public class HttpRestClientErrorHandling implements RestErrorHandler{
    @Inject
    Context context;
    @Override
    public void onRestClientExceptionThrown(NestedRuntimeException e) {
        Log.d("REST", e.toString());
        showError();
    }
    @UiThread
    void showError(){
        Toast.makeText(context, "Rest Error...", Toast.LENGTH_SHORT).show();
    }
}
