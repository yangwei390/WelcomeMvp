package com.yangwei.www.utils;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.text.TextUtils.isEmpty;

/**
 * 字符工具类
 * Created by yangwei on 2017/11/6.
 */

public class StringUtils {

    /***
     * 将url与请求数据拼接为字符串
     *
     * @param url
     * @param map
     * @return
     */
    public static String getQueryUrl(String url, Map<String, Object> map) {
        final StringBuilder result = new StringBuilder();
        if (map == null) {
            return url;
        }
        for (Map.Entry<String, Object> parameter : map.entrySet()) {
            try {
                final String encodedName = URLEncoder.encode(parameter.getKey(), "utf-8");
                final String encodedValue = URLEncoder.encode(parameter.getValue() + "", "utf-8");
                if (result.length() > 0) {
                    result.append("&");
                }
                result.append(encodedName);
                if (encodedValue != null) {
                    result.append("=");
                    result.append(encodedValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (isEmpty(result.toString())) {
            return url;
        }
        return url + "?" + result.toString();
    }

    /***
     * 将金额字符串转换为double
     *
     * @param price
     * @return
     */
    public static double getPrice(String price) {
        return getPrice(price, BigDecimal.ROUND_FLOOR);
    }

    /***
     * 将金额字符串转换为double
     *
     * @param price
     * @param mode
     *            取舍规则
     * @return
     */
    public static double getPrice(String price, int mode) {
        double account = 0;
        if (!isEmpty(price)) {
            try {
                BigDecimal bd = new BigDecimal(price);
                account = bd.setScale(2, mode).doubleValue();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        return account;
    }

    /**
     * 将价格字符串添加逗号分隔符
     *
     * @param str
     * @return
     */
    public static String getPriceText(String str) {
        return getPriceText("###,##0.00", str);
    }

    /***
     * 将价格字符串添加逗号分隔符
     *
     * @param format
     * @param str
     * @return
     */
    public static String getPriceText(String format, String str) {
        if ("".equals(str) || "null".equals(str) || str == null)
            return "";
        try {
            BigDecimal bd = new BigDecimal(str);
            double f1 = bd.setScale(2, BigDecimal.ROUND_FLOOR).doubleValue();
            DecimalFormat df = new DecimalFormat(format);
            String price = df.format(f1);
            return price;
        } catch (Exception e) {
            return "";
        }

    }

    /***
     * 获取清除小数点后末位为0的数字
     * @param price
     * @return
     */
    public static String getPriceWipeZero(String price) {
        return getPriceText("###,###.##", price);
    }

    public static String getUserName(String phone) {
        if (phone.length() == 11) {
            String str = phone.substring(3, 7);
            phone = phone.replace(str, "****");
            return phone;
        }
        return "";
    }

    /**
     * 验证email
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z_-]+[-|\\.]?)+[a-z0-9A-Z_-]@([a-z0-9A-Z_-]+(-[a-z0-9A-Z_-]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
    /**
     * 查询字符串中包含几个汉字
     * @param inStr
     * @return
     * @Author zhangxinchao
     */
    public static int chineseCharactersCount(String inStr) {
        int count = 0;
        if(isEmpty(inStr)){
            return count ;
        }
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(inStr);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                count = count + 1;
            }
        }
        return count ;
    }
}
