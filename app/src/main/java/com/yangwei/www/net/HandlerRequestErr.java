package com.yangwei.www.net;

import android.text.TextUtils;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.BaseFragment;
import com.yangwei.www.base.IBaseView;


/***
 * 网络请求返回信息处理
 */
public class HandlerRequestErr {
    /***
     * 判断网络请求是否成功及错误处理，错误信息会提示
     *
     * @param iBaseView
     * @param data
     * @return code为200或0000返回true，否则返回false
     */
    public static boolean handlerRequestErr(IBaseView iBaseView, ResultData data) {
        return handlerRequestErr(iBaseView, data, true);
    }

    /***
     * 判断网络请求是否成功及错误处理
     *
     * @param iBaseView
     * @param data
     * @param isTips
     *            是否提示错误信息
     * @return code为200或0000返回true，否则返回false
     */
    public static boolean handlerRequestErr(IBaseView iBaseView, ResultData data, boolean isTips) {
        String rspCode = data.getRspCode();
        String rspMsg = data.getRspMsg();
        if (ErrorCode.SUCCESS.equals(rspCode)) {
            return true;
        }
        if (ErrorCode.ERROR_LOGIN_AGAIN.equals(rspCode)) {
            if (iBaseView instanceof BaseActivity) {
                ((BaseActivity) iBaseView).showLoginErrDialog();
            } else if (iBaseView instanceof BaseFragment) {
                ((BaseFragment) iBaseView).showLoginErrDialog();
            }
            return false;
        }
        if (iBaseView == null || !isTips) {
            return false;
        }
        if (iBaseView instanceof BaseActivity) {
            ((BaseActivity) iBaseView).toast(TextUtils.isEmpty(rspMsg) ? getLocalErrMsg(rspCode) : rspMsg);
        } else if (iBaseView instanceof BaseFragment) {
            ((BaseFragment) iBaseView).toast(TextUtils.isEmpty(rspMsg) ? getLocalErrMsg(rspCode) : rspMsg);
        }
        return false;
    }

    /***
     * 获取常规网络错误提示
     *
     * @param state
     * @return
     */
    public static String getLocalErrMsg(String state) {
        String msg = "";
        if (ErrorCode.SOCKET_TIME_OUT.equals(state)) {
            msg = "服务器响应超时";
        } else if (ErrorCode.CONNECT_ERR.equals(state)) {
            msg = "服务器连接失败";
        } else {
            msg = "数据请求失败，请稍后重试";
        }
        return msg;
    }
}
