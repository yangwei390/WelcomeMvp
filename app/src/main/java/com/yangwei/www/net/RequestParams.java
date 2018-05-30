package com.yangwei.www.net;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ____ Bye丶 on 2017/3/23.
 */
public class RequestParams {
    private Map<String, Object> params;
    private Map<String, String> headers;
    //是否加密
    private boolean isEncrypt = true;
    //是否启用统一拦截（包括单点登录、token失效等）
    private boolean isIntercept = true;
    private int tag = -1;
    private String url;
    private String formName;  //form表单名称  上传文件用
    private HttpType httpType;
    private String contentType;
    private int connectTime = -1;

    public RequestParams(String url) {
        this.url = url;
        httpType = HttpType.POSTJSON;
        params = new TreeMap<>();
    }

    /***
     * 添加请求参数
     *
     * @param key
     * @param value
     * @return
     */
    public RequestParams add(String key, Object value) {
        if (TextUtils.isEmpty(key)) {
            return this;
        }
        params.put(key, value);
        return this;
    }

    /***
     * 添加header
     *
     * @param key
     * @param value
     * @return
     */
    public RequestParams addHeader(String key, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put(key, value);
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getTag() {
        return tag;
    }

    //设置Http请求类型
    public void setHttpType(HttpType httpType) {
        this.httpType = httpType;
    }

    //提取http请求类型
    public HttpType getHttpType() {
        return httpType;
    }

    /***
     * 设置请求唯一标识
     * @param tag
     */
    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }


    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(int connectTime) {
        this.connectTime = connectTime;
    }

    public void setIntercept(boolean intercept) {
        isIntercept = intercept;
    }

    public boolean isIntercept() {
        return isIntercept;
    }
}
