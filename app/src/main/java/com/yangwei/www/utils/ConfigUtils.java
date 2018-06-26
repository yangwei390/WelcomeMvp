package com.yangwei.www.utils;

/**
 * 配置文件类
 * Created by yangwei on 2017/11/30.
 */
public class ConfigUtils {
    public static final ConfigType configType = ConfigType.CS;

    public static String getIp() {
        switch (configType) {
            case DEV:
                return "https://app.dev.iqianjindai.com";
            case CS:
//                return "http://192.168.31.144:8082";//陈伟丽
                return "http://192.168.192.3:8082";
//                return "http://192.168.193.3:84";//存管存量用户
//                return "https://app.cs.iqianjindai.com";
            case UAT:
                return "https://app.uat.iqianjindai.com";
            case RELEASE:
                return "https://app.iqianjindai.com";
        }
        return "";
    }

    public static String getH5Ip() {
        switch (configType) {
            case DEV:
                return "http://wwd.dev.iqianjindai.com";
            case CS:
            case UAT:
                return "http://wwd.cs.iqianjindai.com";
            case RELEASE:
                return "http://wwd.iqianjindai.com";
        }
        return "";
    }

    public static String getAES() {
        switch (configType) {
            case DEV:
            case CS:
                return "0123456789123456";
            case UAT:
            case RELEASE:
                return "UATDF@!#2017caln";
        }
        return "";
    }

    public static String getBucket() {
        switch (configType) {
            case DEV:
            case CS:
                return "iqianjindai";
            case UAT:
            case RELEASE:
                return "iqianjindai-prod";
        }
        return "";
    }

    public static String getEndPoint() {
        switch (configType) {
            case DEV:
            case CS:
                return "http://oss-cn-beijing.aliyuncs.com";
            case UAT:
            case RELEASE:
                return "http://resource.iqianjindai.com";
        }
        return "";
    }

    public static boolean getIsEncrypt() {
        switch (configType) {
            case DEV:
                return false;
            case CS:
            case UAT:
            case RELEASE:
                return true;
        }
        return true;
    }

    public enum ConfigType {
        DEV, CS, UAT, RELEASE
    }
}
