package com.smooth.bean;

import android.widget.EditText;
import com.smooth.R;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.bean
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-18:38
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EBean
public  class UserLoginInfoUI {
    @ViewById(R.id.account)
     EditText userName;
    @ViewById(R.id.password)
    EditText  userPass;

    public EditText getUserName() {
        return userName;
    }

    public void setUserName(EditText userName) {
        this.userName = userName;
    }

    public EditText getUserPass() {
        return userPass;
    }

    public void setUserPass(EditText userPass) {
        this.userPass = userPass;
    }
}
