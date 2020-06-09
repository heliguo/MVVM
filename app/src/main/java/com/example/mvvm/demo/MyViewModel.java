package com.example.mvvm.demo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * author:lgh on 2020/6/5 10:55
 */
public class MyViewModel extends ViewModel {

    String userName;

    private MutableLiveData<List<User>> mMutableUsers;

    public LiveData<List<User>> getUsers() {

        if (mMutableUsers == null) {
            mMutableUsers = new MutableLiveData<>();
            loadUsers();
        }

        return mMutableUsers;

    }

    private void loadUsers() {

    }

    public void setMutableUsers(List<User> users){
        mMutableUsers.setValue(users);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
