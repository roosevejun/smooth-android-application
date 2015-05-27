package com.smooth.interceptor;

import android.content.Context;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.interceptor
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/27-12:48
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EBean
public class LoginInterceptor implements ClientHttpRequestInterceptor {
    @RootContext
    Context context;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        return null;
    }
}
