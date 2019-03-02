package com.app.doctorwork.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.Permissions;
import com.app.doctorwork.Common.SharedPreferenceEditor;
import com.app.doctorwork.R;
import com.app.doctorwork.Util.Log;
import java.util.Arrays;

public class SplashScreen extends AppCompatActivity {

    boolean granted=false;
    int permissionFalseCount = 0;
    boolean[] permissionsAlertShown = new boolean[9];
    AlertDialog alertDialogPermissions2, alertDialogPermissions3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        initializeProcess();
    }

    private void gotToEnterNumber(){
        Intent intent = new Intent(SplashScreen.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToHomeActivity(){
        Intent intent = new Intent(SplashScreen.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case AppConstants.PERMISSION_REQUEST_GRANT:
                int resLen = permissions.length;
                permissionFalseCount = 0;//reset count for each new perm request
                Arrays.fill(permissionsAlertShown, true);
                for (int i = 0; i < resLen; i++) {
                    Log.i("permissionResult", "" + grantResults[i]);
                    Log.i("permissions", "" + permissions[i]);
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        //all ok
                        granted = true;
                        initializeProcess();

                    } else {
                        if (Build.VERSION.SDK_INT >= 23) {
                            //permissionFalseCount++;
                            boolean showRationale = shouldShowRequestPermissionRationale(permissions[i]);
                            if (!showRationale) {
                                granted = false;

                                switch (permissions[i]) {
                                    case Manifest.permission.RECEIVE_SMS:
                                    case Manifest.permission.READ_SMS:
                                        permissionsAlertShown[0] = false;
                                        permissionsAlertShown[1] = false;
                                        alertDialogPermissions2 = Permissions.openPermissions(SplashScreen.this, getString(
                                                R.string.sms_permission_required), getString(
                                                R.string.sms_permission_message));
                                        break;
                                    case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                                    case Manifest.permission.READ_EXTERNAL_STORAGE:
                                        permissionsAlertShown[2] = false;
                                        permissionsAlertShown[3] = false;
                                        alertDialogPermissions3 = Permissions.openPermissions(SplashScreen.this, getString(R.string.external_storage_permission), getString(
                                                R.string.storage_permission_message));
                                        break;
                                    case Manifest.permission.CAMERA:
                                        permissionsAlertShown[4] = false;
                                        Permissions.openPermissions(SplashScreen.this, getString(R.string.camera_permission), getString(
                                                R.string.camera_permission_message));
                                        break;

                                    case Manifest.permission.RECORD_AUDIO:
                                        permissionsAlertShown[5] = false;
                                        Permissions.openPermissions(SplashScreen.this, getString(R.string.audio_permission), getString(
                                                R.string.audio_permission_message));
                                        break;
                                }
                            } else {
                                granted = true;
                                initializeProcess();
                            }

                        } else {
                            granted = true;
                            initializeProcess();
                        }
                    }
                }
                //initializeProcess();
                break;
        }

    }


    private void initializeProcess() {
        if(Permissions.checkPermissions(SplashScreen.this,Permissions.PERMISSION_ESSENTIAL)) {
            //Permissions.
            if(TextUtils.isEmpty(SharedPreferenceEditor.getPreferences(this, AppConstants.PREFERENCES_USER,AppConstants.PREFRENCES_MOBILE))){
                gotToEnterNumber();
            }else{
                goToHomeActivity();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
