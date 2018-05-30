package com.yangwei.www.net;

/**
 * 网络请求任务ID
 * Created by yangwei on 2017/11/6.
 */

public interface Task {

    //注册
    int REGISTER = 0X0000;
    //登录
    int LOGIN = 0X0001;
    //请求上传图片权限
    int REQEUST_OSS_PREMISSION = 0X2000;
    //orc+实名认证
    int ORC_AND_REALNAME = 0X2001;
    //首页获取是否可以申请借款
    int QUERY_INDEX_INTO_INFO = 0X2001;
    //获取产品信息
    int QUERY_PRODUCT_INFO = 0X2002;
    //获取信用卡登录银行信息
    int CREDIT_SELECT_BANK_INFO = 0X2003;
    //生成进件信息
    int CREATE_INTO_CODE = 0X2004;
    //活体有缘对比
    int FACE_RECOGNITION = 0X2005;
    //我的银行卡
    int MY_BANK_CARD = 0X2006;
    //信用卡创建任务
    int CREDIT_CREATE_TASK = 0X2007;
    //确认绑卡
    int CONFIRM_BINDING_CARD = 0X2008;
    //签约信息查询
    int QUERY_SIGNING_INFO = 0X2009;
    //活体后生成进件信息
    int CREATE_INTO_CODE_AFTER_LIVE = 0X2010;
    //签约-放款
    int SIGN_COMMIT = 0X2011;
    //设置默认卡
    int UPDATE_DEFAULT_CARD = 0X2012;
    //设置提现密码
    int SET_WITHDRAW_PWD = 0X2013;
    //获取跑批时间
    int GET_DEAL_INFO_RESULT = 0X2014;
    //获取银行卡信息
    int QUERY_BANK_INFO = 0X0001;
    //提交基本信息
    int QUERY_BASIC_PERSON_INFO = 0X0002;
    //绑卡获取验证码
    int QUERY_BANK_CODE = 0X0003;
    //手机详单提交
    int PHONE_DETAIL = 0X1000;
    //征信报告提交
    int CREDIT_REPORT = 0X1001;
    //基本信息获取字典
    int QUERY_BASIC_INFO_DICTIONAL = 0X0004;
    //查询审批结果
    int APPLY_RESULR = 0X1002;
    //审批暂时拒绝时间
    int REJECTION_TIME = 0X1003;
    //注册
    int SIGN_UP = 0X0005;
    //注册获取验证码
    int SIGN_UP_CODE = 0X0006;
    //账单
    int BILL = 0X0007;
    //撤销原因申请
    int CANCEL_CONTRACT_CAUSE = 0X0008;
    //提交撤销原因申请
    int SUBMIT_CANCEL_CONTRACT_CAUSE = 0X0009;
    //还款—详情
    int BACK_DETAIL = 0X0011;
    //还款—获取验证码
    int BACK_DETAIL_CODE = 0X0012;
    //还款—提交还款详情
    int BACK_SUBMIT_DETAIL = 0X0013;
    //忘记密码
    int FORGET_PASSWORD = 0X0014;
    //保存地址信息
    int SAVE_ADRESS = 0X0015;
    //保存手机信息
    int SAVE_APHONE = 0X0016;
    //我的页面
    int MINE_INFO = 0X1004;
    //修改用户密码
    int MEND_PASSWORD = 0X0017;
    //获取提现信息
    int WITHDRAW_INFO = 0X1005;
    //提现发起
    int WITHDRAW = 0X1006;
    //退出登录
    int LOGIN_OUT = 0X1007;
    //查询用户信息
    int QUERY_USER_INFO = 0X1008;
    //重置提现密码
    int RESET_WITHDRAW_PWD = 0X1009;
    //保存用户邮箱
    int SAVE_USER_EMAIL = 0X100A;
    //版本更新
    int NEW_VERSION = 0X100B;
    //获取新消息
    int GET_NOTICE = 0X100C;
    //获取扒取邮箱的初始化数据
    int GET_MAIL_INIT_DATA = 0X100D;
    //获取本地服务器邮箱扒取的结果
    int GET_MAIL_RESULT = 0X100E;
    //获取公信宝Token
    int GET_GXB_TOKEN = 0X0018;
    //获取公信宝-淘宝授权是否打开的开关
    int GET_GXB_TB_SWITCH = 0X0019;
    //获取魔蝎最终结果
    int GET_MX_FINALY_RESULT = 0X001A;
    //获取征信的通道 人行或是魔蝎
    int GET_CREDIT_CHANNEL = 0X001B;
    //签约页面获取验证码（协议支付银行卡预绑定）
    int GET_SIGN_CODE = 0X001C;
    //签约页面确定验证码（协议支付银行卡预绑定）
    int CONFIRM_SIGN_CODE = 0X001D;
    //绑卡页面通过卡号调取卡bin
    int SEARCH_BANK_BY_BANK_CARD_NO = 0X001E;
    //征信选择页面埋点
    int URL_CREDIT_MONITOR = 0X001F;
    //取消进件
    int CANCEL_INTO = 0X100F;
    //获取贷超地址
    int GET_LOAN_MARKET = 0X1010;
}
