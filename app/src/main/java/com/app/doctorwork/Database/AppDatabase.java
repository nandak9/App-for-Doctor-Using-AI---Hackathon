package com.app.doctorwork.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {PostCall.class, NotificationAlert.class}, version = 4, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PostCallDao postCallDao();

    public abstract NotificationAlertDao mNotificationAlertDao();
}
