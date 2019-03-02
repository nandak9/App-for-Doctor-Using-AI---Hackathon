package com.app.doctorwork.FCM;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.SharedPreferenceEditor;
import com.app.doctorwork.Util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhisheksingh on 1/30/18.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";
    RequestQueue requestQueue;

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        postFCMToken(token);
    }


    private void postFCMToken(String fcmToken) {
        requestQueue = Volley.newRequestQueue(this);
        String jsonUrl = AppConstants.BASE_URL_MAIN + "/token" ;
        Log.d("jsonurl",jsonUrl);

        JSONObject postparams=new JSONObject();
        try {
            postparams.put("token",fcmToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,jsonUrl,postparams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("200") || response.getString("status").equals("200")) {
                        //int objectCount = response.getInt("count");
                    }else{
                       // Toast.makeText(MyFirebaseInstanceIDService.this, response.getString("status") +" Token Not Updated" , Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(MyFirebaseInstanceIDService.this, " Token Not Updated" , Toast.LENGTH_SHORT).show();
            }
        })
        {

            /** Passing some request headers* */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("sessionId", SharedPreferenceEditor.getPreferences(MyFirebaseInstanceIDService.this, AppConstants.PREFERENCES_USER, AppConstants.PREFERENCES_SESSION_ID));
                headers.put("consumerKey", SharedPreferenceEditor.getPreferences(MyFirebaseInstanceIDService.this, AppConstants.PREFERENCES_USER, AppConstants.PREFRENCES_MOBILE));
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }


}