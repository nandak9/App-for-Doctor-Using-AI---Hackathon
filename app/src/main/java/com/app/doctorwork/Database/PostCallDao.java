package com.app.doctorwork.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PostCallDao {

    @Query("SELECT * FROM post_call")
    List<PostCall> getAll();

    @Insert
    void insert(PostCall postCall);

    @Delete
    void delete(PostCall postCall);

}
