package com.smooth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.smooth.R;
import com.smooth.ercode.CameraManager;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.res.ColorRes;
import org.androidannotations.annotations.res.DrawableRes;

import java.util.Collection;
import java.util.HashSet;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.view
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/29-15:50
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EView
public  class ErcodeScanView extends View {


    public ErcodeScanView(Context context) {
        super(context);
    }

    public ErcodeScanView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ErcodeScanView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
