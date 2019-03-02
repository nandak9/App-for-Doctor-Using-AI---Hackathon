package com.app.doctorwork.Util;

/**
 * Created by abhisheksingh on 11/24/17.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;


import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.SharedPreferenceEditor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkUtil {
    public static final int NETWORK_STATUS_NOT_CONNECTED = 0, NETWORK_STAUS_WIFI = 1, NETWORK_STATUS_MOBILE = 2;
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static boolean getProxyDetails(Context context) {

        String proxyAddress;
        String proxyPort;
        boolean isProxyCheck = true;
        SharedPreferences settings = context.getSharedPreferences("prefs", 0);
        if (settings.getBoolean("hackTestActive", false)) {
            isProxyCheck = settings.getBoolean("switchProxy", true);
        }
        if (isProxyCheck) {
            try {
                proxyAddress = System.getProperty("http.proxyHost");
                proxyPort = System.getProperty("http.proxyPort");
                Log.e("proxy", proxyAddress);
                Log.e("proxy", proxyPort);
                if (proxyAddress == null || proxyPort == null) {
                    Log.e("proxy", "proxy settings null");
                    return false;
                } else {

                    if (validateIP(proxyAddress)) {

                        Log.e("proxy", "proxy settings matched ");
                        return true;
                    } else {
                        Log.e("proxy", "proxy settings not  matched");
                        return false;
                    }
                }
            } catch (Exception e) {
                Log.e("Proxy", e.toString());
                //Crashlytics.logException(e);
                return true;
            }
        } else {
            Log.e("proxy", "Skipping proxy check ");
            return false;
        }
    }

    public static boolean validateIP(String ip) {
        String IPADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static String getNetworkClass(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null || !info.isConnected())
            return "-"; //not connected
        if (info.getType() == ConnectivityManager.TYPE_WIFI)
            return "WiFi";
        if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int networkType = info.getSubtype();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    return "2G-GPRS";
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    return "2G-EDGE";
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    return "2G-CDMA";
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    return "2G-RTT";
                case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                    return "2G-IDEN";
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    return "3G-UMTS";
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    return "3G-EVDO-0";
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    return "3G-EVDO-A";
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return "3G-HSDPA";
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    return "3G-HSUPA";
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    return "3G-HSPA";
                case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                    return "3G-EVDO-B";
                case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
                    return "3G-EHRPD";
                case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
                    return "3G-HSPAP";
                case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
                    return "4G-LTE";
                default:
                    return "*";
            }
        }
        return "#";
    }

    public static void triggerNoNetwork(final Context context, boolean proxy) {
        SharedPreferenceEditor.setPreferences(context, AppConstants.PREFERENCES_USER, "noNetwork", true);

        /*Intent intent = new Intent(context, NoNetwork.class);
        intent.putExtra("proxyDetected", proxy);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);*/
    }

    public static boolean hasActiveInternetConnection(Context context) {
        if (getConnectivityStatus(context) != TYPE_NOT_CONNECTED) {
            try {
                /*Network network = new Network(((ApplicationSingleton) context.getApplicationContext()).getCurrentActiveActivity());
                int status = -1;
                String Url = HostUrlLoader.getHostUrl(context) + FeedReaderContract.FeedEntry.API_MYPOOLIN_FAILPROOF;
                HashMap<String, ResponseData> response = network.makeRequest(Url, FeedReaderContract.FeedEntry.KEY_REQUEST_TYPE_GET, null, null);
                if (response != null) {
                    status = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getStatuscode();
                } else {
                    response = network.makeRequest(FeedReaderContract.FeedEntry.API_GOOGLE, FeedReaderContract.FeedEntry.KEY_REQUEST_TYPE_GET, null, null);
                    status = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getStatuscode();*/
                /*//for ip-api.com/json
                if (status == 200) {
                    if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject() != null) {
                        JSONObject data = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject();

                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_AS)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_AS, data.getString("as"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_CITY)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_CITY, data.getString("city"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_COUNTRY)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_COUNTRY, data.getString("country"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_COUNTRYCODE)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_COUNTRYCODE, data.getString("countryCode"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_ISP)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_ISP, data.getString("isp"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_LAT)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_LAT, data.getString("lat"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_LON)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_LON, data.getString("lon"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_ORG)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_ORG, data.getString("org"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_QUERY)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_QUERY, data.getString("query"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_REGION)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_REGION, data.getString("region"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_REGIONNAME)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_REGIONNAME, data.getString("regionName"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_STATUS)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_STATUS, data.getString("status"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_TIMEZONE)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_TIMEZONE, data.getString("timezone"));
                        }
                        if (response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getJsonObject().has(FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_ZIP)) {
                            SharedPrefrencesEditor.setPreferences(context, FeedReaderContract.FeedEntry.PREFRENCES_EXTRA, FeedReaderContract.FeedEntry.KEY_PREFERENCES_EXTRAS_ZIP, data.getString("zip"));
                        }
                    }

                *//*DUMMY DATA
                {
  "as": "AS10029 CITYCOM NETWORKS PVT LTD",
  "city": "Gurgaon",
  "country": "India",
  "countryCode": "IN",
  "isp": "Citycom Networks Pvt",
  "lat": 28.4667,
  "lon": 77.0333,
  "org": "Citycom Networks Pvt",
  "query": "180.151.83.98",
  "region": "HR",
  "regionName": "Haryana",
  "status": "success",
  "timezone": "Asia/Kolkata",
  "zip": "122001"
}*//*
                }*/
             /*   }

                return status != -1;*/
                return getConnectivityStatus(context) != TYPE_NOT_CONNECTED;
            } catch (Exception e) {
                Log.e("Mypoolin Networkutil", "Error checking internet connection " + e);
            }
        } else {
            Log.d("kisanx", "No network available!");
        }
        return false;
    }

