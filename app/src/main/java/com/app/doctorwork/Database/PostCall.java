package com.app.doctorwork.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "post_call")
public class PostCall {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String url;

    private String jsonObject;

    public PostCall(String url, String jsonObject) {
        this.url = url;
        this.jsonObject = jsonObject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }
}
