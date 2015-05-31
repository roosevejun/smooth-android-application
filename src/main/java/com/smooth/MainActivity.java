package com.smooth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import com.google.inject.Inject;
import com.smooth.activity.LoginActivity_;
import com.smooth.fragment.*;
import com.smooth.listener.WelcomeListener;
import org.androidannotations.annotations.*;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/27-19:18
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EActivity(R.layout.activity_main)
@RoboGuice(WelcomeListener.class)
public class MainActivity extends FragmentActivity  {
    protected static final String TAG = "MainActivity";
    @Inject
    Context context;
    @ViewById(R.id.buttom_news)
    ImageButton mNews;
    @ViewById(R.id.buttom_constact)
    ImageButton mConstact;
    @ViewById(R.id.buttom_deynaimic)
    ImageButton mDeynaimic;
    @ViewById(R.id.buttom_setting)
    ImageButton mSetting;
    View currentButton;
    private int mLevel = 1;
    @FragmentById(R.id.fl_content)
    NewsFatherFragment newsFatherFragment;
    @FragmentByTag("appExit")
    AppExitFragment appExitFragment;
   @FragmentByTag("setting")
   SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterInject
    void afterInject() {

    }

    @AfterViews
    void afterViews() {
        mNews.performClick();
    }

    @Click(R.id.buttom_news)
    void newsOnClickListener(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_content, newsFatherFragment, MainActivity_.TAG);
        ft.commit();
        setButton(v);
    }

    @Click(R.id.buttom_constact)
    void constactOnClickListener() {
    }

    @Click(R.id.buttom_deynaimic)
    void deynaimicOnClickListener() {
    }

    @Click(R.id.buttom_setting)
    void settingOnClickListener() {
    }

    private void setButton(View v) {
        if (currentButton != null && currentButton.getId() != v.getId()) {
            currentButton.setEnabled(true);
        }
        v.setEnabled(false);
        currentButton = v;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(appExitFragment==null)
                appExitFragment = new AppExitFragment_();
            appExitFragment.show(ft, "appExit");
        }
        return super.onKeyDown(keyCode, event);
    }


}
