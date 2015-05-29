package com.smooth.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smooth.R;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.view
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/29-15:40
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EViewGroup(R.layout.common_url_textview)
public class TextURLView extends LinearLayout {
    @ViewById(R.id.tv_url_view)
     TextView url;
    public TextURLView(Context context) {
        super(context);
    }

    public TextURLView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setText(int txtRes){
        url.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        url.setText(txtRes);
    }

    public void setUrlOnclickListener(OnClickListener listener){
        url.setOnClickListener(listener);
    }

}
