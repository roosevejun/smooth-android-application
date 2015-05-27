package com.smooth;

import android.app.Activity;
import android.widget.ImageView;
import com.smooth.service.GreetingService;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RoboGuice;
import org.androidannotations.annotations.ViewById;
import android.widget.EditText;
import com.google.inject.Inject;
/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-13:42
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EActivity(R.layout.activity_welcome)
@RoboGuice(MyListener.class)
public class AstroGirl extends Activity {
    @ViewById
    EditText edit;

    @Inject
    GreetingService greetingService;
    @ViewById(R.id.iv_welcome)
    ImageView iv_welcome;

    @Click
    void button() {
        String name = edit.getText().toString();
        greetingService.greet(name);
    }
}
