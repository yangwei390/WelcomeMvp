package com.yangwei.www.net;

import java.io.Serializable;

/**
 * Created by ____ Bye丶 on 2017/3/23.
 */
public class ResultData implements Serializable {
    private String rspCode = "";
    private String rspMsg = "";
    private String rspTime = "";
    private Object body;

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public String getRspTime() {
        return rspTime;
    }

    public void setRspTime(String rspTime) {
        this.rspTime = rspTime;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
