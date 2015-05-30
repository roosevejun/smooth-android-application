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
public class MainActivity extends FragmentActivity implements AlertDialogFragment_.DialogFragmentClickImpl {
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
    @FragmentById(R.id.fl_content)
    NewsFatherFragment newsFatherFragment;
    @FragmentByTag("alertDialog")
    AlertDialogFragment alertDialogFragment;

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
        Intent intent = new Intent(context, LoginActivity_.class);
        startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_up, R.anim.fade_out);
        finish();
    }

    @Click(R.id.app_exit)
    void appExitOnClickListener() {
        finish();
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
//            Fragment fragment =   getSupportFragmentManager().findFragmentByTag("alertDialog");
//            if (null != fragment) {
//                ft.remove(fragment);
//            }
            if(alertDialogFragment==null)
             alertDialogFragment = new AlertDialogFragment_();
            alertDialogFragment.show(ft, "alertDialog");
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void doPositiveClick() {
        showToast("确定按钮");
    }

    @Override
    public void doNegativeClick() {
        showToast("取消按钮");
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
