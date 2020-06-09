package com.example.mvvm.paging;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * author:lgh on 2020/6/9 13:59
 */
@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase INSTANCE;

    public static StudentDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, StudentDatabase.class, "student_database")
                    .build();
        }
        return INSTANCE;
    }

    public abstract StudentDao studentDao();

}
