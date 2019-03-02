package com.app.doctorwork.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.SharedPreferenceEditor;
import com.app.doctorwork.Main.ApplicationSingleton;
import com.app.doctorwork.Objects.RobototextViewRegular;
import com.app.doctorwork.R;
import com.app.doctorwork.Util.Log;
import com.app.doctorwork.Util.AppUtil;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONObject;


/**
 * Created by abhisheksingh on 11/15/17.
 */

public class EnterNumber extends AppCompatActivity {

    private static final String TAG = EnterNumber.class.getSimpleName();
    public static int APP_REQUEST_CODE_SMS = 99;
    public static int APP_REQUEST_CODE_EMAIL = 98;
    private static final int LOCATION = 3;
    //TrueClient mTrueClient;
    //TrueButton mTrueButton;
    Context context;

    String fbMobileFetched = "";
    AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = EnterNumber.this;
        setContentView(R.layout.enter_number_activity);
        RelativeLayout mainLayout= findViewById(R.id.mainLayout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(EnterNumber.this, R.color.brand_color_dark));
            getWindow().setNavigationBarColor(ContextCompat.getColor(EnterNumber.this, R.color.brand_color_dark));
        }

        phoneLogin(mainLayout);


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AccountKitLoginResult loginResult;
        String toastMessage = "";

        if (requestCode == APP_REQUEST_CODE_SMS) { // confirm that this response matches your request
            loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            if (loginResult.getError() != null) {
                toastMessage = loginResult.getError().getErrorType().getMessage();
            } else if (loginResult.wasCancelled()) {
                Toast.makeText(context, R.string.login_cancelled, Toast.LENGTH_SHORT).show();
            } else {
                if (loginResult.getAccessToken() != null) {
                    //toastMessage = "Success";// + loginResult.getAccessToken().getAccountId();
                } else {

                    //toastMessage = String.format("Success:%s...",loginResult.getAuthorizationCode().substring(0, 10));
                    //toastMessage = "Success";
                }


                AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                    @Override
                    public void onSuccess(final Account account) {
                        // Get Account Kit ID
                        String accountKitId = account.getId();
                        Log.d("fbLoginKit", accountKitId);

                        // Get phone number
                        PhoneNumber phoneNumber = account.getPhoneNumber();
                        if (phoneNumber != null) {
                            String phoneNumberString = phoneNumber.toString().trim();
                            Log.d("fbLoginKit", phoneNumberString);
                            fbMobileFetched = AppUtil.removeCountryCode(phoneNumberString);
                            SharedPreferenceEditor.setPreferences(EnterNumber.this, AppConstants.PREFERENCES_USER, AppConstants.PREFRENCES_MOBILE, fbMobileFetched);
                            postUserCall();
                            //getLocation();
                        }

                           /* // Get email
                            String email = account.getEmail();

                            Log.d("fbLoginKit",email);*/
                    }

                    @Override
                    public void onError(final AccountKitError error) {
                        // Handle Error
                        Log.d("fbLoginKit", "errod received");
                        Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show();
                    }
                });

            }

            // Surface the result to your user in an appropriate way.
                /*Toast.makeText(
                        this,
                        toastMessage,
                        Toast.LENGTH_LONG)
                        .show();*/
        }

    }

    private void postUserCall() {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            SharedPreferenceEditor.setPreferences(EnterNumber.this, AppConstants.PREFERENCES_USER, AppConstants.PREFRENCES_MOBILE, fbMobileFetched);
            String URL = "http://ec2-13-127-214-8.ap-south-1.compute.amazonaws.com/user";
            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("mobile", fbMobileFetched);
            jsonBody.put("fcmToken", FirebaseInstanceId.getInstance().getId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key", "value");// Here in Value I can put a Json object
            jsonBody.put("data", jsonObject);
            Log.d("VOLLEY", jsonBody.toString());

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    if (jsonBody != null) {
                        Log.d("VOLLEY", jsonBody.toString());
                        //return encodeParameters(jsonBody, getParamsEncoding());
                        return jsonBody.toString().getBytes();
                    }
                    return null;

                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);

                        Toast.makeText(context, "Welcome Doctor for a Better Change", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(EnterNumber.this,HomeActivity.class);
                        startActivity(intent);
                        EnterNumber.this.finish();
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, SplashScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("exit", true);
        startActivity(intent);
        finish();
    }

    public void phoneLogin(final View view) {
        final Intent intent = new Intent(EnterNumber.this, AccountKitActivity.class);
        configurationBuilder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(
                        LoginType.PHONE,
                        AccountKitActivity.ResponseType.TOKEN); // or .ResponseType.TOKEN
        // ... perform additional configuration ...
        intent.putExtra(
                AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                configurationBuilder.build());
        startActivityForResult(intent, APP_REQUEST_CODE_SMS);
    }


}


