package com.app.doctorwork.Notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

import com.app.doctorwork.Database.NotificationAlert;
import com.app.doctorwork.Main.ApplicationSingleton;
import com.app.doctorwork.MainActivity;
import com.app.doctorwork.R;
import com.app.doctorwork.Util.AppUtil;
import com.app.doctorwork.Util.Log;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by abhisheksingh on 3/8/18.
 */

public class NotificationIntentHelper {

  static String channelKisanx = "PatientApp";

  public static void sendNotification(Context context, RemoteMessage remoteMessage) {
    NotificationCompat.Builder builder;
    NotificationManager manager;

    String title = "kisanX", message = "", deeplink = "", imageUrl = "", userName = "", invisible = "", silent = "";
    String btn1Deeplink = "", notificationType = "", showActionBtn = "", btn1Text = "", btn2Deeplink = "", btn2Text = "";
    String id = "";
    int showImage = 0;

    if (remoteMessage.getData().containsKey("title")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("title"))) {
        title = remoteMessage.getData().get("title");
        Log.d("FCM_Data", title);
      }
    }

    if (remoteMessage.getData().containsKey("message")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("message"))) {
        message = remoteMessage.getData().get("message");
        Log.d("FCM_Data", message);
      }
    }

    if (remoteMessage.getData().containsKey("deeplink")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("deeplink"))) {
        deeplink = remoteMessage.getData().get("deeplink");
        deeplink = deeplink.toLowerCase();
        Log.d("FCM_Data", deeplink);
      }
    }

    if (remoteMessage.getData().containsKey("id")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("id"))) {
        id = remoteMessage.getData().get("id");
      }
    }

    if (remoteMessage.getData().containsKey("showImage")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("showImage"))) {
        showImage = Integer.parseInt(remoteMessage.getData().get("showImage"));
        Log.d("FCM_Data", showImage + "");
      }
    }

    if (remoteMessage.getData().containsKey("imageUrl")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("imageUrl"))) {
        imageUrl = remoteMessage.getData().get("imageUrl");
        Log.d("FCM_Data", imageUrl);
      }
    }
    //String id = remoteMessage.getData().get("notId");
    if (remoteMessage.getData().containsKey("userName")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("userName"))) {
        userName = remoteMessage.getData().get("userName");
        Log.d("FCM_Data", userName);
      }
    }

    if (remoteMessage.getData().containsKey("invisible")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("invisible"))) {
        invisible = remoteMessage.getData().get("invisible");
        Log.d("FCM_Data", Integer.parseInt(invisible) + "");
      }
    }

    if (remoteMessage.getData().containsKey("silent")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("silent"))) {
        silent = remoteMessage.getData().get("silent");
      }
      Log.d("FCM_Data", Integer.parseInt(silent) + "");
    }

    if (remoteMessage.getData().containsKey("notificationType")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("notificationType"))) {
        notificationType = remoteMessage.getData().get("notificationType");
        Log.d("FCM_Data", notificationType + "");
      }
    }

    if (remoteMessage.getData().containsKey("showActionBtn")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("showActionBtn"))) {
        showActionBtn = remoteMessage.getData().get("showActionBtn");
        Log.d("FCM_Data", showActionBtn + "");
      }
    }

    if (remoteMessage.getData().containsKey("btn1")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("btn1"))) {
        btn1Text = remoteMessage.getData().get("btn1");
        Log.d("FCM_Data", btn1Text + "");
      }
    }

    if (remoteMessage.getData().containsKey("btn2")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("btn2"))) {
        btn2Text = remoteMessage.getData().get("btn2");
        Log.d("FCM_Data", btn2Text + "");
      }
    }

    if (remoteMessage.getData().containsKey("btn1Deeplink")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("btn1Deeplink"))) {
        btn1Deeplink = remoteMessage.getData().get("btn1Deeplink");
        Log.d("FCM_Data", btn1Deeplink);
      }
    }

    if (remoteMessage.getData().containsKey("btn2Deeplink")) {
      if (!TextUtils.isEmpty(remoteMessage.getData().get("btn2Deeplink"))) {
        btn2Deeplink = remoteMessage.getData().get("btn2Deeplink");
        Log.d("FCM_Data", btn2Deeplink);
      }
    }

    String channelId = context.getString(R.string.default_notification_channel_id);

    Intent notificationIntent = new Intent(context, MainActivity.class);
    notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    notificationIntent.putExtra("deeplinkdata", deeplink);

    PendingIntent contentIntent = PendingIntent.getActivity(context,
        0, notificationIntent,
        PendingIntent.FLAG_ONE_SHOT);

    builder = new NotificationCompat.Builder(context, channelId);
    manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
    int i = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

    //Uri sound=  Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.whistle);
    //builder.setSound(sound);

    if (Integer.parseInt(silent) == 0) {
      builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
      builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
    }

  /*  if (!TextUtils.isEmpty(btn1Text)) {
      Intent notifyIntentAction1 = new Intent(context, MainActivity.class);
      notifyIntentAction1.setAction(AppConstants.YES_ACTION);
      PendingIntent pendingIntentYes = PendingIntent.getActivity(context, i, notifyIntentAction1,
          PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_ONE_SHOT);
      builder.addAction(R.mipmap.ic_launcher, btn1Text, pendingIntentYes);
    }

    if (!TextUtils.isEmpty(btn2Text)) {
      Intent notifyIntentAction2 = new Intent(context, MainActivity.class);
      notifyIntentAction2.putExtra("search", "false");
      notifyIntentAction2.putExtra("notificationId", i);
      notifyIntentAction2.putExtra("userInput", 0);
      notifyIntentAction2.putExtra("notificationType", notificationType);
      notifyIntentAction2.setAction(AppConstants.NO_ACTION);
      PendingIntent pendingIntentNo = PendingIntent.getActivity(context, i, notifyIntentAction2,
          PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_ONE_SHOT);
      builder.addAction(R.mipmap.ic_launcher, btn2Text, pendingIntentNo);
    }*/

    builder.setContentTitle(title)
        .setContentText(message)
        .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
        .setTicker(title)
        .setColor(context.getResources().getColor(R.color.brand_color))
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentIntent(contentIntent)
        .setWhen(System.currentTimeMillis())
        .setChannelId(channelId)
        .setAutoCancel(true);

    if (!TextUtils.isEmpty(imageUrl)) {
      URL url = null;
      try {
        url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream input = connection.getInputStream();
        Bitmap myBitmap = BitmapFactory.decodeStream(input);
        builder.setLargeIcon(myBitmap);
        builder.setStyle(
            new NotificationCompat.BigPictureStyle().setSummaryText(message).bigPicture(myBitmap))
            .setContentIntent(contentIntent);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

      /* Create or update. */
      NotificationChannel channel = new NotificationChannel(channelId,
          channelKisanx,
          NotificationManager.IMPORTANCE_HIGH);
      manager.createNotificationChannel(channel);
    }

//        Uri sound=  Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.whistle);
//        builder.setSound(sound);
//        builder.setSound(sound);
    if (Integer.parseInt(invisible) == 0) {
      final NotificationAlert notificationAlert = new NotificationAlert(id, title, message,
          notificationType, "kisanx_Theme", showImage, AppUtil.getCurrentDateTime(), imageUrl,
          notificationType, deeplink);

      ApplicationSingleton.getInstance().getAppExecutors().diskIO().execute(new Runnable() {
        @Override
        public void run() {
          ApplicationSingleton.getInstance().getAppDatabase()
              .mNotificationAlertDao()
              .insert(notificationAlert);
        }
      });

      Notification notification = builder.build();
      notification.flags = Notification.FLAG_AUTO_CANCEL /*| Notification.FLAG_INSISTENT*/;
      Log.d("notification", String.valueOf(i));
      manager.notify(notificationType, i, notification);
    }

  }


}
