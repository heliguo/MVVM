package com.example.mvvm.paging;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * author:lgh on 2020/6/9 14:01
 */
@Dao
public interface StudentDao {

    @Insert
    void insertStudents(Student... students);

    @Query("delete from student_table")
    void deletAllStudents();

    @Query("select * from student_table order by id")
    DataSource.Factory<Integer, Student> getAllStudents();

}
