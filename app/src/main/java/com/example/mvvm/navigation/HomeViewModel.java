package com.example.mvvm.navigation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@SuppressWarnings("ConstantConditions")
public class HomeViewModel extends ViewModel {

    private MutableLiveData<Integer> mData;

    public MutableLiveData<Integer> getNumber() {
        if (mData == null) {
            mData = new MutableLiveData<>();
            mData.setValue(0);
        }
        return mData;
    }

    public void add(int num) {
        mData.setValue(mData.getValue() + num);
        if (mData.getValue() < 0) {
            mData.setValue(0);
        }
    }
}