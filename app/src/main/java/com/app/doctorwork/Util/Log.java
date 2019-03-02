package com.app.doctorwork.Util;

/**
 * Created by abhisheksingh on 11/15/17.
 */
public class Log {
    private static final boolean LOG = false;
    private static boolean CHROME_STHETHO_LOG_ENABLED = false;

    public static boolean isChromeSthethoLogEnabled() {
        return CHROME_STHETHO_LOG_ENABLED;
    }

    public static boolean isLogEnabled() {
        return LOG;
    }

    public static void i(String tag, String string) {
        if (LOG) {
            if (string != null) android.util.Log.i(tag, string);
            else android.util.Log.i(tag, "null");
        }
    }

    public static void e(String tag, String string) {
        if (LOG) {
            if (string != null) android.util.Log.e(tag, string);
            else android.util.Log.e(tag, "null");
        }
    }

    public static void d(String tag, String string) {
        if (LOG) {
            if (string != null) android.util.Log.d(tag, string);
            else android.util.Log.d(tag, "null");
        }
    }

    public static void v(String tag, String string) {
        if (LOG) {
            if (string != null) android.util.Log.v(tag, string);
            else android.util.Log.v(tag, "null");
        }
    }

    public static void w(String tag, String string) {
        if (LOG) {
            if (string != null) android.util.Log.w(tag, string);
            else android.util.Log.w(tag, "null");
        }
    }

}
