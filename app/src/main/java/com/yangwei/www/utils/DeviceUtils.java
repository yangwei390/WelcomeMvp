package com.yangwei.www.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

/**
 * 各种phone信息接口 例如 imei 手机型号，系统 ，分辨率等
 */
public class DeviceUtils {
    private static String imei;
    private static int verCode = -1;
    private static String channel;
    private static String ip;
    private static String mac;


    public static String getUniqueCode(Context context) {
        String uniqueCode = "";

        return uniqueCode;
    }

    /**
     * 获取手机IMEI
     */
    public static String getPhoneIMEI(Context context) {
        String imei = "";

        try {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            imei = tm.getDeviceId().trim();
        } catch (Exception e) {
            imei = "";
        }


        if (TextUtils.isEmpty(imei)) {
            imei = "";
        }

        return imei;
    }

    /**
     * 获取手机IMSI(国际移动用户识别码) for a GSM phone.
     */
    public static String getPhoneIMSI(Context context) {

        String imsiStr = null;
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        imsiStr = tm.getSubscriberId();

        if (TextUtils.isEmpty(imsiStr)) {
            imsiStr = "000000000000000";
        }
        return imsiStr;
    }

    /**
     * 获取手机 WLAN MAC
     */
    public static String getPhoneWLANMac(Context context) {
        if (!TextUtils.isEmpty(mac)) {
            return mac;
        }
        String macAddress = null;
        WifiManager wifiManager = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();

        macAddress = wifiInfo == null ? null : wifiInfo.getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            macAddress = "";
        }
        /*
         * if(macAddress!=null){ char[] str = macAddress.toCharArray(); int i=0;
		 * while(i<str.length) { if(str[i] == ':'){ i++; continue; }else{
		 *
		 * temp += str[i]; temp += str[i+1]; i += 2;} }
		 *
		 * L.d(temp); return temp; } else{ return null; }
		 */
        return macAddress;

    }

    /**
     * 获取手机唯一识别码
     */

