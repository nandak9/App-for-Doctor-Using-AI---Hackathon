package com.app.doctorwork.Util;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.SharedPreferenceEditor;
import com.app.doctorwork.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by abhisheksingh on 11/19/17.
 */

public class AppUtil {

  public static final long TIMEOUT_CONNECT = 30;
  public static final long TIMEOUT_WRITE = 30;
  public static final long TIMEOUT_READ = 30;
  public static final String KEY_REQUEST_UPLOADED_FILE_MULTIPART = "fileupload";
  public static final String KEY_REQUEST_FILE_NAME = "fileName";
  public static final String KEY_REQUEST_FILE_PATH = "filePath";
  public static final String KISANX_ADDVISITS_HIDDEN_FOLDER = ".kisanX/addVisits";
  public static ArrayList<String> uploadUrlList = new ArrayList<>();


  public static boolean containsName(String s, String name) {
    if (s != null && name != null) {
      int l = s.length();
      if (name.length() >= l && name.substring(0, l).equalsIgnoreCase(s)) {
        return true;
      } else {
        String[] names = name.split("[\\s]+");
        for (String n : names) {
          if (n.length() >= l && n.substring(0, l).equalsIgnoreCase(s)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static String removeCountryCode(String number) {
    if (hasCountryCode(number)) {
      // +52 for MEX +526441122345, 13-10 = 3, so we need to remove 3 characters
      int country_digits = number.length() - 10;
      number = number.substring(country_digits);
    }
    return number;
  }

  // Every country code starts with + right?
  public static boolean hasCountryCode(String number) {
    return number.charAt(0) == '+'; // Didn't String had contains() method?...
  }

  public static String getDay(String date_in_string_format) {
    DateFormat df = DateFormat.getDateInstance();
    Date date;
    try {
      date = df.parse(date_in_string_format);
    } catch (Exception e) {
      Log.e("Error:", "Exception " + e);
      return null;
    }
    return new SimpleDateFormat("EEEE").format(date);
  }


  public static String convertToDayDate(String actualDate) {
    Date date = null;
    String month_name = "";
    try {
      SimpleDateFormat month_date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      date = sdf.parse(actualDate);
      month_name = month_date.format(date);
      System.out.println("Month :" + month_name);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return month_name;
  }

  public final static boolean isValidEmail(CharSequence target) {
    return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target)
        .matches();
  }

  public final static boolean isValidMobile(String phone) {
    return android.util.Patterns.PHONE.matcher(phone).matches();
  }

  public static boolean isAlpha(String name) {
    return name.matches("[a-zA-Z]+");
  }


  public static ArrayList<String> getAllShownMediaPath(Activity activity, Uri uri) {
    // For Images
    //// uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    //For Audio
    //uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    //For Video
    // uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    try {
      Cursor cursor;
      int column_index_data, column_index_folder_name;
      ArrayList<String> listOfAllImages = new ArrayList<String>();
      String absolutePathOfImage = null;

      String[] projection = {MediaStore.MediaColumns.DATA,
          MediaStore.Images.Media.BUCKET_DISPLAY_NAME, MediaStore.Images.Media.DEFAULT_SORT_ORDER};

      final String orderBy = MediaStore.Images.Media.DATE_TAKEN;
      cursor = activity.getContentResolver().query(uri, projection, null,
          null, orderBy + " DESC");

      column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

      while (cursor.moveToNext()) {
        absolutePathOfImage = cursor.getString(column_index_data);
        listOfAllImages.add(absolutePathOfImage);
      }
      return listOfAllImages;
    } catch (Exception e) {
      Log.d("Exception", e.toString());
    }
    return null;
  }

  /**
   * This is a public static function which takes absolute path
   * of a file like image (storage/emulated/0/DCIM/hi.jpg) and
   * copies it to ".kisanX/addVisits" folder and returns the path
   * of the new file if copied successfully otherwise return null
   *
   * @param fileAbsolutePath String - Absolute path of the file
   * @return String copied file path or null
   */
  public static String copyFileToHiddenFolder(String fileAbsolutePath) {
    String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

    File createDir = new File(root, KISANX_ADDVISITS_HIDDEN_FOLDER);
    if (!createDir.exists()) {
      createDir.mkdirs();
    }
    // Split the fileAbsolutePath based on `/` to extract file name (last element)
    String[] imageNameSplit = fileAbsolutePath.split("/");
    String imageName = imageNameSplit[imageNameSplit.length - 1];

    // Destination file path
    String destinationFilePath = createDir.getAbsolutePath() + "/" + imageName;

    // Create source and destination file object to read/write
    File sourceFile = new File(fileAbsolutePath);
    File destinationFile = new File(destinationFilePath);

    try {
      // private method to copy file
      copyFile(sourceFile, destinationFile);
      // If destination file exists, means copy successfully therefore
      // return the new absolute path, otherwise return null
      if (destinationFile.exists()) {
        return destinationFile.getAbsolutePath();
      } else {
        return null;
      }
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /*
  A private helper function which takes source file and destination file
  to copy the contents of source to destination.
   */
  private static void copyFile(File sourceFile, File destFile) throws IOException {
    if (!sourceFile.exists()) {
      return;
    }

    FileChannel source = null;
    FileChannel destination = null;
    source = new FileInputStream(sourceFile).getChannel();
    destination = new FileOutputStream(destFile).getChannel();

    if (destination != null && source != null) {
      destination.transferFrom(source, 0, source.size());
    }
    if (source != null) {
      source.close();
    }
    if (destination != null) {
      destination.close();
    }
  }

  /**
   * A function that take Bitmap and save it as JPEG image
   * and returns either null or absoluteFilePath
   */
  public static String saveImage(Bitmap myBitmap, Context context) {

    String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

    File createDir = new File(root, KISANX_ADDVISITS_HIDDEN_FOLDER);
    if (!createDir.exists()) {
      createDir.mkdirs();
    }

    try {
      File f = new File(createDir, "photo_" + Calendar.getInstance()
          .getTimeInMillis() + ".png");
      f.createNewFile();

      FileOutputStream fo = new FileOutputStream(f);
      myBitmap.compress(CompressFormat.JPEG, 100, fo);
      fo.flush();
      fo.close();
      MediaScannerConnection.scanFile(context,
          new String[]{f.getPath()},
          new String[]{"image/png"}, null);
      return f.getAbsolutePath();
    } catch (IOException e1) {
      e1.printStackTrace();
      return null;
    }
  }

  /**
   * A function that take Bitmap and save it as JPEG image
   * and returns either null or absoluteFilePath
   */
  public static String getFilePath(Context context) {

    String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

    File createDir = new File(root, KISANX_ADDVISITS_HIDDEN_FOLDER);
    if (!createDir.exists()) {
      createDir.mkdirs();
    }

    try {
      File f = new File(createDir, "photo_" + Calendar.getInstance()
              .getTimeInMillis() + ".png");
      f.createNewFile();

      FileOutputStream fo = new FileOutputStream(f);
      //myBitmap.compress(CompressFormat.JPEG, 100, fo);
      fo.flush();
      fo.close();
      MediaScannerConnection.scanFile(context,
              new String[]{f.getPath()},
              new String[]{"image/png"}, null);
      return f.getAbsolutePath();
    } catch (IOException e1) {
      e1.printStackTrace();
      return null;
    }
  }

  public static boolean allTrue(boolean[] values) {
    for (boolean value : values) {
      if (!value) {

        return false;
      } else {

      }
    }
    return true;
  }

  public static boolean isAvailable(Context ctx, Intent intent) {
    final PackageManager mgr = ctx.getPackageManager();
    List<ResolveInfo> list =
        mgr.queryIntentActivities(intent,
            PackageManager.MATCH_DEFAULT_ONLY);
    return list.size() > 0;
  }

  public static String getCurrentDateTime24() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, 0);
    Date date = calendar.getTime();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  }

  public static String getCurrentDateTime() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    Date date = new Date();
    return dateFormat.format(date);
  }


  public static String getUserMobile(Context context) {
    return SharedPreferenceEditor
        .getPreferences(context, AppConstants.PREFERENCES_USER, AppConstants.PREFRENCES_MOBILE);
  }

  public static Drawable getDrawableFromText(int position, String data, Context context) {
    String text = "";
    StringBuilder sb = new StringBuilder();
    if (data != null) {
      if (!data.isEmpty()) {
        if (data.contains(" ")) {
          String[] str = data.split("[\\s]+");
          if (str != null && str.length != 0) {
            if (str.length > 0) {
                       /* for (int i = 0; i <str.length; i++) {
                            if (str[i].trim().length() != 0) {
                                sb.append(str[i].trim().substring(0, 1).toUpperCase());
                            }
                        }*/

              if (str[0].trim().length() != 0) {
                sb.append(str[0].trim().substring(0, 1).toUpperCase());
              }
              if (str.length > 1) {
                if (str[1].trim().length() != 0) {
                  sb.append(str[1].trim().substring(0, 1).toUpperCase());
                }
              }
              text = sb.toString();
            } else {
              text = data.substring(0, 1).toUpperCase();
            }

          } else {
            text = data.substring(0, 1).toUpperCase();
          }
        } else {
          text = data.substring(0, 1).toUpperCase();
        }

      } else {
        text = "@";
      }
    } else {
      text = "*";
    }
    int color = context.getResources().getColor(R.color.newKisanxGreen);

    if (position % 4 == 1) {
      color = context.getResources().getColor(R.color.brand_orange);
    }
    if (position % 4 == 2) {
      color = context.getResources().getColor(R.color.brand_color_dark);
    }
    if (position % 4 == 3) {
      color = context.getResources().getColor(R.color.gray);
    }
    return TextDrawable.builder().buildRound(text, color);
  }

  public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int color, int cornerDips,
      int borderDips, Context context) {
    Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
        Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(output);

    final int borderSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
        (float) borderDips,
        context.getResources().getDisplayMetrics());
    final int cornerSizePx = (int) TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) cornerDips,
            context.getResources().getDisplayMetrics());
    final Paint paint = new Paint();
    final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    final RectF rectF = new RectF(rect);