/*    public static boolean hasActiveConnection(Context context) {
        int status = -1;
        try {
            if (getConnectivityStatus(context) != TYPE_NOT_CONNECTED) {
                Network network = new Network(((ApplicationSingleton) context.getApplicationContext()).getCurrentActiveActivity());

                String Url = HostUrlLoader.getHostUrl(context) + FeedReaderContract.FeedEntry.API_MYPOOLIN_FAILPROOF;
                HashMap<String, ResponseData> response = network.makeRequest(Url, FeedReaderContract.FeedEntry.KEY_REQUEST_TYPE_GET, null, null);

                if (response != null) {
                    status = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getStatuscode();
                }*//*else {
                    response = network.makeRequest(FeedReaderContract.FeedEntry.API_GOOGLE, FeedReaderContract.FeedEntry.KEY_REQUEST_TYPE_GET, null, null);
                    status = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getStatuscode();
                }*//*
            } else {
                Log.d("mypoolin", "No network available!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return status != -1;
        } catch (JSONException e) {
            e.printStackTrace();
            return status != -1;
        }
        return status != -1;
    }

    public static int getConnectivityStatusString(Context context) {
        int conn = NetworkUtil.getConnectivityStatus(context);
        int status = 0;
        if (conn == NetworkUtil.TYPE_WIFI) {
            status = NETWORK_STAUS_WIFI;
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            status = NETWORK_STATUS_MOBILE;
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            status = NETWORK_STATUS_NOT_CONNECTED;
        }
        return status;
    }

    public static boolean isServerReachable(Context context) {

        if (getConnectivityStatus(context) != TYPE_NOT_CONNECTED) {
            try {
                Network network = new Network(context);
                int status = -1;
                String Url = HostUrlLoader.getHostUrl(context) + FeedReaderContract.FeedEntry.API_MYPOOLIN_FAILPROOF;
                HashMap<String, ResponseData> response = network.makeRequest(Url, FeedReaderContract.FeedEntry.KEY_REQUEST_TYPE_GET, null, null);


                if (response != null) {
                    status = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getStatuscode();

                } else {
                    response = network.makeRequest(FeedReaderContract.FeedEntry.API_GOOGLE, FeedReaderContract.FeedEntry.KEY_REQUEST_TYPE_GET, null, null);
                    status = response.get(FeedReaderContract.FeedEntry.KEY_NETWORK_CLASS_RESPONSE).getStatuscode();
                }

                return status != -1;
            } catch (Exception e) {
                Log.e("Mypoolin Networkutil", "Error checking internet connection " + e);
            }
        } else {

            Log.d("mypoolin", "No network available!");
        }
        return false;
    }*/

}
