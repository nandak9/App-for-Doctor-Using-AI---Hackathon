package com.app.doctorwork.FCM;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Util.Log;


/**
 * Created by abhisheksingh on 4/11/17.
 */

public class NotificationCTAReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (AppConstants.YES_ACTION.equals(action)) {
            Log.v("shuffTest", "Pressed YES");
        } else if (AppConstants.NO_ACTION.equals(action)) {
            Log.v("shuffTest", "Pressed NO");
        }
    }
}
