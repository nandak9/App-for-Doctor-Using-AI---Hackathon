package com.app.doctorwork.Main;

import android.app.Activity;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.os.Bundle;

import com.app.doctorwork.Database.AppDatabase;
import com.app.doctorwork.Database.AppExecutors;


/**
 * Created by abhisheksingh on 11/24/17.
 */

public class ApplicationSingleton extends Application implements  Application.ActivityLifecycleCallbacks{

    private static ApplicationSingleton mInstance;
    Activity currentActivity;
    private AppDatabase appDatabase;
    private AppExecutors appExecutors = new AppExecutors();

    public AppExecutors getAppExecutors() {
        return appExecutors;
    }
    public AppDatabase getAppDatabase() {
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "doctorapp-db").fallbackToDestructiveMigration().build();
        }
        return appDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //getStateList();
    }

    public static synchronized ApplicationSingleton getInstance() {
        return mInstance;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
