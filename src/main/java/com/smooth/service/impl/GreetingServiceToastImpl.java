package com.smooth.service.impl;

import android.content.Context;
import android.widget.Toast;
import com.google.inject.Inject;
import com.smooth.service.GreetingService;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.service.impl
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-13:41
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class GreetingServiceToastImpl  implements GreetingService {
    @Inject
    Context context;

    @Override
    public void greet(String name) {
        Toast.makeText(context, "Hello " + name, Toast.LENGTH_LONG).show();
    }
}
