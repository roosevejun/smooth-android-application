package com.smooth.fragment;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smooth.R;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Administrator on 2015/5/30.
 */
@EFragment
public class AlertDialogFragment extends DialogFragment {
    public interface DialogFragmentClickImpl {
        void doPositiveClick();

        void doNegativeClick();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.e("TAG", "**onCreateDialog**");
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_launcher)
                .setTitle("退出微信")
                .setMessage("是否退出微信，是否退出微信，是否退出微信，是否退出微信，")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                DialogFragmentClickImpl impl = (DialogFragmentClickImpl) getActivity();
                                impl.doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                DialogFragmentClickImpl impl = (DialogFragmentClickImpl) getActivity();
                                impl.doNegativeClick();
                            }
                        }
                )
                .create();
    }
}
