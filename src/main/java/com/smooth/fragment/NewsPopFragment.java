package com.smooth.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.AttributeSet;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.inject.Inject;
import com.smooth.R;
import com.smooth.view.TitleBarView;
import org.androidannotations.annotations.*;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.fragment
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/29-11:25
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

@EFragment(R.layout.fragment_news_pop)
public class NewsPopFragment extends DialogFragment {
    @Inject
    Context context;

  //    @ViewById(R.id.pop_chat)
//    ImageView mChats;
//    @ViewById(R.id.pop_sangzhao)
//    ImageView mShare;
//    @ViewById(R.id.pop_camera)
//    ImageView mCamera;
//    @ViewById(R.id.pop_scan)
//    ImageView mScan;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, 0);

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        WindowManager.LayoutParams params = dialog.getWindow()
                .getAttributes();
        params.gravity = Gravity.TOP | Gravity.RIGHT;
//        params.x = 0;//b.getInt("x");
//        params.y = 160;//b.getInt("y");
        dialog.getWindow().setAttributes(params);
        // request a window without the title
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E9E9E9")));
        dialog.getWindow().getAttributes().windowAnimations = R.style.popwin_anim_style;
        return dialog;
    }
    @AfterViews
    void afterViews() {

    }
    @Override
    public void onStart() {
        super.onStart();
//        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getDialog().setCanceledOnTouchOutside(true);

    }
    @Click(R.id.pop_chat)
    void mScanClickListener(View v) {
        Toast.makeText(context, "mScanClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d("NewsPopFragment","onCancel");
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d("NewsPopFragment","onDismiss");
    }

}
