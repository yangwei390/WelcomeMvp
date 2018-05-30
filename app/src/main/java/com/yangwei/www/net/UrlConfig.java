package com.yangwei.www.net;


import com.yangwei.www.utils.ConfigUtils;

/**
 * URL配置
 * Created by yangwei on 2017/11/6.
 */
public interface UrlConfig {
    //测试(加密)
//    String IP = "https://app.cs.iqianjindai.com";
    //开发(不加密)
//    String IP = "https://app.dev.iqianjindai.com";
    //UAT(加密)
//    String IP = "https://app.uat.iqianjindai.com";
    //不加密测试
//    String IP = "http://39.106.22.109:8080";
    //吴金凤
//    String IP = "http://192.168.32.55:8080";
    //李怀彪
//    String IP = "http://192.168.32.234:8080";
    //陈伟丽
//    String IP = "http://192.168.33.202:8080";
    //陈一凡
//    String IP = "http://192.168.32.149:8080";
    //赵磊
//    String IP = "http://192.168.33.104:8080";
    //向泽兵
//    String IP = "http://192.168.0.3:8080";

    String IP = ConfigUtils.getIp();
    String H5IP = ConfigUtils.getH5Ip();
    //AES KEY
    String AES_SECRET = ConfigUtils.getAES();
    //bucket
    String BUCKET = ConfigUtils.getBucket();
    //endpoint
    String ENDPOINT = ConfigUtils.getEndPoint();

    String URL = IP + "/api";
    //百融cid
    String BAIRONG_CID = "3000875";

    //获取网络图片地址
    String IMAGE_URL = IP + "/banklogo";

    //帮助中心
    String H5_HELP_CENTER = IP + "/moneyCreditH5/moneyCreditHelp.html";
    //征信信息报告
    String H5_CREDIT_REPORT = IP + "/moneyCreditH5/moneyCreditCreditReport.html";
    //意见反馈
    String H5_FEEDBACK = IP + "/moneyCreditH5/moneyCreditSuggest.html";
    //贷前还款明细
    String H5_REPAY_DETAIL = IP + "/moneyCreditH5/moneyCreditRepaymentDetailsBefore.html";
    //签约前合同列表
    String H5_PROTOCAL_LIST = IP + "/moneyCreditH5/moneyCreditContractList.html";
    //签约后合同列表
    String H5_PROTOCAL_LIST_AFTER_SIGN = IP + "/moneyCreditH5/moneyCreditContractListAfter.html";
    //个人信息查询使用授权书
    String H5_PERSONAL_INFO_AUTHORIZATION = IP + "/moneyCreditH5/agreement/personalInfoInquiry.html";
    //委托扣款授权书
    String H5_ENTRUST_DEDUCT = IP + "/moneyCreditH5/agreement/entrustDeduct.html";
    //消息中心列表
    String H5_MESSAGE_CENTER_LIST = IP + "/moneyCreditH5/moneyCreditMsgCenter.html";
    //账单撤销原因
    String H5_ACCOUNT_REVOCATION_REASON = IP + "/moneyCreditH5/moneyCreditUndoReason.html";
    //贷后还款明细
    String H5_REPAYMENT_DETAIL_LIST = IP + "/moneyCreditH5/moneyCreditRepaymentDetailsAfter.html";
    //用户注册协议
    String H5_USER_REGISTER_PROTOCAL = IP + "/moneyCreditH5/agreement/userRegistration.html";
    //新手引导
    String H5_NOVICE_GUIDE = IP + "/moneyCreditH5/activity/guidebook/index.html";
    //淘宝H5授权成功
    String H5_TAOBAO_AUTHORIZANTION = H5IP + "/activity/index.html#/authorization";

