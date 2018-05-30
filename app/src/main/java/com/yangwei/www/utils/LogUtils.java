package com.yangwei.www.utils;


import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class LogUtils {

    //	public static boolean sIsLogEnabled = IConfig.isLog;// 是否打开LOG
    public static boolean sIsLogEnabled = true;// 是否打开LOG

    public static String TAG = "JY";// LOG默认TAG

    private static final String TAG_CONTENT_PRINT = "%s:%s.%s:%d";

    private static StackTraceElement getCurrentStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];

    }

    // 打印LOG
    public static void trace() {
        if (sIsLogEnabled) {
            Log.d(TAG,
                    getContent(getCurrentStackTraceElement()));
        }
    }

    // 获取LOG
    private static String getContent(StackTraceElement trace) {
        return String.format(TAG_CONTENT_PRINT, TAG,
                trace.getClassName(), trace.getMethodName(),
                trace.getLineNumber());
    }

    /**
     * 打印默认TAG的LOG
     */
    public static void traceStack() {
        if (sIsLogEnabled) {
            traceStack(TAG, Log.ERROR);
        }
    }

    /**
     * 打印Log当前调用栈信息
     */
    public static void traceStack(String tag, int priority) {

        if (sIsLogEnabled) {
            StackTraceElement[] stackTrace = Thread.currentThread()
                    .getStackTrace();
            Log.println(priority, tag, stackTrace[4].toString());
            StringBuilder str = new StringBuilder();
            String prevClass = null;
            for (int i = 5; i < stackTrace.length; i++) {
                String className = stackTrace[i].getFileName();
                int idx = className.indexOf(".java");
                if (idx >= 0) {
                    className = className.substring(0, idx);
                }
                if (prevClass == null || !prevClass.equals(className)) {

                    str.append(className.substring(0, idx));

                }
                prevClass = className;
                str.append(".").append(stackTrace[i].getMethodName())
                        .append(":").append(stackTrace[i].getLineNumber())
                        .append("->");
            }
            Log.println(priority, tag, str.toString());
        }
    }

    /**
     * 指定TAG和指定内容的方法
     */
    public static void d(String tag, String msg) {
        if (sIsLogEnabled) {
            Log.d(tag, getContent(getCurrentStackTraceElement()) + ">" + msg);
        }
    }

    /**
     * 默认TAG和制定内容的方法
     */
    public static void d(String msg) {
        if (sIsLogEnabled) {
            Log.d(TAG, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    // 下面的定义和上面方法相同，可以定义不同等级的Debugger

    public static void i(String tag, String msg) {
        if (sIsLogEnabled) {
            Log.i(tag, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void i(String msg) {
        if (sIsLogEnabled) {
            Log.i(TAG, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void w(String tag, String msg) {
        if (sIsLogEnabled) {
            Log.w(tag, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void w(String msg) {
        if (sIsLogEnabled) {
            Log.w(TAG, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (sIsLogEnabled) {
            Log.e(tag, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void e(String msg) {
        if (sIsLogEnabled) {
            Log.e(TAG, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void e(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        e(sw.toString());
    }


    public static void v(String tag, String msg) {
        if (sIsLogEnabled) {
            Log.v(tag, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    public static void v(String msg) {
        if (sIsLogEnabled) {
            Log.v(TAG, getContent(getCurrentStackTraceElement())
                    + ">" + msg);
        }
    }

    /**
     * @Description 替代默认的system.out.println
     */
    public static void sysPrintln(Object msg) {
        if (sIsLogEnabled) {
            System.out.println(getContent(getCurrentStackTraceElement()) + "->" + msg.toString());
        }
    }
}
