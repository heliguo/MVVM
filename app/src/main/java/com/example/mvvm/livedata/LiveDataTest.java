package com.example.mvvm.livedata;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;


/**
 * @author lgh on 2020/11/9 14:27
 * @description
 */
public class LiveDataTest {


    MutableLiveData<User> mUserLiveData = new MutableLiveData<>();
    MutableLiveData<String> data = new MutableLiveData<>();


    public MutableLiveData<String> getData() {
        return (MutableLiveData<String>) Transformations.map(mUserLiveData, new Function<User, String>() {
            @Override
            public String apply(User input) {
                return input.age + input.name;
            }
        });
    }

    public MutableLiveData<User1> get(){
        return (MutableLiveData<User1>) Transformations.switchMap(mUserLiveData, new Function<User, LiveData<User1>>() {
            @Override
            public MutableLiveData<User1> apply(User input) {
                return null;
            }
        });
    }


    static class User {

        public String name;

        public int age;

    }

    static class User1 {

        public String name;

        public int age;

    }

}
