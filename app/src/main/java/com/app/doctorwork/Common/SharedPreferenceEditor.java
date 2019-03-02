package com.app.doctorwork.Common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class SharedPreferenceEditor {

    /**
     * This method is used to check the key exist in shared preferences
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     */
    public static boolean hasPreferences(Context context, String prefrenceFile, String key) {
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);
        return appSharedPrefs.contains(key);

    }

    /**
     * This method is used to set shared preferences
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @param value         shared object value
     */
    public static void setPreferences(Context context, String prefrenceFile, String key, String value) {
        //SharedPreferences  appSharedPrefs = new ObscuredSharedPreferences(context, context.getSharedPreferences(prefrenceFile, 0));
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    /**
     * This method is used to set shared preferences
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @param value         shared object value
     */
    public static void setPreferences(Context context, String prefrenceFile, String key, int value) {
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }

    /**
     * This method is used to set shared preferences
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @param value         shared object value
     */
    public static void setPreferences(Context context, String prefrenceFile, String key, long value) {
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        prefsEditor.putLong(key, value);
        prefsEditor.apply();
    }

    /**
     * This method is used to set shared preferences
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @param value         shared object value
     */
    public static void setPreferences(Context context, String prefrenceFile, String key, boolean value) {
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    /**
     * This method is used to get shared object
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @return return value, for default empty returned .
     */
    public static String getPreferences(Context context, String prefrenceFile, String key) {

        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);

        String json = appSharedPrefs.getString(key, "");
        if (TextUtils.isEmpty(json)) {
            return "";
        }
        return json;
    }


    /**
     * This method is used to get shared object
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @param defaultValue  default int return value if not found
     * @return return value, for default @param defaultValue asign.
     */
    public static int getIntPreferences(Context context, String prefrenceFile, String key, int defaultValue) {

        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);

        int json = appSharedPrefs.getInt(key, defaultValue);

        return json;
    }

    /**
     * This method is used to get shared object
     *
     * @param context       Application context
     * @param prefrenceFile prefernce file
     * @param key           shared object key
     * @param defaultValue  default long return value if not found
     * @return return value, for default @param defaultValue asign.
     */
    public static long getLongPreferences(Context context, String prefrenceFile, String key, long defaultValue) {
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);
        long json = appSharedPrefs.getLong(key, defaultValue);
        return json;
    }

    public static boolean getPreferences(Context context, String prefrenceFile, String key, boolean defaultValue) {

        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);

        boolean json = appSharedPrefs.getBoolean(key, defaultValue);

        return json;
    }

    public static String getPreferences(Context context, String prefrenceFile, String key, String defaultValue) {

        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);

        String json = appSharedPrefs.getString(key, defaultValue);

        return json;
    }

    /*public static String getPrefrencesUserName(Context context, String prefrenceFile, String key){
        SharedPreferences appSharedPrefs = context.getSharedPreferences(prefrenceFile, 0);

        String json = appSharedPrefs.getString(key, "");
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        return json;
    }*/

    public static void clearPreferences(Context context, String preferencesFile) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferencesFile, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

