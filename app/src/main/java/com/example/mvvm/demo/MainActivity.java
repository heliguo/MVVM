package com.example.mvvm.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.mvvm.databinding.ActivityViewBindingBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityViewBindingBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = ActivityViewBindingBinding.inflate(getLayoutInflater());
        setContentView(mActivityMainBinding.getRoot());
        /**
         * params 上下文、表实体、数据库名
         */
        AppDatabase userDb = Room.databaseBuilder(this, AppDatabase.class,
                "user")
                //添加数据库变动迁移
                //                .addMigrations(AppDatabase.MIGRATION_1_2)
                //下面注释表示允许主线程进行数据库操作，但是不推荐这样做。
                //他可能造成主线程lock以及anr
                // .allowMainThreadQueries()
                //                .fallbackToDestructiveMigration()//可用于修改数据库增加字段，但会强制清除所有数据
                .build();
        UserDao userDao = userDb.userDao();
        User user1 = new User();
        user1.firstName = "111";
        user1.lastName = "2222";
        User user2 = new User();
        user2.firstName = "111";
        user2.lastName = "2222";
        userDao.insertAll(user1, user2);
        List<User> users = userDao.getAll();
        for (User user : users) {
            Log.e("TAG", "onCreate: " + user.firstName);
        }
    }
}
