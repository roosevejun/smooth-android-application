package com.smooth.view;

import android.content.Context;
import android.util.AttributeSet;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.inject.Inject;
import com.smooth.R;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

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
@EViewGroup(R.layout.fragment_news_pop)
public class NewsPopView extends RelativeLayout {
    @Inject
    Context context;
    @ViewById(R.id.pop_chat)
    ImageView mChats;
    @ViewById(R.id.pop_sangzhao)
    ImageView mShare;
    @ViewById(R.id.pop_camera)
    ImageView mCamera;
    @ViewById(R.id.pop_scan)
    ImageView mScan;

    public NewsPopView(Context context) {
        super(context);
    }

    public NewsPopView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewsPopView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @AfterViews
    void afterViews() {

    }
    @Click(R.id.pop_chat)
    void mScanClickListener(View v) {
        Toast.makeText(context, "mScanClick", Toast.LENGTH_SHORT).show();
    }
}
