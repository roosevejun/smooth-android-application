package com.smooth.service.impl;

import android.content.Context;
import android.widget.Toast;
import com.google.inject.Inject;
import com.smooth.bean.UserLoginInfo;
import com.smooth.bean.UserLoginInfoUI;
import com.smooth.bean.WebResult;
import com.smooth.service.UserLoginService;
import com.smooth.service.UserService_;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.service.impl
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/27-10:03
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class UserLoginServiceImpl implements UserLoginService {
    @Inject
    Context context;

    @Override
    public UserLoginInfo convertUser(UserLoginInfoUI userLoginInfoUi) {
        UserLoginInfo userLoginInfo=new UserLoginInfo();
        userLoginInfo.setUserName(userLoginInfoUi.getUserName().getText().toString());
        userLoginInfo.setUserPass(userLoginInfoUi.getUserPass().getText().toString());
        return userLoginInfo;
    }
}
