package com.smooth;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.inject.Inject;
import com.smooth.listener.WelcomeListener;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RoboGuice;
import org.androidannotations.annotations.ViewById;

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
public class MainActivity extends Activity {
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
    @ViewById(R.id.buttom_setting)
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
}
