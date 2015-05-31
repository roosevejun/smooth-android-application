package com.smooth.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.google.inject.Inject;
import com.smooth.R;
import com.smooth.interfaces.SysPrefs_;
import com.smooth.listener.WelcomeListener;
import com.smooth.manager.SDManager;
import com.smooth.service.GreetingService;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RoboGuice;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-15:24
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@RoboGuice(WelcomeListener.class)
@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends Activity {
    @Inject
    Context context;
    @ViewById(R.id.iv_welcome)
    ImageView iv_welcome;
    @Pref
    SysPrefs_ sysPrefs;
    @AnimationRes
    Animation login_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @AfterViews
    void initView() {
        iv_welcome.setAnimation(login_anim);
        iv_welcome.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isFirst = sysPrefs.isFirst().get();
                if (isFirst) {
                    SDManager manager = new SDManager(context);
                    manager.moveUserIcon();
                    sysPrefs.edit().isFirst().put(false);
                    Intent intent = new Intent(context, LoginActivity_.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(context, LoginActivity_.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }


}
