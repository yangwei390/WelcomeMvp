package com.yangwei.www.bean;

import java.io.Serializable;

/**
 * Created by yangwei on 2017/12/4.
 */

public class VersionBean implements Serializable {

    /**
     * appDownUrl : www.baidu.com
     * forceState : 1
     * newAppVersion : 1.0.0
     * versionContent : ceshi
     * versionName : 钱进贷
     */

    private String appDownUrl = "";
    private String forceState = "";
    private String newAppVersion = "";
    private String versionContent = "";
    private String versionName = "";

    public String getAppDownUrl() {
        return appDownUrl;
    }

    public void setAppDownUrl(String appDownUrl) {
        this.appDownUrl = appDownUrl;
    }

    public String getForceState() {
        return forceState;
    }

    public void setForceState(String forceState) {
        this.forceState = forceState;
    }

    public String getNewAppVersion() {
        return newAppVersion;
    }

    public void setNewAppVersion(String newAppVersion) {
        this.newAppVersion = newAppVersion;
    }

    public String getVersionContent() {
        return versionContent;
    }

    public void setVersionContent(String versionContent) {
        this.versionContent = versionContent;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
