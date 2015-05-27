package com.smooth.view;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smooth.R;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.common_loading_view)
public class LoadingView extends RelativeLayout {
    private Context mContext;
    @ViewById(R.id.iv_loading)
    ImageView mImageView;
    @ViewById(R.id.tv_loading)
    TextView mTextView;

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setImgOnClickListener(OnClickListener listener) {
        mImageView.setOnClickListener(listener);
    }

    public void setText(int txtRes) {
        mTextView.setText(txtRes);
    }

}
