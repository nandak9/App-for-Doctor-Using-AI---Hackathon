package com.app.doctorwork.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author Ravindra Barthwal
 */
@Entity(tableName = "notification_alert")
public class NotificationAlert {

  @PrimaryKey(autoGenerate = true)
  private int id;
  private String poolid;
  private String title;
  private String message;
  private String pooltype;
  private String theme;
  private int imagetype;
  private String dateTime;
  private String imageurl;
  private String type;
  private String deepLink;

  public NotificationAlert(String poolid, String title, String message, String pooltype,
      String theme, int imagetype, String dateTime, String imageurl, String type,
      String deepLink) {
    this.poolid = poolid;
    this.title = title;
    this.message = message;
    this.pooltype = pooltype;
    this.theme = theme;
    this.imagetype = imagetype;
    this.dateTime = dateTime;
    this.imageurl = imageurl;
    this.type = type;
    this.deepLink = deepLink;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPoolid() {
    return poolid;
  }

  public void setPoolid(String poolid) {
    this.poolid = poolid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPooltype() {
    return pooltype;
  }

  public void setPooltype(String pooltype) {
    this.pooltype = pooltype;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public int getImagetype() {
    return imagetype;
  }

  public void setImagetype(int imagetype) {
    this.imagetype = imagetype;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setExpiry(String dateTime) {
    this.dateTime = dateTime;
  }

  public String getImageurl() {
    return imageurl;
  }

  public void setImageurl(String imageurl) {
    this.imageurl = imageurl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDeepLink() {
    return deepLink;
  }

  public void setDeepLink(String deepLink) {
    this.deepLink = deepLink;
  }
}