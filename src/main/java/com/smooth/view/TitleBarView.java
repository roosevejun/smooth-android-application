package com.smooth.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.*;
import com.smooth.R;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.view
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/28-13:18
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EViewGroup(R.layout.common_title_bar)
public class TitleBarView extends RelativeLayout {
    private Context context;
    @ViewById(R.id.title_btn_left)
    Button btnLeft;
    @ViewById(R.id.title_btn_right)
    Button btnRight;
    @ViewById(R.id.constact_group)
    Button btn_titleLeft;
    @ViewById(R.id.constact_all)
    Button btn_titleRight;
    @ViewById(R.id.title_txt)
    TextView tv_center;
    @ViewById(R.id.common_constact)
    LinearLayout common_constact;

    public TitleBarView(Context context) {
        super(context);
        this.context = context;
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }
    @AfterViews
    protected void viewsInit() {
        // PROBLEM 1 would be fine now
    }
    public void setCommonTitle(int LeftVisibility,int centerVisibility,int center1Visibilter,int rightVisibility){
        btnLeft.setVisibility(LeftVisibility);
        btnRight.setVisibility(rightVisibility);
        tv_center.setVisibility(centerVisibility);
        common_constact.setVisibility(center1Visibilter);
    }
    public void setBtnLeft(int icon,int txtRes){
        Drawable img=context.getResources().getDrawable(icon);
        int height=SystemMethod.dip2px(context, 20);
        int width=img.getIntrinsicWidth()*height/img.getIntrinsicHeight();
        img.setBounds(0, 0, width, height);
        btnLeft.setText(txtRes);
        btnLeft.setCompoundDrawables(img, null, null, null);
    }

    public void setBtnLeft(int txtRes){
        btnLeft.setText(txtRes);
    }


    public void setBtnRight(int icon){
        Drawable img=context.getResources().getDrawable(icon);
        int height=SystemMethod.dip2px(context, 30);
        int width=img.getIntrinsicWidth()*height/img.getIntrinsicHeight();
        img.setBounds(0, 0, width, height);
        btnRight.setCompoundDrawables(img, null, null, null);
    }

    public void setTitleLeft(int resId){
        btn_titleLeft.setText(resId);
    }

    public void setTitleRight(int resId){
        btn_titleRight.setText(resId);
    }
    @SuppressLint("NewApi")
    public void setPopWindow(PopupWindow mPopWindow,TitleBarView titleBaarView){

        mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E9E9E9")));
        mPopWindow.showAsDropDown(titleBaarView, 0,-15);
        mPopWindow.setAnimationStyle(R.style.popwin_anim_style);
        mPopWindow.setFocusable(true);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.update();

        setBtnRight(R.drawable.skin_conversation_title_right_btn_selected);
    }

    public void setTitleText(int txtRes){
        tv_center.setText(txtRes);
    }

    public void setBtnLeftOnclickListener(OnClickListener listener){
        btnLeft.setOnClickListener(listener);
    }

    public void setBtnRightOnclickListener(OnClickListener listener){
        btnRight.setOnClickListener(listener);
    }

    public Button getTitleLeft(){
        return btn_titleLeft;
    }

    public Button getTitleRight(){
        return btn_titleRight;
    }

    public void destoryView(){
        btnLeft.setText(null);
        btnRight.setText(null);
        tv_center.setText(null);
    }

}
