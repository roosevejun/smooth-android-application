package com.smooth.interfaces;

import com.smooth.R;
import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultRes;
import org.androidannotations.annotations.sharedpreferences.SharedPref;


/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.listener
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-15:30
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@SharedPref(value=SharedPref.Scope.UNIQUE)
public interface SysPrefs {
    @DefaultBoolean(value = false)
    boolean isFirst();
}
