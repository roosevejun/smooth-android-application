package com.smooth.service;

import com.smooth.bean.UserLoginInfo;
import com.smooth.bean.UserLoginInfoUI;
import com.smooth.bean.WebResult;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.service
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/27-10:02
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public interface UserLoginService {
    UserLoginInfo convertUser(UserLoginInfoUI userLoginInfoUi);
}
