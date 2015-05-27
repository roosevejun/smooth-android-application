package com.smooth.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.androidannotations.annotations.EBean;

@JsonIgnoreProperties(ignoreUnknown = true)
@EBean(scope = EBean.Scope.Singleton)
public class WebResult {

    private String code;

    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