    //注册
    String URL_REGISTER = URL + "/appUser/appRegister/v1/";
    //登录
    String URL_LOGIN = URL + "/appUser/appLogin/v1/";
    //请求上传图片权限
    String URL_REQUEST_OSS_PERMISSION = URL + "/provisionalAuthority/getOssToken/v1/";
    //ocr+实名认证
    String URL_OCR_AND_REALNAME = URL + "/realName/getIdCardInfo/v1/";
    //首页获取是否可以申请借款
    String URL_QUERY_INDEX_INTO_INFO = URL + "/appBefLoan/queryIndexIntoInfo/v1/";
    //获取产品信息
    String URL_QUERY_PRODUCT = URL + "/appProduct/queryProduct/v1/";
    //生成进件信息
    String URL_CREATE_INTO_CODE = URL + "/appBefLoan/createIntoCode/v1/";
    //活体有缘对比
    String URL_FACE_RECOGNITION = URL + "/activeContrast/getIVerifyInfo/v1/";
    //信用卡创建任务
    String URL_CREDIT_CREATE_TASK = URL + "/into/credit/createTask";
    //获取开户行
    String URL_OPEN_BANK = URL + "/appDebitCard/selectBank/v1";
    //提交基本信息
    String URL_PERFECT_USER_INFO = URL + "/appBefLoan/perfectIntoUserBase/v1/";
    //绑卡获取验证码
    String URL_AUTH_CODE = URL + "/appDebitCard/authCode/v1";
    //手机详单提交
    String URL_PHONE_DETAIL = URL + "/into/appMobileCert/v1/";
    //进件信用卡选择
    String URL_CREDIT_SELECT_BAND = URL + "/into/credit/selectBank";
    //征信验证
    String URL_CREDIT_REPORT = URL + "/into/appPbccProving/v1/";
    //我的银行卡
    String URL_MY_BANK_CARD = URL + "/appDebitCard/bankCardList/v1";
    //保存用户通讯录
    String URL_SAVE_PHONE_CONTRACTS = URL + "/appDevice/saveAddressBooks/v1/";
    //保存用户短信
    String URL_SAVE_PHONE_MESSAGE = URL + "/appDevice/saveShortMessages/v1/";
    //保存用户通话记录
    String URL_SAVE_PHONE_TELL_RECORDS = URL + "/appDevice/saveCallRecords/v1/";
    //获取字典码表
    String URL_OBTAIN_DICTIONAL = URL + "/appbefLoan/dataDictionary/v1/";
    //注册获取验证码
    String URL_SIGN_IN_CODE = URL + "/appUser/appSMCode/v1/";
    //账单
    String URL_BILL = URL + "/appLoan/loanOrderList/v1";
    //撤销申请原因
    String URL_CANCEL_CONTRACT_CAUSE = URL + "/appLoan/enum/v1";
    //提交撤销申请原因
    String URL_SUBMIT_CANCEL_CONTRACT_CAUSE = URL + "/appLoan/cancelLoan/v1";
    //签约信息查询(签约页面数据)
    String URL_QUERY_SIGNING_INFO = URL + "/appLoanSign/signQuery";
    //签约-放款
    String URL_SIGN_COMMIT = URL + "/appLoanSign/signCommit";
    //查询审批结果
    String URL_GET_APPLY_RESULT = URL + "/appBefLoan/queryApproveAmount/v1/";
    //审批暂时拒绝倒计时
    String URL_GET_REJECTION_TIME = URL + "/appBefLoan/queryTempRefuseTime/v1/";
    //确认绑卡
    String URL_CONFIRM_BINDING_CARD = URL + "/appDebitCard/confirmBinding/v1";
    //获取还款详情
    String URL_OBTAIN_BACK_DETAIL = URL + "/appUser/recharge/repayPageInfo/v1";
    //获取还款验证码
    String URL_OBTAIN_BACK_CODE = URL + "/appUser/recharge/preRecharge/v1";
    //还款提交
    String URL_BACK_SUBMIT = URL + "/appUser/recharge/confirmRecharge/v1";
    //忘记密码
    String URL_FORGET_PASSWORD = URL + "/appUser/appForgetPwd/v1/";
    //保存地理信息
    String URL_SAVE_ADDRESS = URL + "/appDevice/saveMobileAddress/v1/";
    //保存手机信息
    String URL_SAVE_PHONE_INFO = URL + "/appDevice/saveMobileInformation/v1/";
    //我的页面
    String URL_MINE_INFO = URL + "/appDebitCard/myPageInfo/v1";
    //修改用户密码
    String URL_MEND_PASSWORD = URL + "/appUser/appModifyPwd/v1/";
    //获取提现信息
    String URL_WITHDRAW_INFO = URL + "/appUser/withdraw/withdrawCashInfo/v1";
    //提现
    String URL_WITHDRAW = URL + "/appUser/withdraw/withdrawCash/v1";
    //退出登录
    String URL_LOGIN_OUT = URL + "/appUser/appExit/v1/";
    //设置默认银行卡
    String URL_UPDATE_DEFAULT_CARD = URL + "/appDebitCard/updDefaultCard/v1";
    //查询用户信息
    String URL_QUERY_USER_INFO = URL + "/appUser/queryUserInfo/v1/";
    //设置提现密码
    String URL_SET_WITHDRAW_PWN = URL + "/appUser/initAccountPwd/v1/";
    //重置提现密码
    String URL_RESET_WITHDRAW_PWD = URL + "/appUser/resetAccountPwd/v1/";
    //修改保存用户邮箱
    String URL_SAVE_EMAIL = URL + "/appUser/updateEmailByIntoCode/v1/";
    //获取跑批时间接口
    String URL_GET_DEAL_INFO_RESULT = URL + "/appUser/recharge/dealInfoResult/v1";
    //版本更新接口
    String URL_GET_NEW_VERSION = URL + "/appVersion/goUpAppVersion/v1/";
    //TalkingData侦测欺诈请求返回详情
    String URL_TALKING_DATA = URL + "/fraudDetection/getTalkingDate/v1/";
    //同盾
    String URL_TONGDUN = URL + "/Tdrc/getTdrc/v1/";
    //百融
    String URL_BAIRONG = URL + "/BrRule/getBrRule/v1/";
    //获取新消息
    String URL_GET_NOTICE = URL + "/appUser/querySys/v1/";
    //邮箱扒取从本地服务器获取初始化信息
    String URL_GET_MAIL_INITALIZATION = URL + "/into/credit/getAuthorization";
    //邮箱扒取告知本地服务器客户端已成功并等待接口返回服务器是否成功
    String URL_GET_MAIL_SUCCESS = URL + "/into/credit/queryEmailStatus";
    //公信宝征信获取Token
    String URL_GET_GXB_TOKEN = URL + "/gongxinbao/getToken/v1";
    //获取魔蝎最终结果
    String URL_GET_MX_FINALY_RESULT = URL + "/appBefLoan/queryCreditStatus/v1/";
    //获取征信通道：魔蝎或人行
    String URL_GET_CREDIT_CHANNEL = URL + "/appBefLoan/queryCreditChannel/v1/";
    //获取签约页面短信验证码接口(协议支付银行卡预绑定)
    String URL_GET_AGREEMENT_PRETIED_CARD_CODE = URL + "/appLoanSign/agreementPreTiedCard/v1";
    //提交签约页面短信验证码接口(协议支付银行卡确认绑定)
    String URL_GET_AGREEMENT_TIED_CARD_CODE = URL + "/appLoanSign/agreementTiedCard/v1";
    //绑卡页面卡bin识别匹配银行
    String URL_SEARCH_BANK_BY_BANK_CARD_NO = URL + "/appDebitCard/searchBankByBankCardNo/v1";
    //征信类型选择页面埋点
    String URL_CREDIT_MONITOR = URL + "/monitor/creditMonitor/v1";
    //取消进件接口
    String URL_CANCEL_INTO = URL + "/appBefLoan/cancelIntoByIntoCode/v1";
    //获取贷超地址
    String URL_GET_LOAN_MARKET = URL + "/sys/getSystemUrl/v1";

}