//	public static String getPhoneUID(Context context) {
//		if (!TextUtils.isEmpty(imei)) {
//			return imei;
//		}
//		imei= ShareData.getShareStringData("imei");
//		if (!TextUtils.isEmpty(imei)) {
//			return imei;
//		}
//		UUID uuid = getUUID(context);
//		if (uuid!=null) {
//			imei=uuid.toString();
//		}else{
//			imei=UUID.randomUUID().toString();
//		}
//
//		ShareData.setShareStringData("imei",imei);
//
//		return imei;
//
//	}

    /***
     * 获取uuid，生成规则是优先androidid、其次deviceid，再次wifi mac地址，然后是uuid随机
     * @param context
     * @return
     */
    public static UUID getUUID(Context context) {
        UUID uuid = null;
        try {

            String androidid = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
            if (!TextUtils.isEmpty(androidid) && !"9774d56d682e549c".equals(androidid)) {
                uuid = UUID.nameUUIDFromBytes(androidid.getBytes("utf8"));
            } else {
                String deviceid = getPhoneIMEI(context);
                if (!TextUtils.isEmpty(deviceid) && !deviceid.matches("[0]+")) {
                    uuid = UUID.nameUUIDFromBytes(deviceid.getBytes("utf8"));
                } else {
//					uuid=UUID.randomUUID();
                    String WIFIMAC = getPhoneWLANMac(context);
                    if (!TextUtils.isEmpty(WIFIMAC)) {
                        uuid = UUID.nameUUIDFromBytes(WIFIMAC.getBytes("utf8"));
                    } else {
                        long currentMill = System.currentTimeMillis();
                        uuid = UUID.nameUUIDFromBytes(String.valueOf(currentMill).getBytes("utf8"));
                        //通过时间戳获取UUID
//						uuid=UUID.randomUUID();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            uuid = UUID.randomUUID();
        }
        return uuid;
    }

    /**
     * 获取当前程序版本数值
     *
     * @param context 上下文
     * @return 当前程序版本数值
     */
    public static int getCurrentAppVersionCode(Context context) {
        if (verCode != -1) {
            return verCode;
        }
        try {
            verCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verCode;
    }

    /**
     * 获取当前程序版本名
     *
     * @param context 上下文
     * @return 当前程序版本名
     */
    public static String getCurrentAppVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取当前程序渠道
     *
     * @param context 上下文
     * @return 当前程序渠道
     */
    public static String getChannel(Context context) {
        if (TextUtils.isEmpty(channel)) {
            channel = getMetaData(context, "SPI_CHANNEL");
            if (TextUtils.isEmpty(channel)) {
                channel = "SPI";
            }
        }
        return channel;

    }

    /***
     * 获取ip地址，只在启动获取一次
     *
     * @return
     */
    public static String getIp() {
        if (TextUtils.isEmpty(ip)) {
            ip = getLocalHostIp();
        }
        return ip;

    }

    /***
     * 获取本地ip
     *
     * @return
     */
    public static String getLocalHostIp() {
        String ipaddress = "";
        try {
            Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces();
            // 遍历所用的网络接口
            while (en.hasMoreElements()) {
                NetworkInterface nif = en.nextElement();
                // 得到每一个网络接口绑定的所有ip
                Enumeration<InetAddress> inet = nif.getInetAddresses();
                // 遍历每一个接口绑定的所有ip
                while (inet.hasMoreElements()) {
                    InetAddress ip = inet.nextElement();
                    if (!ip.isLoopbackAddress()) {
                        return ip.getHostAddress();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipaddress;

    }

    /***
     * 获取手机型号
     * @param context
     * @return
     */
    public static String getModel(Context context) {
        return Build.MODEL;
    }

    /***
     * 获取系统名称
     * @param context
     * @return
     */
    public static String getOS(Context context) {
        return Build.VERSION.RELEASE;
    }

    private static String getMetaData(Context context, String key) {
        try {
            ApplicationInfo ai = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            Object value = ai.metaData.get(key);
            if (value != null) {
                return value.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 获取DisplayMetrics(获取屏幕信息)
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        // 这个可以用于1.5
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, int dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, int pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取手机顶部状态栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        return statusBarHeight;
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getBrand() {
        return Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机系统版本
     *
     * @return
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 初始化经纬度
     *
     * @param context
     * @return
     */
//	public static void initGpsLocation(Context context) {
//		LocationManager lm = (LocationManager) context
//				.getSystemService(Context.LOCATION_SERVICE);
//		// 返回所有已知的位置提供者的名称列表，包括未获准访问或调用活动目前已停用的。
//		List<String> lp = lm.getAllProviders();
//		for (String item : lp) {
//			Log.i("8023", "可用位置服务：" + item);
//		}
//
//		Criteria criteria = new Criteria();
//		criteria.setCostAllowed(false); // 设置位置服务免费
//		criteria.setAccuracy(Criteria.ACCURACY_COARSE); // 设置水平位置精度
//		// getBestProvider 只有允许访问调用活动的位置供应商将被返回
//		String providerName = lm.getBestProvider(criteria, true);
//
//		Log.i("8023", "------位置服务：" + providerName);
//
//		if (providerName != null) {
//			Location location = lm.getLastKnownLocation(providerName);
//			Log.i("8023", "-------" + location);
//			if (location != null) {
//				// 获取维度信息
//				double latitude = location.getLatitude();
//				// 获取经度信息
//				double longitude = location.getLongitude();
//
//				// SPManager.saveString(context, "latitude",
//				// String.valueOf(latitude));
//				// SPManager.saveString(context, "longitude",
//				// String.valueOf(longitude));
//			}
//		}
//	}

    /**
     * 隐藏软键盘
     *
     * @param activity
     */
    public static void hideSoftInput(Activity activity) {
        try {
            if (activity == null || activity.getCurrentFocus() == null) {
                return;
            }
            IBinder binder = activity.getCurrentFocus().getWindowToken();
            if (binder == null) {
                return;
            }
            ((InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(binder,
                            InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 显示软键盘
     *
     * @param context
     * @param view
     */
    public static void showSoftInput(Context context, EditText view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.RESULT_UNCHANGED_SHOWN);

    }

}
