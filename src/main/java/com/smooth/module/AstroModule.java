package com.smooth.module;

import com.google.inject.AbstractModule;
import com.smooth.service.GreetingService;
import com.smooth.service.UserLoginService;
import com.smooth.service.impl.GreetingServiceToastImpl;
import com.smooth.service.impl.UserLoginServiceImpl;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.module
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-13:44
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class AstroModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(GreetingService.class).to(GreetingServiceToastImpl.class);
        bind(UserLoginService.class).to(UserLoginServiceImpl.class);
    }
}
