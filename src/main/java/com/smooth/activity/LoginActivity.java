package com.smooth.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.inject.Inject;

import com.smooth.MainActivity_;
import com.smooth.R;
import com.smooth.bean.UserLoginInfoUI;
import com.smooth.bean.WebResult;
import com.smooth.event.HttpRestClientErrorHandling;
import com.smooth.listener.UserLoginListener;
import com.smooth.service.UserService;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.rest.RestService;
import roboguice.event.EventManager;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-16:53
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EActivity(R.layout.activity_login)
@RoboGuice(UserLoginListener.class)
public class LoginActivity extends Activity {
    @Inject
    Context context;
    @ViewById(R.id.rl_user)
    RelativeLayout rl_user;
    @Bean
    UserLoginInfoUI userLoginInfoUI;
    @Bean
    HttpRestClientErrorHandling httpRestClientErrorHandling;
    @RestService
    UserService userService;
    @AnimationRes(R.anim.login_anim)
    XmlResourceParser xmlResAnim;

    @AnimationRes
    Animation login_anim;
    @Inject
    EventManager eventManager;


    @Click(R.id.login)
    void button() {
        douserLoginPost();
    }

    @Background
    void douserLoginPost() {
        WebResult webResult = userService.doUserLogin(userLoginInfoUI.getUserName().getText().toString(), userLoginInfoUI.getUserPass().getText().toString());
        eventManager.fire(webResult);
        showToast(webResult.getMessage());
        if (webResult.getCode().equals("0001")) {
            loginSueccess();
            userService.setHttpBasicAuth(userLoginInfoUI.getUserName().getText().toString(), userLoginInfoUI.getUserPass().getText().toString());
        }
    }

    @UiThread
    void loginSueccess() {
        Intent intent = new Intent(context, MainActivity_.class);
        startActivity(intent);
        finish();
    }

    /**
     * 利用UI线程显示一个Toast
     *
     * @param content
     */
    @UiThread
    void showToast(String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 延时显示
     *
     * @param content
     */
    @UiThread(delay = 1000)
    void showToastDelay(String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    @AfterInject
    void afterInject() {
        userService.setRestErrorHandler(httpRestClientErrorHandling);
    }

    @AfterViews
    void afterViews() {
        rl_user.startAnimation(login_anim);
    }
}
