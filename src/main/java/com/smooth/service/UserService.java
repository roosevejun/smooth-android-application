package com.smooth.service;

import com.smooth.bean.UserLoginInfo;
import com.smooth.bean.WebResult;
import com.smooth.interceptor.LoginInterceptor;
import org.androidannotations.annotations.rest.*;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.service
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-18:34
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Rest(rootUrl = "http://qasmsoh.ahsmooth.tk", converters = {MappingJackson2HttpMessageConverter.class})
public interface UserService extends RestClientErrorHandling {
    @Post("/getUserInfo.action?id={userid}")
    @RequiresCookie("JSESSIONID")
    @RequiresAuthentication
    String UserInfo(String userid);

    /**
     * 登录系统，并将JSESSIONID
     * 设置到cookie中
     *
     * @param username
     * @param password
     * @return
     */
    @Post("/LoginLoad.json?userName={username}&userPass={password}")
    @SetsCookie("JSESSIONID")
    WebResult doUserLogin(String username, String password);

    void setAuthentication(HttpAuthentication auth);

    void setHttpBasicAuth(String username, String password);
}
