package com.smooth.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.smooth.R;
import com.smooth.view.TitleBarView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.fragment
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/28-10:47
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */


@EFragment(R.layout.fragment_mine)
public class SettingFragment extends DialogFragment {
    @ViewById(R.id.title_bar)
    TitleBarView mTitleBarView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @AfterViews
    void afterViews(){
    mTitleBarView.setCommonTitle(View.GONE, View.VISIBLE, View.GONE, View.GONE);
    mTitleBarView.setTitleText(R.string.mime);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getAttributes().windowAnimations = R.style.app_pop;
        return dialog;
    }
    @Override
    public int getTheme() {
        return R.style.app_pop;
    }
}
