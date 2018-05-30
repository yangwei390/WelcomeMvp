package com.yangwei.www.utils.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareData {

    private static final String SP_NAME = "ym";
    public static final String DEVICEID = "device_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_IDCARD = "user_idcard";
    public static final String USER_MOBILE = "user_mobile";
    public static final String USER_SEX = "user_sex";
    public static final String USER_AUTHSTATE = "user_authstate";
    public static final String USER_ACCOUNT_PWD_FLAG = "user_account_pwd_flag";
    public static final String USER_TOKEN = "user_token";
    public static final String USER_CUST_CODE = "user_cust_code";
    //手势密码
    public static final String GESTURE_PATTERN = "gesture_pattern";
    //手势密码是否打开
    public static final String GESTURE_IS_OPEN = "gesture_is_open";
    //手势密码错误次数
    public static final String GESTURE_ERROR_NUM = "gesture_error_num";
    //手势密码记录开启的时间
    public static final String GESTURE_TIME = "gesture_time";
    //上次登录的账号:用于判断是否清除手势密码
    public static final String LAST_ACCOUNT = "last_account";
    //是否开启过引导页
    public static final String IS_OPEN_GUIDE = "is_open_guide";
    //记录百融初始化后的gid
    public static final String BAIRONG_GID = "bairong_gid";


    private static SharedPreferences sp;

    public static void init(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
    }

    public static int getShareIntData(String key) {
        return sp.getInt(key, 0);
    }

    public static void setShareIntData(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    public static String getShareStringData(String key) {
        return sp.getString(key, "");
    }

    public static void setShareStringData(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    public static boolean getShareBooleanData(String key) {
        return sp.getBoolean(key, false);
    }

    public static void setShareBooleanData(String key, boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    public static float getShareFloatData(String key) {
        return sp.getFloat(key, 0f);
    }

    public static void setShareFloatData(String key, float value) {
        sp.edit().putFloat(key, value).commit();
    }

    public static long getShareLongData(String key) {
        return sp.getLong(key, 0l);
    }

    public static void setShareLongData(String key, long value) {
        sp.edit().putLong(key, value).commit();
    }

    public static void deleShareData(String key) {
        sp.edit().remove(key).commit();
    }

    public static void clearShareData() {
        sp.edit().clear().commit();
    }
}