    // prepare canvas for transfer
    paint.setAntiAlias(true);
    paint.setColor(0xFFFFFFFF);
    paint.setStyle(Paint.Style.FILL);
    canvas.drawARGB(0, 0, 0, 0);
    canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);

    // draw bitmap
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawBitmap(bitmap, rect, rect, paint);

    // draw border
    paint.setColor(color);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth((float) borderSizePx);
    canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);

    return output;
  }

  public static int dpTopx(Context context, int dp) {
    return Math.round(
        dp * (context.getResources().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));
  }

  public static void cancelNotification(Context ctx, int notifyId, String TAG) {
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
    nMgr.cancel(TAG, notifyId);
  }

  public static boolean sendSMS(String phoneNo, String msg) {
    try {
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNo, null, msg, null, null);
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }

  public static void hideKeybord(Context context, View view) {
    InputMethodManager inputManager = (InputMethodManager) context
        .getSystemService(context.INPUT_METHOD_SERVICE);
    inputManager.hideSoftInputFromWindow(view.getWindowToken(),
        InputMethodManager.RESULT_UNCHANGED_SHOWN);
  }

  public static void openImageInGallery(Context context, File file) {

    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
    StrictMode.setVmPolicy(builder.build());

    Intent galleryIntent = new Intent(Intent.ACTION_VIEW,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    galleryIntent.setDataAndType(Uri.fromFile(file), "image/*");
    galleryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    galleryIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    context.startActivity(galleryIntent);
  }

  public static void shareMessage(Context context, String message) {
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, message);
    sendIntent.setType("text/plain");
    context.startActivity(sendIntent);
  }

  public static void shareImages(Context context, String authority, ArrayList<String> paths) {
    ArrayList<Uri> imageUris = new ArrayList<>();
    for (String path : paths) {
      if (path.startsWith("file:///")) {
        path = path.substring(8);
      }
      File img = new File(path);
      if (img.exists()) {
        Uri uri = FileProvider.getUriForFile(context, authority, img);
        imageUris.add(uri);
      }
    }
    Intent shareIntent = new Intent();
    shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
    shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
    shareIntent.setType("image/*");
    context.startActivity(shareIntent);
  }

  public static void shareAudios(Context context, String authority, ArrayList<String> paths) {
    ArrayList<Uri> audiosUri = new ArrayList<>();
    for (String path : paths) {
      if (path.startsWith("file:///")) {
        path = path.substring(8);
      }
      File audio = new File(path);
      if (audio.exists()) {
        Uri uri = FileProvider.getUriForFile(context, authority, audio);
        audiosUri.add(uri);
      }
    }
    Intent shareIntent = new Intent();
    shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
    shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, audiosUri);
    shareIntent.setType("audio/*");
    context.startActivity(shareIntent);
  }


  public static byte[] getFileDataFromDrawable(Bitmap bitmap) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

}
