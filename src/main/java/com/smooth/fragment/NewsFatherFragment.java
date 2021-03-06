package com.smooth.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.google.inject.Inject;
import com.smooth.R;
import com.smooth.view.TitleBarView;
import com.smooth.view.TitleBarView_;
import org.androidannotations.annotations.*;

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
@EFragment(R.layout.fragment_news_father)
public class NewsFatherFragment extends Fragment {
    @Inject
    Context context;
    @FragmentByTag("newsPop")
    NewsPopFragment mPopView;
    @ViewById(R.id.title_bar)
    TitleBarView mTitleBarView;


//    ImageView mChats;
//
//    ImageView mShare;
//
//    ImageView mCamera;
//
//    ImageView mScan;
    @ViewById(R.id.rl_canvers)
    RelativeLayout mCanversLayout;

    @ViewById(R.id.child_fragment)
    FrameLayout frameLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mPopView = inflater.inflate(R.layout.fragment_news_pop, null);
//        mChats = (ImageView) mPopView.findViewById(R.id.pop_chat);
//        mShare = (ImageView) mPopView.findViewById(R.id.pop_sangzhao);
//        mCamera = (ImageView) mPopView.findViewById(R.id.pop_camera);
//        mScan = (ImageView) mPopView.findViewById(R.id.pop_scan);
        return null;
    }



    @AfterViews
    void afterViews() {
        mTitleBarView.setCommonTitle(View.GONE, View.GONE, View.VISIBLE,
                View.VISIBLE);
        mTitleBarView.setBtnRight(R.drawable.skin_conversation_title_right_btn);

//        mPopupWindow = new PopupWindow(mPopView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
//        mPopupWindow.setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                mTitleBarView
//                        .setBtnRight(R.drawable.skin_conversation_title_right_btn);
//                mCanversLayout.setVisibility(View.GONE);
//            }
//        });
        mTitleBarView.setTitleLeft(R.string.cnews);
        mTitleBarView.setTitleRight(R.string.call);


//        mTitleBarView.getTitleLeft().setOnClickListener(new OnClickListener() {
//            @SuppressLint("NewApi")
//            @Override
//            public void onClick(View v) {
//                if (mTitleBarView.getTitleLeft().isEnabled()) {
//                    mTitleBarView.getTitleLeft().setEnabled(false);
//                    mTitleBarView.getTitleRight().setEnabled(true);

//                    FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    NewsFragment newsFragment = new NewsFragment();
//                    ft.replace(R.id.child_fragment, newsFragment, NewsFatherFragment.TAG);
//                    ft.commit();
//                }
//            }
//        });

//        mTitleBarView.getTitleRight().setOnClickListener(new OnClickListener() {
//            @SuppressLint("NewApi")
//            @Override
//            public void onClick(View v) {
//                if (mTitleBarView.getTitleRight().isEnabled()) {
//                    mTitleBarView.getTitleLeft().setEnabled(true);
//                    mTitleBarView.getTitleRight().setEnabled(false);

//                    FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    CallFragment callFragment = new CallFragment();
//                    ft.replace(R.id.child_fragment, callFragment, NewsFatherFragment.TAG);
//                    ft.commit();


//                }
//
//            }
//        });

        mTitleBarView.getTitleLeft().performClick();

//        mTitleBarView.getMScan().setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ErcodeScanActivity.class);
//                startActivity(intent);
//                mPopupWindow.dismiss();
//            }
//        });
//
//        mCamera.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, WaterCameraActivity.class);
//                startActivity(intent);
//                mPopupWindow.dismiss();
//
//            }
//        });
    }

    @Click({R.id.title_btn_right})

    void BtnRightClicked() {
        mTitleBarView.setTitleLeft(R.string.scan_title);
        mTitleBarView.setBtnRight(R.drawable.skin_conversation_title_right_btn_selected);

        mTitleBarView.refreshDrawableState();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        if(mPopView==null)
            mPopView = new NewsPopFragment_();
        mPopView.show(ft, "newsPop");

    }

}
