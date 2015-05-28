package com.smooth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.inject.Inject;
import com.smooth.activity.LoginActivity_;
import com.smooth.fragment.NewsFatherFragment;
import com.smooth.fragment.NewsFatherFragment_;
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
public class MainActivity extends FragmentActivity {
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
    @ViewById(R.id.app_exit)
    View mPopView;
    @ViewById(R.id.app_cancle)
    TextView app_cancle;
    @ViewById(R.id.app_exit)
    TextView app_exit;
    @ViewById(R.id.app_change_user)
    TextView app_change;
    @ViewById(R.id.buttom_bar_group)
    LinearLayout buttomBarGroup;
    PopupWindow mPopupWindow;
    View currentButton;
    private int mLevel = 1;
    @FragmentByTag
    NewsFatherFragment newsFatherFragment;
    @AfterInject
    void afterInject(){
//        mNews.performClick();
    }
    @AfterViews
    void afterViews() {
        mNews.performClick();
    }

    @Click(R.id.buttom_news)
    void newsOnClickListener(View v) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        newsFatherFragment=new NewsFatherFragment_();
        ft.replace(R.id.fl_content, newsFatherFragment,MainActivity_.TAG);
        ft.commit();
//        setButton(v);
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
    @Click(R.id.app_cancle)
    void cancleOnClickListener() {
        mPopupWindow.dismiss();
    }
    @Click(R.id.app_change_user)
    void changeUserOnClickListener() {
        Intent intent=new Intent(context, LoginActivity_.class);
        startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.activity_up, R.anim.fade_out);
        finish();
    }

    @Click(R.id.app_exit)
    void appExitOnClickListener() {
        finish();
    }
    private void setButton(View v){
        if(currentButton!=null&&currentButton.getId()!=v.getId()){
            currentButton.setEnabled(true);
        }
        v.setEnabled(false);
        currentButton=v;
    }

}
