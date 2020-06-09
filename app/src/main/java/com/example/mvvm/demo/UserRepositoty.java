package com.example.mvvm.demo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

/**
 * author:lgh on 2020/6/8 21:45
 */
public class UserRepositoty {

    private LiveData<List<User>> allUsers;

    public UserRepositoty(Context context) {
        AppDatabase userDb = Room.databaseBuilder(context, AppDatabase.class,
                "user")
                //添加数据库变动迁移
                //                .addMigrations(AppDatabase.MIGRATION_1_2)
                //下面注释表示允许主线程进行数据库操作，但是不推荐这样做。
                //他可能造成主线程lock以及anr
                // .allowMainThreadQueries()
                .build();
    }
}
