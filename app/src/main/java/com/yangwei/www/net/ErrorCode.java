package com.yangwei.www.net;

/**
 * Created by ____ Bye丶 on 2017/3/22.
 */
public class ErrorCode {

    /**
     * 成功
     **/
    public static final String SUCCESS = "000000";
    /**
     * 解析错误
     **/
    public static final String JSON_ERR = "-101";
    /**
     * 服务器响应超时
     **/
    public static final String SOCKET_TIME_OUT = "-103";
    /**
     * 网络连接失败
     **/
    public static final String CONNECT_ERR = "-104";
    /**
     * 主机解析失败
     **/
    public static final String UNKNOW_HOST_ERR = "-105";
    /**
     * 系统繁忙、未知错误
     **/
    public static final String SYSTEM_ERR = "-106";
    /**
     * 重新登录
     **/
    public static final String ERROR_LOGIN_AGAIN = "-999999";

}

