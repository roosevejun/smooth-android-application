package com.smooth.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.inject.Inject;
import com.smooth.R;
import com.smooth.activity.LoginActivity_;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Administrator on 2015/5/30.
 */
@EFragment(R.layout.app_exit)
public class AppExitFragment extends DialogFragment {
    @Inject
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @AfterViews
    void afterViews(){

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
    @Click(R.id.app_cancle)
    void cancleOnClickListener() {
        Log.d("AppExitFragment", "cancleOnClickListener");
            this.dismiss();
    }

    @Click(R.id.app_change_user)
    void changeUserOnClickListener() {
        Log.d("AppExitFragment", "changeUserOnClickListener");
        Intent intent = new Intent(getActivity(), LoginActivity_.class);
        startActivityForResult(intent, 0);
        ( getActivity()).overridePendingTransition(R.anim.activity_up, R.anim.fade_out);
        getActivity().finish();

    }

    @Click(R.id.app_exit)
    void appExitOnClickListener() {
        Log.d("AppExitFragment", "appExitOnClickListener");
        getActivity().finish();
    }

}
