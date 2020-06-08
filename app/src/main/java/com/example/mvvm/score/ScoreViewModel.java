package com.example.mvvm.score;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * author:lgh on 2020/6/8 10:42
 */
@SuppressWarnings("ConstantConditions")
public class ScoreViewModel extends AndroidViewModel {

    //    private MutableLiveData<Integer> aTeamScore;
    //    private MutableLiveData<Integer> bTeamScore;
    private int aBack, bBack;
    private SavedStateHandle handle;
    private String           akey   = "akey";
    private String           bkey   = "bkey";
    private String           spName = "SP_NAME";


    public ScoreViewModel(Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(akey)) {
            loadAData();
        }
        if (!handle.contains(bkey)) {
            loadBData();
        }

    }

    private void loadBData() {
        SharedPreferences sp = getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        handle.set(bkey, sp.getInt(bkey, 0));
    }

    private void loadAData() {
        SharedPreferences sp = getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        handle.set(akey, sp.getInt(akey, 0));
    }

    public MutableLiveData<Integer> getaTeamScore() {
        if (!handle.contains(akey)) {
            handle.set(akey, 0);
        }
        return handle.getLiveData(akey);
        //        if (aTeamScore == null) {
        //            aTeamScore = new MutableLiveData<>();
        //            aTeamScore.setValue(0);
        //        }
        //        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (!handle.contains(bkey)) {
            handle.set(bkey, 0);
        }
        return handle.getLiveData(bkey);
        //        if (bTeamScore == null) {
        //            bTeamScore = new MutableLiveData<>();
        //            bTeamScore.setValue(0);
        //        }
        //        return bTeamScore;
    }

    public void aTeamAdd(int num) {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(aBack + num);
    }

    public void bTeamAdd(int num) {
        bBack = getbTeamScore().getValue();
        aBack = getaTeamScore().getValue();
        getbTeamScore().setValue(bBack + num);
    }

    public void reset() {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(0);
        getbTeamScore().setValue(0);
    }

    public void undo() {
        getbTeamScore().setValue(bBack);
        getaTeamScore().setValue(aBack);
    }

    public void save() {
        SharedPreferences sp = getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(akey, getaTeamScore().getValue());
        edit.putInt(bkey, getbTeamScore().getValue());
        edit.apply();
    }

}
