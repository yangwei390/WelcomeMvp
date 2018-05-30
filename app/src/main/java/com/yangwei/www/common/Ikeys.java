package com.yangwei.www.common;

/**
 * Created by yangwei on 2017/11/3.
 */
public interface Ikeys {
    String KEY_DATA = "data";
    String KEY_WEB_URL = "key_web_url";//H5 URL
    String KEY_WEB_JSON = "key_web_json";//H5 需要的Json参数
    String KEY_TOPBAR_TITLE = "key_topbar_title";//Topbar title
    String KEY_INTO_STEP_INDEX = "key_into_step_index";//跳转进件步骤
    String KEY_INTO_CODE = "key_into_code";//进件编号
    String KEY_INTO_STATUS = "key_into_status";//进件状态
    String KEY_CALCULATE_STOP_TIME = "key_calculate_stop_time";//试算页面停留时间
    String KEY_LOAN_TERM = "key_loan_term";//试算时选择的贷款期限
    String KEY_LOAN_AMOUNT = "key_loan_amount";//试算时选择的贷款金额
    String KEY_PRODUCT_CODE = "key_product_code";//产品编码
    String KEY_GESTURE_TYPE = "key_gesture_type";//操作手势类型
    String KEY_LOGIN_CAN_BACK = "key_login_can_back";//登录页是否允许返回
    String KEY_TO_MY_REPAYMENT_CONTACTS_NO_CODE = "key_to_my_repayment_contract_noc_code";//跳转还款明细然后去到我要还款的合同编号，就不再webview交互了
    String KEY_TO_BIND_BANK_CARD_FLAG = "key_to_bind_bank_card_flag";//跳转绑定银行卡页面标识  0-进件,1-我的页面,2-我的银行卡
    String KEY_TO_REAL_NAME_FLAG = "key_to_real_name_flag";//跳转实名认证页面标识 0-进件,1-我的页面,2-提现
    String KEY_FACE_DELTA = "key_face_delta";//face++delta
    String KEY_BEST_IMG_URL = "key_best_img_url";//face++最佳图片url
    String KEY_ENV_IMG_URL = "key_env_img_url";//face++环境图片url
    String KEY_ACTION1_IMG_URL = "key_action1_img_url";//face++动作1图片url
    String KEY_ACTION2_IMG_URL = "key_action2_img_url";//face++动作2图片url
    String KEY_ACTION3_IMG_URL = "key_action3_img_url";//face++动作3图片url
    String KEY_PDF_PATH = "key_pdf_path";//合同pdf本地保存路径
    String KEY_PDF_NAME = "key_pdf_name";//合同pdf名称
    String KEY_TO_RESULT_PAGE = "key_to_result_page";//跳转结果页标识
    String KEY_VERSION = "key_version";//版本升级bean
    String KEY_TO_MY_BANK_CARD_LIST = "key_to_my_bank_card_list";//跳转到我的银行卡列表标识
    String KEY_SELECTED_BANK_CARD = "key_selected_bank_card";//选中银行卡返回提现页
    String KEY_NOTICE_DETAIL = "key_notice_detail";//公告详情
}
