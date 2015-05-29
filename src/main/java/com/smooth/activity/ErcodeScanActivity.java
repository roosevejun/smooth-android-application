package com.smooth.activity;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.inject.Inject;
import com.smooth.R;
import com.smooth.listener.UserLoginListener;
import com.smooth.view.TextURLView;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RoboGuice;
import org.androidannotations.annotations.ViewById;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/29-15:36
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EActivity(R.layout.fragment_news_code_scan)
@RoboGuice(UserLoginListener.class)
public class ErcodeScanActivity extends Activity implements Callback{
    @Inject
    Context context;
     RelativeLayout rl_user;
     Button mLogin;
     Button register;
    @ViewById(R.id.viewfinder_view)
    TextURLView mTextViewURL;
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
