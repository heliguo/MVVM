package com.example.mvvm.demo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

/**
 * author:lgh on 2020/6/8 21:23
 */
@Dao
interface LiveDataUserDao {

    @Query("SELECT * FROM USER ORDER BY UID DESC")
    LiveData<List<User>> getAll();
}
